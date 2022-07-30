package com.inmobiliariadomain.promotionsection.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.inmobiliariadomain.promotionsection.Pairing;
import com.inmobiliariadomain.promotionsection.commands.AddOffer;
import com.inmobiliariadomain.promotionsection.commands.UpdateEstablishmentAddress;

public class UpdatedEstablishmentAddresUseCase extends UseCase<RequestCommand<UpdateEstablishmentAddress>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<UpdateEstablishmentAddress> addClientRequestCommand) {
        var command = addClientRequestCommand.getCommand();
        Pairing pairing = Pairing.from(command.getPairingID(), repository().getEventsBy(command.getPairingID().value()));

        pairing.updateEstablishmentAddres(command.getEstablishmentID(), command.getAddress());

        emit().onResponse(new ResponseEvents(pairing.getUncommittedChanges()));
    }
}
