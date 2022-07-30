package com.inmobiliariadomain.proposal.commands;

import co.com.sofka.domain.generic.Command;
import com.inmobiliariadomain.proposal.values.ManagementID;
import com.inmobiliariadomain.proposal.values.PropertyID;

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
