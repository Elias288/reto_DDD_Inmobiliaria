package com.inmobiliariadomain.proposal.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.inmobiliariadomain.proposal.Contract;
import com.inmobiliariadomain.proposal.commands.UpdateActivityIsDone;
import com.inmobiliariadomain.proposal.commands.UpdateActivityType;

public class UpdateActivityIsDoneUseCase extends UseCase<RequestCommand<UpdateActivityIsDone>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<UpdateActivityIsDone> updateRequestCommand) {
        var command = updateRequestCommand.getCommand();

        Contract contract = Contract.from(command.getContractID(), repository().getEventsBy(command.getContractID().value()));

        contract.updateActivityIsDone(command.getActivityID(), command.getIsDone());

        emit().onResponse(new ResponseEvents(contract.getUncommittedChanges()));
    }
}
