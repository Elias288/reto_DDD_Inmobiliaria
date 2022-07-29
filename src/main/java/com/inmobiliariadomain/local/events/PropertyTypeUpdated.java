package com.inmobiliariadomain.local.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.inmobiliariadomain.local.values.PropertyID;
import com.inmobiliariadomain.local.values.PropertyType;

public class PropertyTypeUpdated extends DomainEvent {
    private final PropertyID propertyID;
    private final PropertyType propertyType;

    public PropertyTypeUpdated(PropertyID propertyID, PropertyType propertyType) {
        super("com.inmobiliariadomain.local.properttypeupdated");
        this.propertyID = propertyID;
        this.propertyType = propertyType;
    }

    public PropertyID getPropertyID() {
        return propertyID;
    }

    public PropertyType getPropertyType() {
        return propertyType;
    }
}
