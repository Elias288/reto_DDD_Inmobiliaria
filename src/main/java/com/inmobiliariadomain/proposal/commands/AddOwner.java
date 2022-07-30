package com.inmobiliariadomain.proposal.commands;

import co.com.sofka.domain.generic.Command;
import com.inmobiliariadomain.proposal.values.Debit;
import com.inmobiliariadomain.proposal.values.Name;
import com.inmobiliariadomain.proposal.proposal.values.Contact;

public class AddOwner extends Command {
    private final Debit debit;
    private final Name name;
    private final Contact contact;

    public AddOwner(Debit debit, Name name, Contact contact) {
        this.debit = debit;
        this.name = name;
        this.contact = contact;
    }

    public Debit getDebit() {
        return debit;
    }

    public Contact getContact() {
        return contact;
    }

    public Name getName() {
        return name;
    }
}
