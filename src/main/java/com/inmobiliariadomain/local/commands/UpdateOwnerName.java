package com.inmobiliariadomain.local.commands;

import co.com.sofka.domain.generic.Command;
import com.inmobiliariadomain.local.values.ManagementID;
import com.inmobiliariadomain.local.values.Name;
import com.inmobiliariadomain.local.values.OwnerID;

public class UpdateOwnerName extends Command {
    private final ManagementID managementID;
    private final OwnerID ownerID;
    private final Name name;

    public UpdateOwnerName(OwnerID ownerID, ManagementID managementID, Name name) {
        this.managementID = managementID;
        this.name = name;
        this.ownerID = ownerID;
    }

    public ManagementID getManagementID() {
        return managementID;
    }

    public OwnerID getOwnerID() {
        return ownerID;
    }
    public Name getName() {
        return name;
    }
}
