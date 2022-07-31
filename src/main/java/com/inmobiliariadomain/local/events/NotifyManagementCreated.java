package com.inmobiliariadomain.local.events;

import co.com.sofka.domain.generic.DomainEvent;

public class NotifyManagementCreated extends DomainEvent {
    private final String value;

    public NotifyManagementCreated(String value) {
        super("com.inmobiliariadomain.proposal.notifypropertyadded");
        this.value = value;
    }

    public String getNotify() {
        return value;
    }
}
