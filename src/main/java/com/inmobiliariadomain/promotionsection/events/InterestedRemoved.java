package com.inmobiliariadomain.promotionsection.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.inmobiliariadomain.promotionsection.value.InterestedID;

public class InterestedRemoved extends DomainEvent {
    private final InterestedID interestedID;
    private final Boolean wasDeleted;

    public InterestedRemoved(InterestedID interestedID) {
        super("com.inmobiliariadomain.promotionsection.interestedremoved");
        this.interestedID = interestedID;
        this.wasDeleted = true;
    }

    public InterestedID getInterestedID() {
        return interestedID;
    }

    public Boolean getWasDeleted() {
        return wasDeleted;
    }
}
