package com.inmobiliariadomain.promotionsection.value;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class QueryType implements ValueObject<String> {
    private final String value;

    public QueryType(String value) {
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public String value() {
        return this.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QueryType queryType = (QueryType) o;
        return Objects.equals(value, queryType.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
