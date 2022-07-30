package com.inmobiliriaDDD.proposal;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.inmobiliariadomain.local.values.PropertyID;
import com.inmobiliariadomain.proposal.commands.AddActivity;
import com.inmobiliariadomain.proposal.events.ActivityAdded;
import com.inmobiliariadomain.proposal.events.ContractCreated;
import com.inmobiliariadomain.proposal.usecases.AddActivityUseCase;
import com.inmobiliariadomain.proposal.values.ActivityType;
import com.inmobiliariadomain.proposal.values.ActivityTypeEnum;
import com.inmobiliariadomain.proposal.values.ContractID;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AddActivityCaseTest {

    @InjectMocks
    private AddActivityUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void addActivity(){
        //arrange
        ContractID contractID = ContractID.of("ddddd");
        ActivityType activityType = new ActivityType(ActivityTypeEnum.RENTAL);
        var command = new AddActivity(contractID, activityType);

        when(repository.getEventsBy("ddddd"))
                .thenReturn(history());

        useCase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getContractID().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (ActivityAdded)events.get(0);
        Assertions.assertEquals(ActivityTypeEnum.RENTAL, event.getActivityType().value());
        verify(repository).getEventsBy("ddddd");
    }

    private List<DomainEvent> history(){
        PropertyID propertyID = PropertyID.of("xxxxx");
        var event = new ContractCreated(propertyID);
        event.setAggregateRootId(propertyID.value());
        return List.of(event);
    }
}

