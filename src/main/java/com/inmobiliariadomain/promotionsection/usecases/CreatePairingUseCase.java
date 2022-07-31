package com.inmobiliariadomain.promotionsection.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.inmobiliariadomain.promotionsection.Pairing;
import com.inmobiliariadomain.promotionsection.commands.CreatePairing;

public class CreatePairingUseCase extends UseCase<RequestCommand<CreatePairing>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CreatePairing> addActivityCommand) {
        var command = addActivityCommand.getCommand();

        var contract = new Pairing(command.getContractID());

        emit().onResponse(new ResponseEvents(contract.getUncommittedChanges()));
    }
}
