package com.inmobiliariadomain.promotionsection.commands;

import co.com.sofka.domain.generic.Command;
import com.inmobiliariadomain.promotionsection.values.Contact;
import com.inmobiliariadomain.promotionsection.values.Name;
import com.inmobiliariadomain.promotionsection.values.PairingID;
import com.inmobiliariadomain.promotionsection.values.QueryType;

public class AddInterested extends Command {
    private final PairingID pairingID;
    private final QueryType queryType;
    private final Name name;
    private final Contact contact;

    public AddInterested(PairingID pairingID, QueryType queryType, Name name, Contact contact) {
        this.pairingID = pairingID;
        this.queryType = queryType;
        this.name = name;
        this.contact = contact;
    }

    public PairingID getPairingID() {
        return pairingID;
    }
    public QueryType getQueryType() {
        return queryType;
    }

    public Name getName() {
        return name;
    }

    public Contact getContact() {
        return contact;
    }
}
