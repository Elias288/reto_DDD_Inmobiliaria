package com.inmobiliariadomain.proposal.commands;

import co.com.sofka.domain.generic.Command;
import com.inmobiliariadomain.proposal.values.Area;
import com.inmobiliariadomain.proposal.values.ManagementID;

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
