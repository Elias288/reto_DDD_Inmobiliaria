package com.inmobiliariadomain.promotionsection.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.inmobiliariadomain.promotionsection.Pairing;
import com.inmobiliariadomain.promotionsection.commands.RemoveOffer;

public class RemovedOfferUseCase extends UseCase<RequestCommand<RemoveOffer>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<RemoveOffer> addActivityCommand) {
        var command = addActivityCommand.getCommand();
        Pairing pairing = Pairing.from(command.getPairingID(), repository().getEventsBy(command.getPairingID().value()));

        pairing.removeOffer(command.getOfferID());

        emit().onResponse(new ResponseEvents(pairing.getUncommittedChanges()));
    }
}
