package com.inmobiliariadomain.proposal.commands;

import co.com.sofka.domain.generic.Command;
import com.inmobiliariadomain.proposal.values.IsDone;
import com.inmobiliariadomain.proposal.values.ManagementID;

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
