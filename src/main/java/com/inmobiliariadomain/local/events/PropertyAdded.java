package com.inmobiliariadomain.local.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.inmobiliariadomain.local.values.Address;
import com.inmobiliariadomain.local.values.Price;
import com.inmobiliariadomain.local.values.PropertyID;
import com.inmobiliariadomain.local.values.PropertyType;

public class PropertyAdded extends DomainEvent {
    private final PropertyID propertyID;
    private final Price price;
    private final Address address;
    private final PropertyType propertyType;

    public PropertyAdded(PropertyID propertyID, Price price, Address address, PropertyType propertyType) {
        super("com.inmobiliariadomain.local.propertyadded");
        this.propertyID = propertyID;
        this.price = price;
        this.address = address;
        this.propertyType = propertyType;
    }

    public PropertyID getPropertyID() {
        return propertyID;
    }

    public Price getPrice() {
        return price;
    }

    public Address getAddress() {
        return address;
    }

    public PropertyType getPropertyType() {
        return propertyType;
    }
}
