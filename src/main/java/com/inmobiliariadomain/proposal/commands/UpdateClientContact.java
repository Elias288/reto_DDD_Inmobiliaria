package com.inmobiliariadomain.proposal.commands;

import co.com.sofka.domain.generic.Command;
import com.inmobiliariadomain.proposal.values.ClientID;
import com.inmobiliariadomain.proposal.values.Contact;
import com.inmobiliariadomain.proposal.values.ContractID;

public class UpdateClientContact extends Command {
    private final ContractID contractID;
    private final ClientID clientID;
    private final Contact contact;

    public UpdateClientContact(ContractID contractID, Contact contact, ClientID clientID) {
        this.contractID = contractID;
        this.contact = contact;
        this.clientID = clientID;
    }

    public ContractID getContractID() {
        return contractID;
    }

    public ClientID getClientID() {
        return clientID;
    }

    public Contact getContact() {
        return contact;
    }
}
