package com.inmobiliariadomain.local.commands;

import co.com.sofka.domain.generic.Command;
import com.inmobiliariadomain.local.values.Area;
import com.inmobiliariadomain.local.values.ManagementID;
import com.inmobiliariadomain.local.values.PropertyID;

public class UpdatePropertyArea extends Command {
    private final ManagementID managementID;
    private final PropertyID propertyID;
    private final Area area;

    public UpdatePropertyArea(ManagementID managementID, PropertyID propertyID, Area area) {
        this.managementID = managementID;
        this.area = area;
        this.propertyID = propertyID;
    }

    public ManagementID getManagementID() {
        return managementID;
    }

    public PropertyID getPropertyID() {
        return propertyID;
    }
    public Area getArea() {
        return area;
    }
}
