package com.inmobiliariadomain.proposal.proposal.commands;

import co.com.sofka.domain.generic.Command;
import com.inmobiliariadomain.proposal.proposal.values.ActivityType;
import com.inmobiliariadomain.proposal.proposal.values.ContractID;
import com.inmobiliariadomain.proposal.proposal.values.IsDone;

public class AddActivity extends Command {
    private final ContractID contractID;
    private final ActivityType activityType;
    private final IsDone isDone;


    public AddActivity(ContractID contractID, ActivityType activityType, IsDone isDone) {
        this.contractID = contractID;
        this.activityType = activityType;
        this.isDone = isDone;
    }

    public ContractID getContractID() {
        return contractID;
    }

    public ActivityType getActivityType() {
        return activityType;
    }

    public IsDone getIsDone() {
        return isDone;
    }
}
