package com.inmobiliariadomain.proposal.proposal.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Age implements ValueObject<Integer> {
    private final Integer value;

    public Age(Integer value) {
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
        Age age = (Age) o;
        return Objects.equals(value, age.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
