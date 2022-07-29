package com.inmobiliariadomain.proposal.commands;

import co.com.sofka.domain.generic.Command;
import com.inmobiliariadomain.proposal.values.ActivityID;
import com.inmobiliariadomain.proposal.values.ContractID;

public class RemoveActivity extends Command {
    private final ContractID contractID;
    private final ActivityID activityID;

    public RemoveActivity(ContractID contractID, ActivityID activityID) {
        this.contractID = contractID;
        this.activityID = activityID;
    }

    public ContractID getContractID() {
        return contractID;
    }

    public ActivityID getActivityID() {
        return activityID;
    }
}
