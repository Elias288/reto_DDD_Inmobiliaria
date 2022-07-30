package com.inmobiliriaDDD.proposal;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.inmobiliariadomain.local.values.PropertyID;
import com.inmobiliariadomain.proposal.commands.AddClient;
import com.inmobiliariadomain.proposal.events.ClientAdded;
import com.inmobiliariadomain.proposal.events.ContractCreated;
import com.inmobiliariadomain.proposal.usecases.AddClientUseCase;
import com.inmobiliariadomain.proposal.values.*;
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
class AddClientCaseTest {

    @InjectMocks
    private AddClientUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void addClient(){
        //arrange
        ContractID contractID = ContractID.of("ddddd");
        Name name = new Name("Eddi");
        Contact contact = new Contact("eddi@gmail.com");
        Age age = new Age(32);

        var command = new AddClient(contractID, name, contact, age);

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
        var event = (ClientAdded)events.get(0);

        Assertions.assertEquals("Eddi", event.getName().value());
        Assertions.assertEquals("eddi@gmail.com", event.getContact().value());
        Assertions.assertEquals(32, event.getAge().value());

        verify(repository).getEventsBy("ddddd");
    }

    private List<DomainEvent> history(){
        PropertyID propertyID = PropertyID.of("xxxxx");
        var event = new ContractCreated(propertyID);
        event.setAggregateRootId(propertyID.value());
        return List.of(event);
    }
}

