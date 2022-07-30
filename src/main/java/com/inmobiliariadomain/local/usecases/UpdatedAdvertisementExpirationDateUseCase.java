package com.inmobiliariadomain.local.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.inmobiliariadomain.local.Management;
import com.inmobiliariadomain.local.commands.UpdateAdvertisementExpirationDate;
import com.inmobiliariadomain.local.commands.UpdatePropertyType;

public class UpdatedAdvertisementExpirationDateUseCase extends UseCase<RequestCommand<UpdateAdvertisementExpirationDate>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<UpdateAdvertisementExpirationDate> addActivityCommand) {
        var command = addActivityCommand.getCommand();
        Management management = Management.from(command.getManagementID(), repository().getEventsBy(command.getManagementID().value()));

        management.updateAdvertisementExpirationDate(command.getAdvertisementID(), command.getExpirationDate());

        emit().onResponse(new ResponseEvents(management.getUncommittedChanges()));
    }
}
