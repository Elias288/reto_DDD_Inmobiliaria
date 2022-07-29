package com.inmobiliariadomain.local.commands;

import co.com.sofka.domain.generic.Command;
import com.inmobiliariadomain.local.values.ManagementID;
import com.inmobiliariadomain.local.values.PropertyID;

public class RemoveProperty extends Command {
    private final ManagementID managementID;
    private final PropertyID propertyID;

    public RemoveProperty(ManagementID managementID, PropertyID propertyID) {
        this.managementID = managementID;
        this.propertyID = propertyID;
    }

    public ManagementID getManagementID() {
        return managementID;
    }

    public PropertyID getPropertyID() {
        return propertyID;
    }
}
