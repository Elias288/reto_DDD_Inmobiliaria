package com.inmobiliariadomain.proposal.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.inmobiliariadomain.proposal.values.Name;
import com.inmobiliariadomain.proposal.values.OwnerID;

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
