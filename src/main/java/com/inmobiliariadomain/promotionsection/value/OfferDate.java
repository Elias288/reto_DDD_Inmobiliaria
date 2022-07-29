package com.inmobiliariadomain.promotionsection.value;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Date;
import java.util.Objects;

public class OfferDate implements ValueObject<Date> {
    private final Date value;

    public OfferDate(Date value) {
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
        OfferDate offerDate = (OfferDate) o;
        return Objects.equals(value, offerDate.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
