package com.inmobiliariadomain.promotionsection.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.inmobiliariadomain.promotionsection.values.InterestedID;
import com.inmobiliariadomain.promotionsection.values.Name;

public class InterestedNameUpdated extends DomainEvent {
    private final InterestedID interestedID;
    private final Name name;

    public InterestedNameUpdated(InterestedID interestedID, Name name) {
        super("com.inmobiliariadomain.promotionsection.interestednameupdated");
        this.interestedID = interestedID;
        this.name = name;
    }

    public InterestedID getInterestedID() {
        return interestedID;
    }

    public Name getName() {
        return name;
    }
}
