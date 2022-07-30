package com.inmobiliriaDDD.proposal;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.inmobiliariadomain.local.values.PropertyID;
import com.inmobiliariadomain.proposal.commands.AddEmployee;
import com.inmobiliariadomain.proposal.events.ContractCreated;
import com.inmobiliariadomain.proposal.events.EmployeeAdded;
import com.inmobiliariadomain.proposal.usecases.AddEmployeeUseCase;
import com.inmobiliariadomain.proposal.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AddEmployeeCaseTest {

    @InjectMocks
    private AddEmployeeUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void addEmployee(){
        //arrange
        ContractID contractID = ContractID.of("ddddd");
        ActivityType activityType = new ActivityType(ActivityTypeEnum.RENTAL);
        Name name = new Name("Eddi");
        Commission commission = new Commission(1000);

        var command = new AddEmployee(contractID, name, commission);

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
        var event = (EmployeeAdded)events.get(0);

        Assertions.assertEquals("Eddi", event.getName().value());
        Assertions.assertEquals(new BigDecimal(1000), event.getCommission().value());

        verify(repository).getEventsBy("ddddd");
    }

    private List<DomainEvent> history(){
        PropertyID propertyID = PropertyID.of("xxxxx");
        var event = new ContractCreated(propertyID);
        event.setAggregateRootId(propertyID.value());
        return List.of(event);
    }
}

