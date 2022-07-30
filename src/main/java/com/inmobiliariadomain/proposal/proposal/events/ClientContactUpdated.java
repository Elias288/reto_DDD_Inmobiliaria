package com.inmobiliariadomain.proposal.proposal.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.inmobiliariadomain.proposal.proposal.values.ClientID;
import com.inmobiliariadomain.proposal.proposal.values.Contact;

public class ClientContactUpdated extends DomainEvent {
    private final ClientID clientID;
    private final Contact contact;


    public ClientContactUpdated(ClientID clientID, Contact contact) {
        super("com.inmobiliariadomain.proposal.clientcontactupdated");
        this.clientID = clientID;
        this.contact = contact;
    }

    public ClientID getClientID() {
        return clientID;
    }

    public Contact getContact() {
        return contact;
    }
}
