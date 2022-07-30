package com.inmobiliariadomain.local.commands;

import co.com.sofka.domain.generic.Command;
import com.inmobiliariadomain.local.values.*;

public class AddProperty extends Command {
    private final ManagementID managementID;
    private final Price price;
    private final Area area;
    private final Address address;
    private final PropertyType propertyType;

    public AddProperty(ManagementID managementID, Price price, Area area, Address address, PropertyType propertyType) {
        this.price = price;
        this.area = area;
        this.address = address;
        this.propertyType = propertyType;
        this.managementID = managementID;
    }

    public ManagementID getManagementID() {
        return managementID;
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
