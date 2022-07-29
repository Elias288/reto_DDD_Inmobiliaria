package com.inmobiliariadomain.local.commands;

import co.com.sofka.domain.generic.Command;
import com.inmobiliariadomain.local.values.Area;
import com.inmobiliariadomain.local.values.ManagementID;

public class UpdatePropertyArea extends Command {
    private final ManagementID managementID;
    private final Area area;

    public UpdatePropertyArea(ManagementID managementID, Area area) {
        this.managementID = managementID;
        this.area = area;
    }

    public ManagementID getManagementID() {
        return managementID;
    }

    public Area getArea() {
        return area;
    }
}
