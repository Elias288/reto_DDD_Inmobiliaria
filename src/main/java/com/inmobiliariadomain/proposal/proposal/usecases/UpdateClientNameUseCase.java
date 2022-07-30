package com.inmobiliariadomain.proposal.proposal.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.inmobiliariadomain.proposal.proposal.Contract;
import com.inmobiliariadomain.proposal.proposal.commands.UpdateClientName;

public class UpdateClientNameUseCase extends UseCase<RequestCommand<UpdateClientName>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<UpdateClientName> updateRequestCommand) {
        var command = updateRequestCommand.getCommand();

        Contract contract = Contract.from(command.getContractID(), repository().getEventsBy(command.getContractID().value()));

        contract.updateClientName(command.getClientID(), command.getName());

        emit().onResponse(new ResponseEvents(contract.getUncommittedChanges()));
    }
}
