package com.inmobiliariadomain.local.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.inmobiliariadomain.local.Management;
import com.inmobiliariadomain.local.commands.UpdateOwnerName;
import com.inmobiliariadomain.local.commands.UpdatePropertyAddress;

public class UpdatedPropertyAddresUseCase extends UseCase<RequestCommand<UpdatePropertyAddress>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<UpdatePropertyAddress> addActivityCommand) {
        var command = addActivityCommand.getCommand();
        Management pairing = Management.from(command.getManagementID(), repository().getEventsBy(command.getManagementID().value()));

        pairing.updatePropertyAddress(command.getPropertyID(), command.getAddress());

        emit().onResponse(new ResponseEvents(pairing.getUncommittedChanges()));
    }
}
