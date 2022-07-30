package com.inmobiliariadomain.promotionsection.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.inmobiliariadomain.promotionsection.Pairing;
import com.inmobiliariadomain.promotionsection.commands.UpdateOfferIsFinished;

public class UpdatedOfferIsFinishedUseCase extends UseCase<RequestCommand<UpdateOfferIsFinished>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<UpdateOfferIsFinished> addClientRequestCommand) {
        var command = addClientRequestCommand.getCommand();
        Pairing pairing = Pairing.from(command.getPairingID(), repository().getEventsBy(command.getPairingID().value()));

        pairing.updateOfferIsFinished(command.getOfferID(), command.getIsFinished());

        emit().onResponse(new ResponseEvents(pairing.getUncommittedChanges()));
    }
}
