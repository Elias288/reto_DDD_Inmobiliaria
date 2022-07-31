package com.inmobiliriaDDD.local;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.TriggeredEvent;
import com.inmobiliariadomain.local.events.ManagementCreated;
import com.inmobiliariadomain.local.events.NotifyManagementCreated;
import com.inmobiliariadomain.local.events.PropertyAdded;
import com.inmobiliariadomain.local.usecases.NotifyManagementCreactedUseCase;
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
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class NotifyManagementCreatedCaseTest {
    @InjectMocks
    private NotifyManagementCreactedUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void notifyPropertyAdded(){
        //arrrange
        PairingID fakePairingID = PairingID.of("fakePairingID");
        InitialDate fakeInitialDate = new InitialDate(new Date(2022, 6, 12));

        var event = new ManagementCreated(fakeInitialDate, fakePairingID);
        event.setAggregateRootId("DDDD");

        when(repository.getEventsBy("DDDD")).thenReturn(List.of(event));
        useCase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(event.aggregateRootId())
                .syncExecutor(useCase, new TriggeredEvent<>(event))
                .orElseThrow()
                .getDomainEvents();

        //asserts
        var contract = (NotifyManagementCreated) events.get(0);
        assertEquals("La administracion se ha creado exitosamente", contract.getNotify());
    }
}
