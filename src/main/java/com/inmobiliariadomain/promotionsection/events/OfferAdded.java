package com.inmobiliariadomain.promotionsection.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.inmobiliariadomain.promotionsection.commands.UpdateOfferIsFinished;
import com.inmobiliariadomain.promotionsection.value.OfferDate;
import com.inmobiliariadomain.promotionsection.value.OfferID;

public class OfferAdded extends DomainEvent {
    private final OfferID offerID;
    private final OfferDate offerDate;

    public OfferAdded(OfferID offerID, OfferDate offerDate) {
        super("com.inmobiliariadomain.promotionsection.offeradded");
        this.offerID = offerID;
        this.offerDate = offerDate;
    }

    public OfferID getOfferID() {
        return offerID;
    }

    public OfferDate getOfferDate() {
        return offerDate;
    }
}
