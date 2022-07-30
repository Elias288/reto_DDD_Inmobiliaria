package com.inmobiliariadomain.proposal.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.inmobiliariadomain.proposal.values.AdvertisementID;

public class AdvertisementRemoved extends DomainEvent {
    private final AdvertisementID advertisementID;
    private final Boolean wasDeleted;

    public AdvertisementRemoved(AdvertisementID advertisementID) {
        super("com.inmobiliariadomain.local.advertisementremoved");
        this.advertisementID = advertisementID;
        this.wasDeleted = true;
    }

    public AdvertisementID getAdvertisementID() {
        return advertisementID;
    }

    public Boolean getWasDeleted() {
        return wasDeleted;
    }
}
