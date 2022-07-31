package com.inmobiliariadomain.promotionsection.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class QueryType implements ValueObject<QueryTypeEnum> {
    private final QueryTypeEnum value;

    public QueryType(QueryTypeEnum value) {
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public QueryTypeEnum value() {
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
