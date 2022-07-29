package com.inmobiliariadomain.proposal.commands;

import co.com.sofka.domain.generic.Command;
import com.inmobiliariadomain.proposal.values.ActivityID;
import com.inmobiliariadomain.proposal.values.ContractID;
import com.inmobiliariadomain.proposal.values.IsDone;

public class UpdateActivityIsDone extends Command {
    private final ContractID contractID;
    private final ActivityID activityID;
    private final IsDone isDone;

    public UpdateActivityIsDone(ContractID contractID, IsDone isDone, ActivityID activityID) {
        this.contractID = contractID;
        this.isDone = isDone;
        this.activityID = activityID;
    }

    public ContractID getContractID() {
        return contractID;
    }

    public ActivityID getActivityID() {
        return activityID;
    }

    public IsDone getIsDone() {
        return isDone;
    }
}
