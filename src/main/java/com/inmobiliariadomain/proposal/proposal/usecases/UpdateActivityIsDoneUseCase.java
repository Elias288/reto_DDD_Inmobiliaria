package com.inmobiliariadomain.proposal.proposal.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.inmobiliariadomain.proposal.proposal.commands.UpdateActivityIsDone;
import com.inmobiliariadomain.proposal.proposal.Contract;

public class UpdateActivityIsDoneUseCase extends UseCase<RequestCommand<UpdateActivityIsDone>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<UpdateActivityIsDone> updateRequestCommand) {
        var command = updateRequestCommand.getCommand();

        Contract contract = Contract.from(command.getContractID(), repository().getEventsBy(command.getContractID().value()));

        contract.updateActivityIsDone(command.getActivityID(), command.getIsDone());

        emit().onResponse(new ResponseEvents(contract.getUncommittedChanges()));
    }
}
