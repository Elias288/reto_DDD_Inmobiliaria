package com.inmobiliariadomain.proposal.commands;

import co.com.sofka.domain.generic.Command;
import com.inmobiliariadomain.proposal.values.Age;
import com.inmobiliariadomain.proposal.values.Contact;
import com.inmobiliariadomain.proposal.values.ContractID;
import com.inmobiliariadomain.proposal.values.Name;

public class AddClient extends Command {
    private final ContractID contractID;
    private final Name name;
    private final Contact contact;
    private final Age age;

    public AddClient(ContractID contractID, Name name, Contact contact, Age age) {
        this.contractID = contractID;
        this.name = name;
        this.contact = contact;
        this.age = age;
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

    public Age getAge() {
        return age;
    }
}
