package com.inmobiliariadomain.local.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.inmobiliariadomain.local.values.Contact;
import com.inmobiliariadomain.local.values.OwnerID;

public class OwnerContactUpdated extends DomainEvent {
    private final OwnerID ownerID;
    private final Contact contact;

    public OwnerContactUpdated(OwnerID ownerID, Contact contact) {
        super("com.inmobiliariadomain.local.ownercontactupdated");
        this.ownerID = ownerID;
        this.contact = contact;
    }

    public OwnerID getOwnerID() {
        return ownerID;
    }

    public Contact getContact() {
        return contact;
    }
}
