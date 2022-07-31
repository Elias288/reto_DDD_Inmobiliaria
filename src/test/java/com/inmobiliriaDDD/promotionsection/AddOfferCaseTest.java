package com.inmobiliriaDDD.promotionsection;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.inmobiliariadomain.promotionsection.commands.AddOffer;
import com.inmobiliariadomain.promotionsection.events.*;
import com.inmobiliariadomain.promotionsection.usecases.AddedOfferUseCase;
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
class AddOfferCaseTest {

    @InjectMocks
    private AddedOfferUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void addEstablishment(){
        //arrange
        PairingID fakePairingID = PairingID.of("fakePairingID");
        OfferDate fakeOfferDate = new OfferDate(new Date(2022, 4, 23));

        var command = new AddOffer(fakePairingID, fakeOfferDate);

        when(repository.getEventsBy("fakePairingID"))
                .thenReturn(history());

        useCase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getPairingID().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (OfferAdded)events.get(0);
        Assertions.assertEquals(new Date(2022, 4, 23), event.getOfferDate().value());
        verify(repository).getEventsBy("fakePairingID");
    }

    private List<DomainEvent> history(){
        var event = new PairingCreated(new Date());
        return List.of(event);
    }
}

