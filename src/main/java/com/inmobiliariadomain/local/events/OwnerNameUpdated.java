package com.inmobiliariadomain.local.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.inmobiliariadomain.local.values.Name;
import com.inmobiliariadomain.local.values.OwnerID;

public class OwnerNameUpdated extends DomainEvent {
    private final OwnerID ownerID;
    private final Name name;

    public OwnerNameUpdated(OwnerID ownerID, Name name) {
        super("com.inmobiliariadomain.local.ownernameupdated");
        this.ownerID = ownerID;
        this.name = name;
    }

    public OwnerID getOwnerID() {
        return ownerID;
    }

    public Name getName() {
        return name;
    }
}
