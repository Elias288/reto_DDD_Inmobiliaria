package com.inmobiliariadomain.proposal.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.inmobiliariadomain.proposal.Contract;
import com.inmobiliariadomain.proposal.commands.AddEmployee;

public class AddedEmployeeUseCase extends UseCase<RequestCommand<AddEmployee>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AddEmployee> addEmployeeRequestCommand) {
        var command = addEmployeeRequestCommand.getCommand();
        Contract contract = Contract.from(command.getContractID(), repository().getEventsBy(command.getContractID().value()));

        contract.addEmployee(command.getCommission(), command.getName());

        emit().onResponse(new ResponseEvents(contract.getUncommittedChanges()));
    }
}
