package com.inmobiliariadomain.local.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.inmobiliariadomain.local.entities.Owner;
import com.inmobiliariadomain.local.values.ManagementID;

public class ManagementCreated extends DomainEvent {
    private final Owner owner;

    public ManagementCreated(Owner owner) {
        super("com.propertyID.local.managementcreated");
        this.owner = owner;
    }

    public Owner getOwner() {
        return owner;
    }
}
