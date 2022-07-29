package com.inmobiliariadomain.proposal.commands;

import co.com.sofka.domain.generic.Command;
import com.inmobiliariadomain.proposal.values.Commission;
import com.inmobiliariadomain.proposal.values.ContractID;
import com.inmobiliariadomain.proposal.values.Name;

public class AddEmployee extends Command {
    private final ContractID contractID;
    private final Name name;
    private final Commission commission;

    public AddEmployee(ContractID contractID, Name name, Commission commission) {
        this.contractID = contractID;
        this.name = name;
        this.commission = commission;
    }

    public ContractID getContractID() {
        return contractID;
    }

    public Name getName() {
        return name;
    }

    public Commission getCommission() {
        return commission;
    }
}
