package com.inmobiliriaDDD.proposal;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.TriggeredEvent;
import com.inmobiliariadomain.local.values.PropertyID;
import com.inmobiliariadomain.proposal.events.ContractCreated;
import com.inmobiliariadomain.proposal.events.NotifyContractCreated;
import com.inmobiliariadomain.proposal.usecases.NotifyContractCreatedUseCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class NotifyContractCreatedCaseTest {
    @InjectMocks
    private NotifyContractCreatedUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void notifyContratCreated(){
        //arrrange
        PropertyID fakePropertyID = PropertyID.of("fakePropertyID");
        var event = new ContractCreated(fakePropertyID);
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
        var contract = (NotifyContractCreated) events.get(0);
        assertEquals("El contrato se ha creado exitosamente", contract.getNotify());
    }
}
