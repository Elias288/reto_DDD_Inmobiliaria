package com.inmobiliariadomain.local.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Date;
import java.util.Objects;

public class InitialDate implements ValueObject<Date> {
    private final Date value;

    public InitialDate(Date value) {
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public Date value() {
        return this.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InitialDate that = (InitialDate) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
