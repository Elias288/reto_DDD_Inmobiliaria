package com.inmobiliariadomain.proposal.entities;

import co.com.sofka.domain.generic.Entity;
import com.inmobiliariadomain.proposal.values.*;

import java.util.Objects;

public class Property extends Entity<PropertyID> {
    private Price price;
    private Area area;
    private Address address;
    private PropertyType propertyType;

    public Property(PropertyID entityId, Price price, Area area, Address address) {
        super(entityId);
        this.price = price;
        this.area = area;
        this.address = address;
    }

    public Price price() {
        return price;
    }

    public void updatePrice(Price price) {
        this.price = Objects.requireNonNull(price);
    }

    public Area area() {
        return area;
    }

    public void updateArea(Area area) {
        this.area = Objects.requireNonNull(area);
    }

    public Address address() {
        return address;
    }

    public void updateAddress(Address address) {
        this.address = Objects.requireNonNull(address);
    }

    public PropertyType propertyType() {
        return propertyType;
    }

    public void updatePropertyType(PropertyType propertyType) {
        this.propertyType = Objects.requireNonNull(propertyType);
    }
}
