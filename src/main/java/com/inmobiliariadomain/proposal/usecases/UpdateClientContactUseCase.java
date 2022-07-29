package com.inmobiliariadomain.proposal.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.inmobiliariadomain.proposal.Contract;
import com.inmobiliariadomain.proposal.commands.UpdateClientContact;

public class UpdateClientContactUseCase extends UseCase<RequestCommand<UpdateClientContact>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<UpdateClientContact> updateRequestCommand) {
        var command = updateRequestCommand.getCommand();

        Contract contract = Contract.from(command.getContractID(), repository().getEventsBy(command.getContractID().value()));

        contract.updateClientContact(command.getClientID(), command.getContact());

        emit().onResponse(new ResponseEvents(contract.getUncommittedChanges()));
    }
}
