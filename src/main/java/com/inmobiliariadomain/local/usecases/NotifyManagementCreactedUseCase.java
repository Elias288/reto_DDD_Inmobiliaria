package com.inmobiliariadomain.local.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import com.inmobiliariadomain.local.Management;
import com.inmobiliariadomain.local.events.ManagementCreated;
import com.inmobiliariadomain.local.values.ManagementID;

public class NotifyManagementCreactedUseCase extends UseCase<TriggeredEvent<ManagementCreated>, ResponseEvents> {

    @Override
    public void executeUseCase(TriggeredEvent<ManagementCreated> managementTriggeredEvent) {
        var event = managementTriggeredEvent.getDomainEvent();

        var management = Management.from(ManagementID.of(event.aggregateRootId()), repository().getEventsBy(event.aggregateRootId()));
        management.notifyPropertyAdded("La administracion se ha creado exitosamente");

        emit().onResponse(new ResponseEvents(management.getUncommittedChanges()));
    }
}
