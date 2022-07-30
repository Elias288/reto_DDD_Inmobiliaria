package com.inmobiliariadomain.local.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.inmobiliariadomain.local.Management;
import com.inmobiliariadomain.local.commands.UpdatePropertyArea;
import com.inmobiliariadomain.local.commands.UpdatePropertyPrice;

public class UpdatedPropertyPriceUseCase extends UseCase<RequestCommand<UpdatePropertyPrice>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<UpdatePropertyPrice> addActivityCommand) {
        var command = addActivityCommand.getCommand();
        Management pairing = Management.from(command.getManagementID(), repository().getEventsBy(command.getManagementID().value()));

        pairing.updatePropertyPrice(command.getPropertyID(), command.getPrice());

        emit().onResponse(new ResponseEvents(pairing.getUncommittedChanges()));
    }
}
