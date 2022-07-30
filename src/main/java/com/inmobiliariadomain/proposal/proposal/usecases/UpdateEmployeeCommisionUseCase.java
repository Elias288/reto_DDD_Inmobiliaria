package com.inmobiliariadomain.proposal.proposal.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.inmobiliariadomain.proposal.proposal.Contract;
import com.inmobiliariadomain.proposal.proposal.commands.UpdateEmployeeCommision;

public class UpdateEmployeeCommisionUseCase extends UseCase<RequestCommand<UpdateEmployeeCommision>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<UpdateEmployeeCommision> updateRequestCommand) {
        var command = updateRequestCommand.getCommand();

        Contract contract = Contract.from(command.getContractID(), repository().getEventsBy(command.getContractID().value()));

        contract.updateEmployeeCommision(command.getEmployeeID(), command.getCommission());

        emit().onResponse(new ResponseEvents(contract.getUncommittedChanges()));
    }
}
