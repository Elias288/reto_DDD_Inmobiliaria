package com.inmobiliariadomain.local.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.inmobiliariadomain.local.Management;
import com.inmobiliariadomain.local.commands.UpdatePropertyAddress;
import com.inmobiliariadomain.local.commands.UpdatePropertyArea;

public class UpdatedPropertyAreaUseCase extends UseCase<RequestCommand<UpdatePropertyArea>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<UpdatePropertyArea> addActivityCommand) {
        var command = addActivityCommand.getCommand();
        Management pairing = Management.from(command.getManagementID(), repository().getEventsBy(command.getManagementID().value()));

        pairing.updatePropertyArea(command.getPropertyID(), command.getArea());

        emit().onResponse(new ResponseEvents(pairing.getUncommittedChanges()));
    }
}
