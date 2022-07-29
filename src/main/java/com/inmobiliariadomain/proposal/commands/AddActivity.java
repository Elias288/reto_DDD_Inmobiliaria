package com.inmobiliariadomain.proposal.commands;

import co.com.sofka.domain.generic.Command;
import com.inmobiliariadomain.proposal.values.ActivityType;
import com.inmobiliariadomain.proposal.values.ContractID;
import com.inmobiliariadomain.proposal.values.IsDone;

import java.util.UUID;

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
