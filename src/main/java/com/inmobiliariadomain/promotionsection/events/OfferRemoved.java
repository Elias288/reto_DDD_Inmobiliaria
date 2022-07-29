package com.inmobiliariadomain.promotionsection.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.inmobiliariadomain.local.values.AdvertisementID;
import com.inmobiliariadomain.promotionsection.value.OfferID;

public class OfferRemoved extends DomainEvent {
    private final OfferID offerID;
    private final Boolean wasDeleted;

    public OfferRemoved(OfferID offerID) {
        super("com.inmobiliariadomain.promotionsection.offerremoved");
        this.offerID = offerID;
        this.wasDeleted = true;
    }

    public OfferID getOfferID() {
        return offerID;
    }

    public Boolean getWasDeleted() {
        return wasDeleted;
    }
}
