package com.inmobiliariadomain.proposal.proposal.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class IsDone implements ValueObject<Boolean> {
    private final Boolean value;

    public IsDone(boolean value) {
        this.value = value;
    }

    @Override
    public Boolean value() {
        return this.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IsDone that = (IsDone) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
