package com.inmobiliariadomain.local.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.inmobiliariadomain.local.Management;
import com.inmobiliariadomain.local.commands.CreateManagement;

public class CreateManagementUseCase extends UseCase<RequestCommand<CreateManagement>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CreateManagement> addActivityCommand) {
        var command = addActivityCommand.getCommand();

        var management = new Management(command.getManagementID(), command.getInitialDate(), command.getPairing());

        emit().onResponse(new ResponseEvents(management.getUncommittedChanges()));
    }
}
