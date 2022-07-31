package com.inmobiliariadomain.local.commands;

import co.com.sofka.domain.generic.Command;
import com.inmobiliariadomain.local.values.ManagementID;
import com.inmobiliariadomain.local.values.PropertyID;
import com.inmobiliariadomain.local.values.PropertyType;

public class UpdatePropertyType extends Command {
    private final ManagementID managementID;
    private final PropertyID propertyID;
    private final PropertyType propertyType;

    public UpdatePropertyType(ManagementID managementID, PropertyID propertyID, PropertyType propertyType) {
        this.managementID = managementID;
        this.propertyType = propertyType;
        this.propertyID = propertyID;
    }

    public ManagementID getManagementID() {
        return managementID;
    }

    public PropertyID getPropertyID() {
        return propertyID;
    }
    public PropertyType getPropertyType() {
        return propertyType;
    }
}
