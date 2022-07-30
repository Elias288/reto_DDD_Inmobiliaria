package com.inmobiliariadomain.proposal.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.inmobiliariadomain.proposal.values.Area;
import com.inmobiliariadomain.proposal.values.PropertyID;

public class PropertyAreaUpdated extends DomainEvent {
    private final PropertyID propertyID;
    private final Area area;


    public PropertyAreaUpdated(PropertyID propertyID, Area area) {
        super("com.inmobiliariadomain.local.propertyareaupdated");
        this.propertyID = propertyID;
        this.area = area;
    }

    public PropertyID getPropertyID() {
        return propertyID;
    }

    public Area getArea() {
        return area;
    }
}
