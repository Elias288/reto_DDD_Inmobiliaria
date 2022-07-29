package com.inmobiliariadomain.proposal.commands;

import co.com.sofka.domain.generic.Command;
import com.inmobiliariadomain.proposal.values.ContractID;
import com.inmobiliariadomain.proposal.values.IsDone;

public class UpdateActivityIsDone extends Command {
    private final ContractID contractID;
    private final IsDone isDone;

    public UpdateActivityIsDone(ContractID contractID, IsDone isDone) {
        this.contractID = contractID;
        this.isDone = isDone;
    }

    public ContractID getContractID() {
        return contractID;
    }

    public IsDone getIsDone() {
        return isDone;
    }
}
