package com.inmobiliariadomain.local.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.inmobiliariadomain.local.Management;
import com.inmobiliariadomain.local.commands.RemoveAdvertisement;
import com.inmobiliariadomain.local.commands.RemoveProperty;

public class RemovedAdvertisementUseCase extends UseCase<RequestCommand<RemoveAdvertisement>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<RemoveAdvertisement> addActivityCommand) {
        var command = addActivityCommand.getCommand();
        Management management = Management.from(command.getManagementID(), repository().getEventsBy(command.getManagementID().value()));

        management.removeAdvertisement(command.getAdvertisementID());

        emit().onResponse(new ResponseEvents(management.getUncommittedChanges()));
    }
}
