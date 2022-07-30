package com.inmobiliariadomain.local.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.inmobiliariadomain.local.Management;
import com.inmobiliariadomain.local.commands.UpdateOwnerDebit;
import com.inmobiliariadomain.local.commands.UpdateOwnerName;

public class UpdatedOwnerNameUseCase extends UseCase<RequestCommand<UpdateOwnerName>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<UpdateOwnerName> addActivityCommand) {
        var command = addActivityCommand.getCommand();
        Management pairing = Management.from(command.getManagementID(), repository().getEventsBy(command.getManagementID().value()));

        pairing.updateOwnerName(command.getOwnerID(), command.getName());

        emit().onResponse(new ResponseEvents(pairing.getUncommittedChanges()));
    }
}
