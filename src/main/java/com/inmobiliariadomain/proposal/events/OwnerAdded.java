package com.inmobiliariadomain.proposal.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.inmobiliariadomain.proposal.values.Contact;
import com.inmobiliariadomain.proposal.values.Debit;
import com.inmobiliariadomain.proposal.values.Name;
import com.inmobiliariadomain.proposal.values.OwnerID;

public class OwnerAdded extends DomainEvent {
    private final OwnerID ownerID;
    private final Name name;
    private final Debit debit;
    private final Contact contact;

    public OwnerAdded(OwnerID ownerID, Name name, Debit debit, Contact contact) {
        super("com.inmobiliariadomain.local.owneradded");
        this.ownerID = ownerID;
        this.name = name;
        this.debit = debit;
        this.contact = contact;
    }

    public OwnerID getOwnerID() {
        return ownerID;
    }

    public Name getName() {
        return name;
    }

    public Debit getDebit() {
        return debit;
    }

    public Contact getContact() {
        return contact;
    }
}
