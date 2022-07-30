package com.inmobiliariadomain.promotionsection.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.inmobiliariadomain.promotionsection.Pairing;
import com.inmobiliariadomain.promotionsection.commands.UpdateInterestedContact;
import com.inmobiliariadomain.promotionsection.commands.UpdateInterestedName;

public class UpdatedInterestedNameUseCase extends UseCase<RequestCommand<UpdateInterestedName>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<UpdateInterestedName> addClientRequestCommand) {
        var command = addClientRequestCommand.getCommand();
        Pairing pairing = Pairing.from(command.getPairingID(), repository().getEventsBy(command.getPairingID().value()));

        pairing.updateInterestedName(command.getInterestedID(), command.getName());

        emit().onResponse(new ResponseEvents(pairing.getUncommittedChanges()));
    }
}
