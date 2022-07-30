package com.inmobiliriaDDD.proposal;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.inmobiliariadomain.local.values.PropertyID;
import com.inmobiliariadomain.proposal.Contract;
import com.inmobiliariadomain.proposal.commands.UpdateEmployeeCommision;
import com.inmobiliariadomain.proposal.events.*;
import com.inmobiliariadomain.proposal.usecases.UpdateEmployeeCommisionUseCase;
import com.inmobiliariadomain.proposal.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UpdateEmployeeCommisionCaseTest {

    @InjectMocks
    private UpdateEmployeeCommisionUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void updateEmployeeeCommision(){
        //arrange
        ContractID fakeContractID = ContractID.of("fakeContractID");
        EmployeeID fakeEmployeeID = EmployeeID.of("fakeEmployeeID");
        Commission updateCommission = new Commission(1000);

        var command = new UpdateEmployeeCommision(fakeContractID, updateCommission, fakeEmployeeID);

        when(repository.getEventsBy("fakeContractID")).thenReturn(List.of(
                new ContractCreated(PropertyID.of("xxxx")),
                new EmployeeAdded(EmployeeID.of("fakeEmployeeID"), new Commission(1500), new Name("Eddi")),
                new ActivityAdded(ActivityID.of("fakeActivityID"), new ActivityType(ActivityTypeEnum.RENTAL)),
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
        var event = (EmployeeCommisionUpdated) domainEvents.get(0);

        assertEquals(new BigDecimal(1000), event.getCommission().value());
        assertEquals("fakeEmployeeID", event.getEmployeeID().value());

        verify(repository).getEventsBy("fakeContractID");
    }
}

