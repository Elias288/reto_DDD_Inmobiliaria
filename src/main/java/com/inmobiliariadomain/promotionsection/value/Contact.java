package com.inmobiliariadomain.promotionsection.value;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Contact implements ValueObject<String> {
    private final String value;

    public Contact(String value) {
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public String value() {
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return Objects.equals(value, contact.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
