package com.inmobiliriaDDD.local;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.inmobiliariadomain.local.commands.AddAdvertisement;
import com.inmobiliariadomain.local.events.AdvertisementAdded;
import com.inmobiliariadomain.local.events.ManagementCreated;
import com.inmobiliariadomain.local.events.PropertyAdded;
import com.inmobiliariadomain.local.usecases.AddedAdvertisementUseCase;
import com.inmobiliariadomain.local.usecases.AddedPropertyUseCase;
import com.inmobiliariadomain.local.values.*;
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
class AddAdvertisementCaseTest {

    @InjectMocks
    private AddedAdvertisementUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void addAdvertisement(){
        //arrange
        ManagementID managementID = ManagementID.of("ManagementID");

        ExpirationDate expirationDate = new ExpirationDate(new Date(2000, 11, 21));

        var command = new AddAdvertisement(managementID,expirationDate);

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
        var event = (AdvertisementAdded)events.get(0);
        Assertions.assertEquals(new Date(2000, 11, 21), event.getExpirationDate().value());
        verify(repository).getEventsBy("ManagementID");
    }

    private List<DomainEvent> history(){
        InitialDate initialDate = new InitialDate(new Date());
        var event = new ManagementCreated(initialDate);
        event.setAggregateRootId(initialDate.toString());
        return List.of(event);
    }
}

