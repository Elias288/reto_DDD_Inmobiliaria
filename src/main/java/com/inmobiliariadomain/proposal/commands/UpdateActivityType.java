package com.inmobiliariadomain.proposal.commands;

import co.com.sofka.domain.generic.Command;
import com.inmobiliariadomain.proposal.values.ActivityType;
import com.inmobiliariadomain.proposal.values.ContractID;

public class UpdateActivityType extends Command {
    private final ContractID contractID;
    private final ActivityType activityType;

    public UpdateActivityType(ContractID contractID, ActivityType activityType) {
        this.contractID = contractID;
        this.activityType = activityType;
    }

    public ContractID getContractID() {
        return contractID;
    }

    public ActivityType getActivityType() {
        return activityType;
    }
}
