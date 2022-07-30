package com.inmobiliariadomain.proposal.values;

import co.com.sofka.domain.generic.ValueObject;

import java.math.BigDecimal;
import java.util.Objects;

public class Commission implements ValueObject<BigDecimal> {
    private final BigDecimal value;

    public Commission(Integer value){
        this.value = Objects.requireNonNull(new BigDecimal(value));
    }

    @Override
    public BigDecimal value() {
        return this.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Commission that = (Commission) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
