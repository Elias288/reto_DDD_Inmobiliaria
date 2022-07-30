package com.inmobiliariadomain.promotionsection.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.inmobiliariadomain.promotionsection.Pairing;
import com.inmobiliariadomain.promotionsection.commands.AddEstablishment;
import com.inmobiliariadomain.promotionsection.commands.RemoveInterested;

public class RemovedInterestedUseCase extends UseCase<RequestCommand<RemoveInterested>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<RemoveInterested> addActivityCommand) {
        var command = addActivityCommand.getCommand();
        Pairing contract = Pairing.from(command.getPairingID(), repository().getEventsBy(command.getPairingID().value()));

        contract.removeInterested(command.getInterestedID());

        emit().onResponse(new ResponseEvents(contract.getUncommittedChanges()));
    }
}
