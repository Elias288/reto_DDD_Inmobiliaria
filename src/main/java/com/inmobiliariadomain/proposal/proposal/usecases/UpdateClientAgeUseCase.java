package com.inmobiliariadomain.proposal.proposal.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.inmobiliariadomain.proposal.proposal.Contract;
import com.inmobiliariadomain.proposal.proposal.commands.UpdateClientAge;

public class UpdateClientAgeUseCase extends UseCase<RequestCommand<UpdateClientAge>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<UpdateClientAge> updateRequestCommand) {
        var command = updateRequestCommand.getCommand();
        Contract contract = Contract.from(command.getContractID(), repository().getEventsBy(command.getContractID().value()));

        contract.updateClientAge(command.getClientID(), command.getAge());

        emit().onResponse(new ResponseEvents(contract.getUncommittedChanges()));
    }
}
