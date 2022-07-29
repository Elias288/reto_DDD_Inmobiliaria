package com.inmobiliariadomain.proposal.commands;

import co.com.sofka.domain.generic.Command;
import com.inmobiliariadomain.proposal.values.ClientID;
import com.inmobiliariadomain.proposal.values.ContractID;
import com.inmobiliariadomain.proposal.values.Name;

public class UpdateClientName extends Command {
    private final ContractID contractID;
    private final ClientID clientID;
    private final Name name;

    public UpdateClientName(ContractID contractID, ClientID clientID, Name name) {
        this.contractID = contractID;
        this.name = name;
        this.clientID = clientID;
    }

    public ContractID getContractID() {
        return contractID;
    }

    public ClientID getClientID() {
        return clientID;
    }

    public Name getName() {
        return name;
    }
}
