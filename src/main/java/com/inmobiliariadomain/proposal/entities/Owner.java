package com.inmobiliariadomain.proposal.entities;

import co.com.sofka.domain.generic.Entity;
import com.inmobiliariadomain.proposal.values.Contact;
import com.inmobiliariadomain.proposal.values.Debit;
import com.inmobiliariadomain.proposal.values.Name;
import com.inmobiliariadomain.proposal.values.OwnerID;

import java.util.Objects;

public class Owner extends Entity<OwnerID> {
    private Debit debit;
    private Name name;
    private Contact contact;

    public Owner(OwnerID entityId, Debit debit, Name name, Contact contact) {
        super(entityId);
        this.debit = debit;
        this.name = name;
        this.contact = contact;
    }

    public Debit debit() {
        return debit;
    }

    public void updateDebit(Debit debit) {
        this.debit = Objects.requireNonNull(debit);
    }

    public Name name() {
        return name;
    }

    public void updateName(Name name) {
        this.name = Objects.requireNonNull(name);
    }

    public Contact contact() {
        return contact;
    }

    public void updateContact(Contact contact) {
        this.contact = Objects.requireNonNull(contact);
    }
}
