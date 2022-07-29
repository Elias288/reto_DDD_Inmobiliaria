package com.inmobiliariadomain.local.commands;

import co.com.sofka.domain.generic.Command;
import com.inmobiliariadomain.local.values.ManagementID;
import com.inmobiliariadomain.local.values.Name;

public class UpdateOwnerName extends Command {
    private final ManagementID managementID;
    private final Name name;

    public UpdateOwnerName(ManagementID managementID, Name name) {
        this.managementID = managementID;
        this.name = name;
    }

    public ManagementID getManagementID() {
        return managementID;
    }

    public Name getName() {
        return name;
    }
}
