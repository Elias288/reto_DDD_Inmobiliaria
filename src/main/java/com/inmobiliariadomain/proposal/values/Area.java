package com.inmobiliariadomain.proposal.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Area implements ValueObject<Integer> {
    private final Integer value;

    public Area(Integer value) {
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public Integer value() {
        return this.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Area area = (Area) o;
        return Objects.equals(value, area.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
