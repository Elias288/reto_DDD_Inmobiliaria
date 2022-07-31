package com.inmobiliriaDDD.promotionsection;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.inmobiliariadomain.promotionsection.commands.UpdateInterestedContact;
import com.inmobiliariadomain.promotionsection.commands.UpdateInterestedName;
import com.inmobiliariadomain.promotionsection.events.*;
import com.inmobiliariadomain.promotionsection.usecases.UpdatedInterestedContactUseCase;
import com.inmobiliariadomain.promotionsection.usecases.UpdatedInterestedNameUseCase;
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
class UpdateInterestedContactCaseTest {

    @InjectMocks
    private UpdatedInterestedContactUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void updateOfferDate(){
        //arrange
        PairingID fakePairingID = PairingID.of("fakePairingID");

        InterestedID fakeInterestedID = InterestedID.of("fakeInterestedID");
        Contact fakeContact = new Contact("yulieth@hotmail.com");


        var command = new UpdateInterestedContact(fakePairingID, fakeInterestedID, fakeContact);

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
        var event = (InterestedContactUpdated) domainEvents.get(0);

        assertEquals("fakeInterestedID", event.getInterestedID().value());
        assertEquals("yulieth@hotmail.com", event.getContact().value());

        verify(repository).getEventsBy("fakePairingID");
    }
}

