package com.inmobiliariadomain.proposal.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.inmobiliariadomain.local.values.PropertyID;
import com.inmobiliariadomain.proposal.values.Name;

public class ContractCreated extends DomainEvent {
    private final PropertyID propertyID;

    public ContractCreated(PropertyID propertyID) {
        super("com.propertyID.proposal.contractcreated");
        this.propertyID = propertyID;
    }

    public PropertyID getPropertyID() {
        return propertyID;
    }
}
