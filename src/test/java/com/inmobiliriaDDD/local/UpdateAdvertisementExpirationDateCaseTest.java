package com.inmobiliriaDDD.local;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.inmobiliariadomain.local.commands.UpdateAdvertisementExpirationDate;
import com.inmobiliariadomain.local.events.*;
import com.inmobiliariadomain.local.usecases.UpdatedAdvertisementExpirationDateUseCase;
import com.inmobiliariadomain.local.values.*;
import com.inmobiliariadomain.promotionsection.values.PairingID;
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
class UpdateAdvertisementExpirationDateCaseTest {

    @InjectMocks
    private UpdatedAdvertisementExpirationDateUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void updateAdvertisementExpirationDate(){
        //arrange
        ManagementID fakeManagementID = ManagementID.of("fakeManagementID");

        AdvertisementID fakeAdvertisementID = AdvertisementID.of("fakeAdvertisementID");
        ExpirationDate updateExpirationDate = new ExpirationDate(new Date(2022, 11, 5));

        var command = new UpdateAdvertisementExpirationDate(fakeAdvertisementID, fakeManagementID, updateExpirationDate);

        when(repository.getEventsBy("fakeManagementID")).thenReturn(List.of(
                new ManagementCreated(new InitialDate(new Date()), new PairingID("fakePairingID")),
                new PropertyAdded(PropertyID.of("fakePropertyID"), new Price(14500), new Address("Republica Argentina 2134"), new PropertyType(PropertyTypeEnum.APARTMENT), new Area(60)),
                new PropertyAdded(PropertyID.of("fakePropertyID2"), new Price(10000), new Address("Leandro Gomez 2454"), new PropertyType(PropertyTypeEnum.APARTMENT), new Area(20)),
                new PropertyAdded(PropertyID.of("fakePropertyID3"), new Price(50500), new Address("18 de julio 6546"), new PropertyType(PropertyTypeEnum.HOUSE), new Area(35)),

                new OwnerAdded(new OwnerID("fakeOwnerID"), new Name("Elias Bianchi"), new Debit(20000), new Contact("bianchi.elias@gmail.com")),

                new AdvertisementAdded(AdvertisementID.of("fakeAdvertisementID"), new ExpirationDate(new Date(2022, 9, 18))),
                new AdvertisementAdded(AdvertisementID.of("fakeAdvertisementID2"), new ExpirationDate(new Date(2022, 10, 25)))
        ));

        useCase.addRepository(repository);

        //act
        List<DomainEvent> domainEvents = UseCaseHandler.getInstance()
                .setIdentifyExecutor("fakeManagementID")
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (AdvertisementExpirationDateUpdated) domainEvents.get(0);

        assertEquals("fakeAdvertisementID", event.getAdvertisementID().value());
        assertEquals(new Date(2022, 11, 5), event.getExpirationDate().value());

        verify(repository).getEventsBy("fakeManagementID");
    }
}

