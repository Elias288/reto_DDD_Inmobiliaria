package com.inmobiliariadomain.proposal.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.inmobiliariadomain.proposal.values.ClientID;
import com.inmobiliariadomain.proposal.values.Name;

public class ClientNameUpdated  extends DomainEvent {
    private final ClientID clientID;
    private final Name name;

    public ClientNameUpdated(ClientID clientID, Name name) {
        super("com.inmobiliariadomain.proposal.clientnameupdated");
        this.clientID = clientID;
        this.name = name;
    }

    public ClientID getClientID() {
        return clientID;
    }

    public Name getName() {
        return name;
    }
}
