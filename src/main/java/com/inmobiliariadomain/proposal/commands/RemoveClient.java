package com.inmobiliariadomain.proposal.commands;

import co.com.sofka.domain.generic.Command;
import com.inmobiliariadomain.proposal.values.ClientID;
import com.inmobiliariadomain.proposal.values.ContractID;

public class RemoveClient extends Command {
    private final ContractID contractID;
    private final ClientID clientID;

    public RemoveClient(ContractID contractID, ClientID clientID) {
        this.contractID = contractID;
        this.clientID = clientID;
    }

    public ContractID getContractID() {
        return contractID;
    }

    public ClientID getClientID() {
        return clientID;
    }
}
