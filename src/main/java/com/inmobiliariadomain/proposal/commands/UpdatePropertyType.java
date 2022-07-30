package com.inmobiliariadomain.proposal.commands;

import co.com.sofka.domain.generic.Command;
import com.inmobiliariadomain.proposal.values.ManagementID;
import com.inmobiliariadomain.proposal.values.PropertyType;

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
