package com.inmobiliriaDDD.local;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.inmobiliariadomain.local.commands.CreateManagement;
import com.inmobiliariadomain.local.events.ManagementCreated;
import com.inmobiliariadomain.local.usecases.CreateManagementUseCase;
import com.inmobiliariadomain.local.values.InitialDate;
import com.inmobiliariadomain.local.values.ManagementID;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;


class CreateManagementCaseTest {

    private CreateManagementUseCase useCase;

    @BeforeEach
    public void setup(){
        useCase = new CreateManagementUseCase();
    }

    @Test
    public void createManagement(){
        //arrrange
        ManagementID fakeManagementID = ManagementID.of("fakeManagementID");
        InitialDate fakeInitialDate = new InitialDate(new Date());

        CreateManagement command = new CreateManagement(fakeManagementID, fakeInitialDate);

        //act
        List<DomainEvent> domainEvents = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //asserts
        ManagementCreated managementCreated = (ManagementCreated) domainEvents.get(0);;
        Assertions.assertEquals("fakeManagementID", managementCreated.aggregateRootId());
    }
}
