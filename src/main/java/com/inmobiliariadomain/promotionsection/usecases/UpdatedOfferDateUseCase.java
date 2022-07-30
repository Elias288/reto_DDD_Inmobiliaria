package com.inmobiliariadomain.promotionsection.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.inmobiliariadomain.promotionsection.Pairing;
import com.inmobiliariadomain.promotionsection.commands.UpdateInterestedQueryType;
import com.inmobiliariadomain.promotionsection.commands.UpdateOfferDate;

public class UpdatedOfferDateUseCase extends UseCase<RequestCommand<UpdateOfferDate>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<UpdateOfferDate> addClientRequestCommand) {
        var command = addClientRequestCommand.getCommand();
        Pairing pairing = Pairing.from(command.getPairingID(), repository().getEventsBy(command.getPairingID().value()));

        pairing.updateOfferDate(command.getOfferID(), command.getOfferDate());

        emit().onResponse(new ResponseEvents(pairing.getUncommittedChanges()));
    }
}
