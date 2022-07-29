package com.inmobiliariadomain.proposal.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.inmobiliariadomain.proposal.values.Age;
import com.inmobiliariadomain.proposal.values.ClientID;

public class ClientAgeUpdated extends DomainEvent {
    private final ClientID clientID;
    private final Age age;

    public ClientAgeUpdated(ClientID clientID, Age age) {
        super("com.inmobiliariadomain.proposal.clientageupdated");
        this.clientID = clientID;
        this.age = age;
    }

    public ClientID getClientID() {
        return clientID;
    }

    public Age getAge() {
        return age;
    }
}
