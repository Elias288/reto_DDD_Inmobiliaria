package com.inmobiliariadomain.promotionsection.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.inmobiliariadomain.promotionsection.entities.Establishment;

public class PairingCreated extends DomainEvent {
    private final Establishment establishment;

    public PairingCreated(Establishment establishment) {
        super("com.propertyID.promotionsection.pairingcreated");
        this.establishment = establishment;
    }

    public Establishment getEstablishment() {
        return establishment;
    }
}
