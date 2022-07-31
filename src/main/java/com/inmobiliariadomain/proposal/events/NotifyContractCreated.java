package com.inmobiliariadomain.proposal.events;

import co.com.sofka.domain.generic.DomainEvent;

public class NotifyContractCreated extends DomainEvent {
    private final String value;


    public NotifyContractCreated(String value) {
        super("com.inmobiliariadomain.proposal.notifycontractcreated");
        this.value = value;
    }

    public String getNotify() {
        return value;
    }
}
