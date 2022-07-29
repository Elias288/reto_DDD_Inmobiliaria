package com.inmobiliariadomain.promotionsection.commands;

import co.com.sofka.domain.generic.Command;
import com.inmobiliariadomain.local.values.Contact;
import com.inmobiliariadomain.promotionsection.value.Name;
import com.inmobiliariadomain.promotionsection.value.QueryType;

public class AddInterested extends Command {
    private final QueryType queryType;
    private final Name name;
    private final Contact contact;

    public AddInterested(QueryType queryType, Name name, Contact contact) {
        this.queryType = queryType;
        this.name = name;
        this.contact = contact;
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
