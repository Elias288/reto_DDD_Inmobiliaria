package com.inmobiliariadomain.local.values;

import co.com.sofka.domain.generic.ValueObject;

import java.math.BigDecimal;
import java.util.Objects;

public class PropertyType implements ValueObject<PropertyTypeEnum> {
    private final PropertyTypeEnum value;

    public PropertyType(PropertyTypeEnum value) {
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public PropertyTypeEnum value() {
        return this.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PropertyType that = (PropertyType) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
