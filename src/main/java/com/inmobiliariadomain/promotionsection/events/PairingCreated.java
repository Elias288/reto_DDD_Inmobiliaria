package com.inmobiliariadomain.promotionsection.events;

import co.com.sofka.domain.generic.DomainEvent;

import java.util.Date;

public class PairingCreated extends DomainEvent {
    protected Date date;

    public PairingCreated(Date date) {
        super("com.propertyID.promotionsection.pairingcreated");
        this.date = date;
    }

    public Date getDate() {
        return date;
    }
}
