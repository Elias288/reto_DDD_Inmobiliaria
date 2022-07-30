package com.inmobiliariadomain.local.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.inmobiliariadomain.local.Management;
import com.inmobiliariadomain.local.commands.AddOwner;

public class AddedOwnerUseCase extends UseCase<RequestCommand<AddOwner>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AddOwner> addActivityCommand) {
        var command = addActivityCommand.getCommand();
        Management contract = Management.from(command.getManagementID(), repository().getEventsBy(command.getManagementID().value()));

        contract.addOwner(command.getName(), command.getDebit(), command.getContact());

        emit().onResponse(new ResponseEvents(contract.getUncommittedChanges()));
    }
}
