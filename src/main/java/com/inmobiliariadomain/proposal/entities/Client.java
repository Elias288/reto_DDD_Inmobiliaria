package com.inmobiliariadomain.proposal.entities;

import co.com.sofka.domain.generic.Entity;
import com.inmobiliariadomain.proposal.values.Age;
import com.inmobiliariadomain.proposal.values.ClientID;
import com.inmobiliariadomain.proposal.values.Contact;
import com.inmobiliariadomain.proposal.values.Name;

import java.util.Objects;

public class Client extends Entity<ClientID> {
    private Age age;
    private Contact contact;
    private Name name;

    public Client(ClientID entityId, Age age, Contact contact, Name name) {
        super(entityId);
        this.age = age;
        this.contact = contact;
        this.name = name;
    }

    public Age age() {
        return age;
    }

    public void updateAge(Age age) {
        this.age = Objects.requireNonNull(age);
    }

    public Contact contact() {
        return contact;
    }

    public void updateContact(Contact contact) {
        this.contact = Objects.requireNonNull(contact);
    }

    public Name name() {
        return name;
    }

    public void updateName(Name name) {
        this.name = Objects.requireNonNull(name);
    }
}
