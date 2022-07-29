package com.inmobiliariadomain.proposal.commands;

import co.com.sofka.domain.generic.Command;
import com.inmobiliariadomain.proposal.values.Contact;
import com.inmobiliariadomain.proposal.values.ContractID;
import com.inmobiliariadomain.proposal.values.Name;

public class AddClient extends Command {
    private final ContractID contractID;
    private final Name name;
    private final Contact contact;

    public AddClient(ContractID contractID, Name name, Contact contact) {
        this.contractID = contractID;
        this.name = name;
        this.contact = contact;
    }

    public ContractID getContractID() {
        return contractID;
    }

    public Name getName() {
        return name;
    }

    public Contact getContact() {
        return contact;
    }
}
