package com.inmobiliriaDDD.promotionsection;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.inmobiliariadomain.promotionsection.commands.AddInterested;
import com.inmobiliariadomain.promotionsection.events.*;
import com.inmobiliariadomain.promotionsection.usecases.AddedInterestedUseCase;
import com.inmobiliariadomain.promotionsection.values.*;
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
class AddInterestedCaseTest {

    @InjectMocks
    private AddedInterestedUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void addEstablishment(){
        //arrange
        PairingID pairingID = PairingID.of("PairingID");
        Name fakeName = new Name("Elias Bianchi");
        QueryType fakeQueryType = new QueryType(QueryTypeEnum.RENTAL);
        Contact fakeContact = new Contact("bianchi.elias@gmail.com");

        var command = new AddInterested(pairingID, fakeQueryType, fakeName, fakeContact);

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
        var event = (InterestedAdded)events.get(0);

        Assertions.assertEquals("Elias Bianchi", event.getName().value());
        Assertions.assertEquals(QueryTypeEnum.RENTAL, event.getQueryType().value());
        Assertions.assertEquals("bianchi.elias@gmail.com", event.getContact().value());
        verify(repository).getEventsBy("PairingID");
    }

    private List<DomainEvent> history(){
        var event = new PairingCreated(new Date());
        return List.of(event);
    }
}

