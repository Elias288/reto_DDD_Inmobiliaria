package com.inmobiliariadomain.local.commands;

import co.com.sofka.domain.generic.Command;
import com.inmobiliariadomain.local.values.Address;
import com.inmobiliariadomain.local.values.ManagementID;
import com.inmobiliariadomain.local.values.PropertyID;

public class UpdatePropertyAddress extends Command {
    private final ManagementID managementID;
    private final PropertyID propertyID;
    private final Address address;

    public UpdatePropertyAddress(PropertyID propertyID, ManagementID managementID, Address address) {
        this.managementID = managementID;
        this.address = address;
        this.propertyID = propertyID;
    }

    public ManagementID getManagementID() {
        return managementID;
    }

    public PropertyID getPropertyID() {
        return propertyID;
    }

    public Address getAddress() {
        return address;
    }
}
