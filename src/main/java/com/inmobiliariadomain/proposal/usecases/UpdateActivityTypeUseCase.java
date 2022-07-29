package com.inmobiliariadomain.proposal.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.inmobiliariadomain.proposal.Contract;
import com.inmobiliariadomain.proposal.commands.UpdateActivityType;
import com.inmobiliariadomain.proposal.commands.UpdateEmployeeCommision;

public class UpdateActivityTypeUseCase extends UseCase<RequestCommand<UpdateActivityType>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<UpdateActivityType> updateRequestCommand) {
        var command = updateRequestCommand.getCommand();

        Contract contract = Contract.from(command.getContractID(), repository().getEventsBy(command.getContractID().value()));

        contract.updateActivityType(command.getActivityID(), command.getActivityType());

        emit().onResponse(new ResponseEvents(contract.getUncommittedChanges()));
    }
}
