package com.inmobiliariadomain.proposal.commands;

import co.com.sofka.domain.generic.Command;
import com.inmobiliariadomain.proposal.values.ContractID;
import com.inmobiliariadomain.proposal.values.Name;

public class CreateContract extends Command {
    private final ContractID contractID;
    private final Name name;

    public CreateContract(ContractID contractID, Name name) {
        this.contractID = contractID;
        this.name = name;
    }

    public ContractID getContractID() {
        return contractID;
    }

    public Name getName() {
        return name;
    }
}
