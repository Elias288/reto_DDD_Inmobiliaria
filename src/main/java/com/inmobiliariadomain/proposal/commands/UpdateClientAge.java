package com.inmobiliariadomain.proposal.commands;

import co.com.sofka.domain.generic.Command;
import com.inmobiliariadomain.proposal.values.Age;
import com.inmobiliariadomain.proposal.values.ClientID;
import com.inmobiliariadomain.proposal.values.ContractID;

public class UpdateClientAge extends Command {
    private final ContractID contractID;
    private final ClientID clientID;
    private final Age age;

    public UpdateClientAge(ContractID contractID, Age age, ClientID clientID) {
        this.contractID = contractID;
        this.age = age;
        this.clientID = clientID;
    }

    public ContractID getContractID() {
        return contractID;
    }

    public ClientID getClientID() {
        return clientID;
    }

    public Age getAge() {
        return age;
    }
}
