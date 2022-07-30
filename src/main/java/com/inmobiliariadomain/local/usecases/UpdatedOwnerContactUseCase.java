package com.inmobiliariadomain.local.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.inmobiliariadomain.local.Management;
import com.inmobiliariadomain.local.commands.UpdateOwnerContact;

public class UpdatedOwnerContactUseCase extends UseCase<RequestCommand<UpdateOwnerContact>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<UpdateOwnerContact> addActivityCommand) {
        var command = addActivityCommand.getCommand();
        Management pairing = Management.from(command.getManagementID(), repository().getEventsBy(command.getManagementID().value()));

        pairing.updateOwnerContact(command.getOwnerID(), command.getContact());

        emit().onResponse(new ResponseEvents(pairing.getUncommittedChanges()));
    }
}
