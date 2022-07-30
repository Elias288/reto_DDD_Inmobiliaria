package com.inmobiliariadomain.proposal.proposal.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.inmobiliariadomain.proposal.proposal.Contract;
import com.inmobiliariadomain.proposal.proposal.commands.AddClient;

public class AddedClientUseCase extends UseCase<RequestCommand<AddClient>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AddClient> addClientRequestCommand) {
        var command = addClientRequestCommand.getCommand();
        Contract contract = Contract.from(command.getContractID(), repository().getEventsBy(command.getContractID().value()));

        contract.addClient(command.getName(), command.getAge(), command.getContact());

        emit().onResponse(new ResponseEvents(contract.getUncommittedChanges()));
    }
}
