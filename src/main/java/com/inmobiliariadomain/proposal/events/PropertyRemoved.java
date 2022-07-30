package com.inmobiliariadomain.proposal.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.inmobiliariadomain.proposal.values.PropertyID;

public class PropertyRemoved extends DomainEvent {
    private final PropertyID propertyID;
    private final Boolean wasDeleted;

    public PropertyRemoved(PropertyID propertyID) {
        super("com.inmobiliariadomain.local.propertyremoved");
        this.propertyID = propertyID;
        this.wasDeleted = true;
    }

    public PropertyID getPropertyID() {
        return propertyID;
    }

    public Boolean getWasDeleted() {
        return wasDeleted;
    }
}
