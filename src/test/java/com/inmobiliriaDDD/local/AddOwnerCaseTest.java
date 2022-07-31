package com.inmobiliriaDDD.local;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.inmobiliariadomain.local.commands.AddOwner;
import com.inmobiliariadomain.local.events.ManagementCreated;
import com.inmobiliariadomain.local.events.OwnerAdded;
import com.inmobiliariadomain.local.events.PropertyAdded;
import com.inmobiliariadomain.local.usecases.AddedOwnerUseCase;
import com.inmobiliariadomain.local.values.*;
import com.inmobiliariadomain.promotionsection.values.PairingID;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AddOwnerCaseTest {

    @InjectMocks
    private AddedOwnerUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void addOwner(){
        //arrange
        ManagementID managementID = ManagementID.of("ManagementID");

        Debit debit = new Debit(10000);
        Name name = new Name("Eddi");
        Contact contact = new Contact("eddi@gmail.com");

        var command = new AddOwner(managementID, debit, name, contact);

        when(repository.getEventsBy("ManagementID"))
                .thenReturn(history());

        useCase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getManagementID().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (OwnerAdded)events.get(0);
        Assertions.assertEquals(10000, event.getDebit().value().intValue());
        Assertions.assertEquals("Eddi", event.getName().value());
        Assertions.assertEquals("eddi@gmail.com", event.getContact().value());
        verify(repository).getEventsBy("ManagementID");
    }

    private List<DomainEvent> history(){
        InitialDate initialDate = new InitialDate(new Date());
        var event = new ManagementCreated(initialDate, new PairingID("fakePairingID"));
        event.setAggregateRootId(initialDate.toString());
        return List.of(event);
    }
}

