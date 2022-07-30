package com.inmobiliariadomain.proposal.proposal.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class ActivityType implements ValueObject<ActivityTypeEnum> {
    private final ActivityTypeEnum value;

    public ActivityType(ActivityTypeEnum value) {
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public ActivityTypeEnum value() {
        return this.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActivityType type = (ActivityType) o;
        return value == type.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
