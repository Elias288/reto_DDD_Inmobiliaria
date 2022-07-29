package com.inmobiliariadomain.local.commands;

import co.com.sofka.domain.generic.Command;
import com.inmobiliariadomain.local.values.ManagementID;
import com.inmobiliariadomain.local.values.PropertyType;

public class UpdatePropertyType extends Command {
    private final ManagementID managementID;
    private final PropertyType propertyType;

    public UpdatePropertyType(ManagementID managementID, PropertyType propertyType) {
        this.managementID = managementID;
        this.propertyType = propertyType;
    }

    public ManagementID getManagementID() {
        return managementID;
    }

    public PropertyType getPropertyType() {
        return propertyType;
    }
}
