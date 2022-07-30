package com.inmobiliariadomain.local.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.inmobiliariadomain.local.Management;
import com.inmobiliariadomain.local.commands.RemoveProperty;
import com.inmobiliariadomain.promotionsection.Pairing;
import com.inmobiliariadomain.promotionsection.commands.RemoveInterested;

public class RemovedPropertyUseCase extends UseCase<RequestCommand<RemoveProperty>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<RemoveProperty> addActivityCommand) {
        var command = addActivityCommand.getCommand();
        Management management = Management.from(command.getManagementID(), repository().getEventsBy(command.getManagementID().value()));

        management.removeProperty(command.getPropertyID());

        emit().onResponse(new ResponseEvents(management.getUncommittedChanges()));
    }
}
