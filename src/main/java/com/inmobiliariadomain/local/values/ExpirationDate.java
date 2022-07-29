package com.inmobiliariadomain.local.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Date;
import java.util.Objects;

public class ExpirationDate implements ValueObject<Date> {
    private final Date value;

    public ExpirationDate(Date value) {
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
        ExpirationDate that = (ExpirationDate) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
