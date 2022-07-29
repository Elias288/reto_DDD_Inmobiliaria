package com.inmobiliariadomain.promotionsection.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.inmobiliariadomain.promotionsection.value.Address;
import com.inmobiliariadomain.promotionsection.value.EstablishmentID;

public class EstablishmentAddresUpdated extends DomainEvent {
    private final EstablishmentID establishmentID;
    private final Address address;

    public EstablishmentAddresUpdated(EstablishmentID establishmentID, Address address) {
        super("com.inmobiliariadomain.local.ownercontactupdated");
        this.establishmentID = establishmentID;
        this.address = address;
    }

    public EstablishmentID getEstablishmentID() {
        return establishmentID;
    }

    public Address getAddress() {
        return address;
    }
}
