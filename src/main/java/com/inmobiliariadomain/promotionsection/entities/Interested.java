package com.inmobiliariadomain.promotionsection.entities;

import co.com.sofka.domain.generic.Entity;
import com.inmobiliariadomain.promotionsection.value.Contact;
import com.inmobiliariadomain.promotionsection.value.InterestedID;
import com.inmobiliariadomain.promotionsection.value.Name;
import com.inmobiliariadomain.promotionsection.value.QueryType;

import java.util.Objects;

public class Interested extends Entity<InterestedID> {
    private Name name;
    private QueryType queryType;
    private Contact contact;

    public Interested(InterestedID entityId, Name name, QueryType queryType, Contact contact) {
        super(entityId);
        this.name = name;
        this.queryType = queryType;
        this.contact = contact;
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

    public void updateName(Name name) {
        this.name = Objects.requireNonNull(name);
    }

    public void updateQueryType(QueryType queryType) {
        this.queryType = Objects.requireNonNull(queryType);
    }

    public void updateContact(Contact contact) {
        this.contact = Objects.requireNonNull(contact);
    }
}
