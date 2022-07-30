package com.inmobiliariadomain.local.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.inmobiliariadomain.local.Management;
import com.inmobiliariadomain.local.commands.AddAdvertisement;

public class AddedAdvertisementUseCase extends UseCase<RequestCommand<AddAdvertisement>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AddAdvertisement> addActivityCommand) {
        var command = addActivityCommand.getCommand();
        Management management = Management.from(command.getManagementID(), repository().getEventsBy(command.getManagementID().value()));

        management.addAdvertisement(command.getExpirationDate());

        emit().onResponse(new ResponseEvents(management.getUncommittedChanges()));
    }
}
