package com.inmobiliariadomain.promotionsection.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.inmobiliariadomain.promotionsection.Pairing;
import com.inmobiliariadomain.promotionsection.commands.UpdateInterestedName;
import com.inmobiliariadomain.promotionsection.commands.UpdateInterestedQueryType;

public class UpdatedInterestedQueryTypeUseCase extends UseCase<RequestCommand<UpdateInterestedQueryType>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<UpdateInterestedQueryType> addClientRequestCommand) {
        var command = addClientRequestCommand.getCommand();
        Pairing pairing = Pairing.from(command.getPairingID(), repository().getEventsBy(command.getPairingID().value()));

        pairing.updateInterestedQueryType(command.getInterestedID(), command.getQueryType());

        emit().onResponse(new ResponseEvents(pairing.getUncommittedChanges()));
    }
}
