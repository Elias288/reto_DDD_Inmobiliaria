package com.inmobiliriaDDD.local;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.inmobiliariadomain.local.commands.AddProperty;
import com.inmobiliariadomain.local.events.ManagementCreated;
import com.inmobiliariadomain.local.events.PropertyAdded;
import com.inmobiliariadomain.local.usecases.AddedPropertyUseCase;
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
class AddPropertyCaseTest {

    @InjectMocks
    private AddedPropertyUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void addProperty(){
        //arrange
        ManagementID managementID = ManagementID.of("ManagementID");

        Price price = new Price(15000);
        Area area = new Area(50);
        Address address = new Address("Rio Negro 1743");
        PropertyType propertyType = new PropertyType(PropertyTypeEnum.HOUSE);

        var command = new AddProperty(managementID, price, area, address, propertyType);

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
        var event = (PropertyAdded)events.get(0);
        Assertions.assertEquals("Rio Negro 1743", event.getAddress().value());
        Assertions.assertEquals(50, event.getArea().value());
        Assertions.assertEquals(PropertyTypeEnum.HOUSE, event.getPropertyType().value());
        Assertions.assertEquals(15000, event.getPrice().value().intValue());
        verify(repository).getEventsBy("ManagementID");
    }

    private List<DomainEvent> history(){
        InitialDate initialDate = new InitialDate(new Date());
        var event = new ManagementCreated(initialDate, new PairingID("fakePairingID"));
        event.setAggregateRootId(initialDate.toString());
        return List.of(event);
    }
}

