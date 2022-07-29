package com.inmobiliariadomain.proposal.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.inmobiliariadomain.proposal.Contract;
import com.inmobiliariadomain.proposal.commands.AddActivity;
import com.inmobiliariadomain.proposal.commands.AddEmployee;

public class AddedActivityUseCase extends UseCase<RequestCommand<AddActivity>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AddActivity> addActivityCommand) {
        var command = addActivityCommand.getCommand();
        Contract contract = Contract.from(command.getContractID(), repository().getEventsBy(command.getContractID().value()));

        contract.addActivity(command.getActivityType());

        emit().onResponse(new ResponseEvents(contract.getUncommittedChanges()));
    }
}
