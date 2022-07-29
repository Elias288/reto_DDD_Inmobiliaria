package com.inmobiliariadomain.promotionsection.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.inmobiliariadomain.promotionsection.value.IsFinished;
import com.inmobiliariadomain.promotionsection.value.OfferID;

public class OfferIsFinishedUpdated extends DomainEvent {
    private final OfferID offerID;
    private final IsFinished isFinished;

    public OfferIsFinishedUpdated(OfferID offerID, IsFinished isFinished) {
        super("com.inmobiliariadomain.promotionsection.offerisfinishedupdate");
        this.offerID = offerID;
        this.isFinished = isFinished;
    }

    public OfferID getOfferID() {
        return offerID;
    }

    public IsFinished getIsFinished() {
        return isFinished;
    }
}
