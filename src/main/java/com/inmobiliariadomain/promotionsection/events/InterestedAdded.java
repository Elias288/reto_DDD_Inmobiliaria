package com.inmobiliariadomain.promotionsection.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.inmobiliariadomain.promotionsection.values.Contact;
import com.inmobiliariadomain.promotionsection.values.InterestedID;
import com.inmobiliariadomain.promotionsection.values.Name;
import com.inmobiliariadomain.promotionsection.values.QueryType;

public class InterestedAdded extends DomainEvent {
    private final InterestedID interestedID;
    private final Name name;
    private final QueryType queryType;
    private final Contact contact;

    public InterestedAdded(InterestedID interestedID, Name name, QueryType queryType, Contact contact) {
        super("com.inmobiliariadomain.promotionsection.interestedadded");
        this.interestedID = interestedID;
        this.name = name;
        this.queryType = queryType;
        this.contact = contact;
    }

    public InterestedID getInterestedID() {
        return interestedID;
    }

    public Name getName() {
        return name;
    }

    public QueryType getQueryType() {
        return queryType;
    }

    public Contact getContact() {
        return contact;
    }
}
