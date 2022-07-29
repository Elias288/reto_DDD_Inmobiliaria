package com.inmobiliariadomain.local.commands;

import co.com.sofka.domain.generic.Command;
import com.inmobiliariadomain.local.values.Address;
import com.inmobiliariadomain.local.values.Area;
import com.inmobiliariadomain.local.values.Price;
import com.inmobiliariadomain.local.values.PropertyType;

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
