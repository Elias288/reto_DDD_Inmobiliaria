package com.inmobiliariadomain.proposal.proposal.commands;

import co.com.sofka.domain.generic.Command;
import com.inmobiliariadomain.proposal.proposal.values.ActivityID;
import com.inmobiliariadomain.proposal.proposal.values.ActivityType;
import com.inmobiliariadomain.proposal.proposal.values.ContractID;

public class UpdateActivityType extends Command {
    private final ContractID contractID;
    private final ActivityID activityID;
    private final ActivityType activityType;

    public UpdateActivityType(ContractID contractID, ActivityType activityType, ActivityID activityID) {
        this.contractID = contractID;
        this.activityType = activityType;
        this.activityID = activityID;
    }

    public ContractID getContractID() {
        return contractID;
    }

    public ActivityID getActivityID() {
        return activityID;
    }

    public ActivityType getActivityType() {
        return activityType;
    }
}
