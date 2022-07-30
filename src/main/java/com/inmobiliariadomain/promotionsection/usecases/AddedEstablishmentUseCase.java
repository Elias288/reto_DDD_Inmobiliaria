package com.inmobiliariadomain.promotionsection.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.inmobiliariadomain.promotionsection.Pairing;
import com.inmobiliariadomain.promotionsection.commands.AddEstablishment;

public class AddedEstablishmentUseCase extends UseCase<RequestCommand<AddEstablishment>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AddEstablishment> addActivityCommand) {
        var command = addActivityCommand.getCommand();
        Pairing pairing = Pairing.from(command.getPairingID(), repository().getEventsBy(command.getPairingID().value()));

        pairing.addEstablishment(command.getAddress());

        emit().onResponse(new ResponseEvents(pairing.getUncommittedChanges()));
    }
}
