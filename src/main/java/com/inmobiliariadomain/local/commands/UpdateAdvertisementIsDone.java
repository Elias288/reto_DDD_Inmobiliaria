package com.inmobiliariadomain.local.commands;

import co.com.sofka.domain.generic.Command;
import com.inmobiliariadomain.local.values.IsDone;
import com.inmobiliariadomain.local.values.ManagementID;

public class UpdateAdvertisementIsDone extends Command {
    private final ManagementID managementID;
    private final IsDone isDone;

    public UpdateAdvertisementIsDone(ManagementID managementID, IsDone isDone) {
        this.managementID = managementID;
        this.isDone = isDone;
    }

    public ManagementID getManagementID() {
        return managementID;
    }

    public IsDone getIsDone() {
        return isDone;
    }
}
