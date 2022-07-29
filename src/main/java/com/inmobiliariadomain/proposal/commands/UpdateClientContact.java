package com.inmobiliariadomain.proposal.commands;

import co.com.sofka.domain.generic.Command;
import com.inmobiliariadomain.proposal.values.Contact;
import com.inmobiliariadomain.proposal.values.ContractID;

public class UpdateClientContact extends Command {
    private final ContractID contractID;
    private final Contact contact;

    public UpdateClientContact(ContractID contractID, Contact contact) {
        this.contractID = contractID;
        this.contact = contact;
    }

    public ContractID getContractID() {
        return contractID;
    }

    public Contact getContact() {
        return contact;
    }
}
