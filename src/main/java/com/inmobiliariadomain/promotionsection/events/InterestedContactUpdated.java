package com.inmobiliariadomain.promotionsection.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.inmobiliariadomain.promotionsection.values.Contact;
import com.inmobiliariadomain.promotionsection.values.InterestedID;

public class InterestedContactUpdated extends DomainEvent {
    private final InterestedID interestedID;
    private final Contact contact;

    public InterestedContactUpdated(InterestedID interestedID, Contact contact) {
        super("com.inmobiliariadomain.promotionsection.interestedcontactupdated");
        this.interestedID = interestedID;
        this.contact = contact;
    }

    public InterestedID getInterestedID() {
        return interestedID;
    }

    public Contact getContact() {
        return contact;
    }
}
