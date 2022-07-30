package com.inmobiliariadomain.local.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.inmobiliariadomain.local.Management;
import com.inmobiliariadomain.local.commands.UpdateOwnerDebit;

public class UpdatedOwnerDebitUseCase extends UseCase<RequestCommand<UpdateOwnerDebit>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<UpdateOwnerDebit> addActivityCommand) {
        var command = addActivityCommand.getCommand();
        Management pairing = Management.from(command.getManagementID(), repository().getEventsBy(command.getManagementID().value()));

        pairing.updateOwnerDebit(command.getOwnerID(), command.getDebit());

        emit().onResponse(new ResponseEvents(pairing.getUncommittedChanges()));
    }
}
