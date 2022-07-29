package com.inmobiliariadomain.proposal.commands;

import co.com.sofka.domain.generic.Command;
import com.inmobiliariadomain.proposal.values.Age;
import com.inmobiliariadomain.proposal.values.ContractID;

public class UpdateClientAge extends Command {
    private final ContractID contractID;
    private final Age age;

    public UpdateClientAge(ContractID contractID, Age age) {
        this.contractID = contractID;
        this.age = age;
    }

    public ContractID getContractID() {
        return contractID;
    }

    public Age getAge() {
        return age;
    }
}
