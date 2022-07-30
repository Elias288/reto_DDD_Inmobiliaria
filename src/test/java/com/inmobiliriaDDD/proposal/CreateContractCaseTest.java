package com.inmobiliriaDDD.proposal;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.inmobiliariadomain.local.values.PropertyID;
import com.inmobiliariadomain.proposal.commands.CreateContract;
import com.inmobiliariadomain.proposal.events.ContractCreated;
import com.inmobiliariadomain.proposal.usecases.CreateContractUseCase;
import com.inmobiliariadomain.proposal.values.ContractID;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;


class CreateContractCaseTest {

    private CreateContractUseCase useCase;

    @BeforeEach
    public void setup(){
        useCase = new CreateContractUseCase();
    }

    @Test
    public void createContrat(){
        //arrrange
        ContractID contractID = ContractID.of("ddddd");
        PropertyID propertyID = PropertyID.of("DDD");

        CreateContract command = new CreateContract(contractID, propertyID);

        //act
        List<DomainEvent> domainEvents = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //asserts
        ContractCreated contractCreated = (ContractCreated) domainEvents.get(0);
        Assertions.assertEquals("ddddd", contractCreated.aggregateRootId());
        Assertions.assertEquals("DDD", contractCreated.getPropertyID().value());
    }
}
