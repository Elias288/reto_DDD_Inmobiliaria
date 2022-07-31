package com.inmobiliriaDDD.promotionsection;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.inmobiliariadomain.promotionsection.commands.UpdateEstablishmentAddress;
import com.inmobiliariadomain.promotionsection.events.*;
import com.inmobiliariadomain.promotionsection.usecases.UpdatedEstablishmentAddresUseCase;
import com.inmobiliariadomain.promotionsection.values.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UpdateEstablishmentAddressCaseTest {

    @InjectMocks
    private UpdatedEstablishmentAddresUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void UpdateEstablishmentAddress(){
        //arrange
        PairingID fakePairingID = PairingID.of("fakePairingID");

        EstablishmentID fakeEstablishmentID = EstablishmentID.of("fakeEstablishmentID");
        Address fakeAddress = new Address("Rio Negro 1734");

        var command = new UpdateEstablishmentAddress(fakePairingID, fakeEstablishmentID, fakeAddress);

        when(repository.getEventsBy("fakePairingID")).thenReturn(List.of(
                new PairingCreated(new Date()),
                new EstablishmentAdded(EstablishmentID.of("fakeEstablishment"), new Address("Rio negro 1743")),

                new OfferAdded(OfferID.of("fakeOfferID"), new OfferDate(new Date(2022, 07, 10))),
                new OfferAdded(OfferID.of("fakeOfferID2"), new OfferDate(new Date(2022, 05, 10))),

                new InterestedAdded(InterestedID.of("fakeInterestedID"), new Name("Yulieth"), new QueryType(QueryTypeEnum.RENTAL), new Contact("Yulieth@gmail.com"))
        ));

        useCase.addRepository(repository);

        //act
        List<DomainEvent> domainEvents = UseCaseHandler.getInstance()
                .setIdentifyExecutor("fakePairingID")
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (EstablishmentAddresUpdated) domainEvents.get(0);

        assertEquals("fakeEstablishmentID", event.getEstablishmentID().value());
        assertEquals("Rio Negro 1734", event.getAddress().value());

        verify(repository).getEventsBy("fakePairingID");
    }
}

