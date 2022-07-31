package com.inmobiliariadomain.proposal.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.inmobiliariadomain.proposal.Contract;
import com.inmobiliariadomain.proposal.commands.CreateContract;

public class CreateContractUseCase extends UseCase<RequestCommand<CreateContract>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CreateContract> addActivityCommand) {
        var command = addActivityCommand.getCommand();

        var contract = new Contract(command.getContractID(), command.getPropertyID());

        emit().onResponse(new ResponseEvents(contract.getUncommittedChanges()));
    }
}
