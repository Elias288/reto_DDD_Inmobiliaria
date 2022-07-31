package com.inmobiliariadomain.proposal.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import com.inmobiliariadomain.proposal.Contract;
import com.inmobiliariadomain.proposal.events.ContractCreated;
import com.inmobiliariadomain.proposal.values.ContractID;

public class NotifyContractCreatedUseCase extends UseCase<TriggeredEvent<ContractCreated>, ResponseEvents> {

    @Override
    public void executeUseCase(TriggeredEvent<ContractCreated> contractTriggeredEvent) {
        var event = contractTriggeredEvent.getDomainEvent();

        var contract = Contract.from(ContractID.of(event.aggregateRootId()), repository().getEventsBy(event.aggregateRootId()));
        contract.notifyContractCreated("El contrato se ha creado exitosamente");

        emit().onResponse(new ResponseEvents(contract.getUncommittedChanges()));
    }
}
