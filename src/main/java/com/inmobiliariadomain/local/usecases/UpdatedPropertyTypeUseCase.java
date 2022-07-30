package com.inmobiliariadomain.local.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.inmobiliariadomain.local.Management;
import com.inmobiliariadomain.local.commands.UpdatePropertyPrice;
import com.inmobiliariadomain.local.commands.UpdatePropertyType;

public class UpdatedPropertyTypeUseCase extends UseCase<RequestCommand<UpdatePropertyType>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<UpdatePropertyType> addActivityCommand) {
        var command = addActivityCommand.getCommand();
        Management management = Management.from(command.getManagementID(), repository().getEventsBy(command.getManagementID().value()));

        management.updatePropertyType(command.getPropertyID(), command.getPropertyType());

        emit().onResponse(new ResponseEvents(management.getUncommittedChanges()));
    }
}
