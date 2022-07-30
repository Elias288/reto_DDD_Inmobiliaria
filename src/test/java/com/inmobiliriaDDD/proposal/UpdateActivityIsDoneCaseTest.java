package com.inmobiliriaDDD.proposal;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.inmobiliariadomain.local.values.PropertyID;
import com.inmobiliariadomain.proposal.commands.UpdateActivityIsDone;
import com.inmobiliariadomain.proposal.events.*;
import com.inmobiliariadomain.proposal.usecases.UpdateActivityIsDoneUseCase;
import com.inmobiliariadomain.proposal.values.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UpdateActivityIsDoneCaseTest {

    @InjectMocks
    private UpdateActivityIsDoneUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void updateActivityIsDone(){
        //arrange
        ContractID fakeContractID = ContractID.of("fakeContractID");
        ActivityID fakeActivityID = ActivityID.of("fakeActivityID");
        IsDone updateIsDone = new IsDone(true);

        var command = new UpdateActivityIsDone(fakeContractID, updateIsDone, fakeActivityID);

        when(repository.getEventsBy("fakeContractID")).thenReturn(List.of(
                new ContractCreated(PropertyID.of("xxxx")),
                new EmployeeAdded(EmployeeID.of("fakeActivityID"), new Commission(1500), new Name("Eddi")),
                new ActivityAdded(ActivityID.of("fakeActivityID"), new ActivityType(ActivityTypeEnum.SALE)),
                new ClientAdded(ClientID.of("fakeClientID"), new Name("Fabricio"), new Age(23), new Contact("Nico.velar@gmail.com"))
        ));

        useCase.addRepository(repository);

        //act
        List<DomainEvent> domainEvents = UseCaseHandler.getInstance()
                .setIdentifyExecutor("fakeContractID")
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (ActivityIsDoneUpdated) domainEvents.get(0);

        assertEquals(true, event.getIsDone().value());
        assertEquals("fakeActivityID", event.getActivityID().value());

        verify(repository).getEventsBy("fakeContractID");
    }
}

