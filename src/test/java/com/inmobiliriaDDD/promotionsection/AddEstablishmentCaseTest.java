package com.inmobiliriaDDD.promotionsection;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.inmobiliariadomain.promotionsection.commands.AddEstablishment;
import com.inmobiliariadomain.promotionsection.events.EstablishmentAdded;
import com.inmobiliariadomain.promotionsection.events.PairingCreated;
import com.inmobiliariadomain.promotionsection.usecases.AddedEstablishmentUseCase;
import com.inmobiliariadomain.promotionsection.values.Address;
import com.inmobiliariadomain.promotionsection.values.PairingID;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AddEstablishmentCaseTest {

    @InjectMocks
    private AddedEstablishmentUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void addEstablishment(){
        //arrange
        PairingID pairingID = PairingID.of("PairingID");
        Address address = new Address("Washintong 1234");

        var command = new AddEstablishment(address, pairingID);

        when(repository.getEventsBy("PairingID"))
                .thenReturn(history());

        useCase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getPairingID().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (EstablishmentAdded)events.get(0);
        Assertions.assertEquals("Washintong 1234", event.getAddress().value());
        verify(repository).getEventsBy("PairingID");
    }

    private List<DomainEvent> history(){
        var event = new PairingCreated(new Date());
        return List.of(event);
    }
}

