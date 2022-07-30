package com.inmobiliariadomain.proposal.values;

import co.com.sofka.domain.generic.ValueObject;

import java.math.BigDecimal;
import java.util.Objects;

public class Debit implements ValueObject<BigDecimal> {
    private final BigDecimal value;

    public Debit(BigDecimal value) {
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public BigDecimal value() {
        return this.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Debit debit = (Debit) o;
        return Objects.equals(value, debit.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
