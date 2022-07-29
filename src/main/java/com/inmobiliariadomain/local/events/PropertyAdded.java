package com.inmobiliariadomain.local.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.inmobiliariadomain.local.values.*;

public class PropertyAdded extends DomainEvent {
    private final PropertyID propertyID;
    private final Price price;
    private final Address address;
    private final PropertyType propertyType;
    private final Area area;

    public PropertyAdded(PropertyID propertyID, Price price, Address address, PropertyType propertyType, Area area) {
        super("com.inmobiliariadomain.local.propertyadded");
        this.propertyID = propertyID;
        this.price = price;
        this.address = address;
        this.propertyType = propertyType;
        this.area = area;
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

    public Area getArea() {
        return area;
    }
}
