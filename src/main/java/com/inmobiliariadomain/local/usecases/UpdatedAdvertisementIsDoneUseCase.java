package com.inmobiliariadomain.local.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.inmobiliariadomain.local.Management;
import com.inmobiliariadomain.local.commands.UpdateAdvertisementExpirationDate;
import com.inmobiliariadomain.local.commands.UpdateAdvertisementIsDone;

public class UpdatedAdvertisementIsDoneUseCase extends UseCase<RequestCommand<UpdateAdvertisementIsDone>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<UpdateAdvertisementIsDone> addActivityCommand) {
        var command = addActivityCommand.getCommand();
        Management management = Management.from(command.getManagementID(), repository().getEventsBy(command.getManagementID().value()));

        management.updateAdvertisementIsDone(command.getAdvertisementID(), command.getIsDone());

        emit().onResponse(new ResponseEvents(management.getUncommittedChanges()));
    }
}
