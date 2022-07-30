package com.inmobiliariadomain.promotionsection.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.inmobiliariadomain.promotionsection.Pairing;
import com.inmobiliariadomain.promotionsection.commands.AddInterested;
import com.inmobiliariadomain.proposal.proposal.Contract;
import com.inmobiliariadomain.proposal.proposal.commands.AddEmployee;

public class AddedInterestedUseCase extends UseCase<RequestCommand<AddInterested>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AddInterested> addEmployeeRequestCommand) {
        var command = addEmployeeRequestCommand.getCommand();
        Pairing contract = Pairing.from(command.getPairingID(), repository().getEventsBy(command.getPairingID().value()));

        contract.addInterested(command.getName(), command.getQueryType(), command.getContact());

        emit().onResponse(new ResponseEvents(contract.getUncommittedChanges()));
    }
}
