package com.inmobiliariadomain.local.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.inmobiliariadomain.local.Management;
import com.inmobiliariadomain.local.commands.AddProperty;

public class AddedOPropertyUseCase extends UseCase<RequestCommand<AddProperty>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AddProperty> addActivityCommand) {
        var command = addActivityCommand.getCommand();
        Management management = Management.from(command.getManagementID(), repository().getEventsBy(command.getManagementID().value()));

        management.addProperty(command.getPrice(), command.getArea(), command.getAddress(), command.getPropertyType());

        emit().onResponse(new ResponseEvents(management.getUncommittedChanges()));
    }
}
