package com.inmobiliariadomain.promotionsection.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.inmobiliariadomain.promotionsection.Pairing;
import com.inmobiliariadomain.promotionsection.commands.UpdateInterestedContact;

public class UpdatedInterestedContactUseCase extends UseCase<RequestCommand<UpdateInterestedContact>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<UpdateInterestedContact> addClientRequestCommand) {
        var command = addClientRequestCommand.getCommand();
        Pairing pairing = Pairing.from(command.getPairingID(), repository().getEventsBy(command.getPairingID().value()));

        pairing.updateInterestedContact(command.getInterestedID(), command.getContact());

        emit().onResponse(new ResponseEvents(pairing.getUncommittedChanges()));
    }
}
