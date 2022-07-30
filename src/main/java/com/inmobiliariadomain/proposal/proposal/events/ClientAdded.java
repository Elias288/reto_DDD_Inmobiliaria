package com.inmobiliariadomain.proposal.proposal.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.inmobiliariadomain.proposal.proposal.values.Age;
import com.inmobiliariadomain.proposal.proposal.values.ClientID;
import com.inmobiliariadomain.proposal.proposal.values.Contact;
import com.inmobiliariadomain.proposal.proposal.values.Name;

public class ClientAdded extends DomainEvent {
    private final ClientID clientID;
    private final Name name;
    private final Age age;
    private final Contact contact;

    public ClientAdded(ClientID clientID, Name name, Age age, Contact contact) {
        super("com.inmobiliariadomain.proposal.clienteadded");
        this.clientID = clientID;
        this.name = name;
        this.age = age;
        this.contact = contact;
    }

    public ClientID getClientID() {
        return clientID;
    }

    public Name getName() {
        return name;
    }

    public Age getAge() {
        return age;
    }

    public Contact getContact() {
        return contact;
    }
}
