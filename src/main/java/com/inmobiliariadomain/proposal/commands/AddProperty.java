package com.inmobiliariadomain.proposal.commands;

import co.com.sofka.domain.generic.Command;
import com.inmobiliariadomain.proposal.values.Address;
import com.inmobiliariadomain.proposal.values.Area;
import com.inmobiliariadomain.proposal.values.Price;
import com.inmobiliariadomain.proposal.values.PropertyType;

public class AddProperty extends Command {
    private final Price price;
    private final Area area;
    private final Address address;
    private final PropertyType propertyType;

    public AddProperty(Price price, Area area, Address address, PropertyType propertyType) {
        this.price = price;
        this.area = area;
        this.address = address;
        this.propertyType = propertyType;
    }

    public Price getPrice() {
        return price;
    }

    public Area getArea() {
        return area;
    }

    public Address getAddress() {
        return address;
    }

    public PropertyType getPropertyType() {
        return propertyType;
    }
}
