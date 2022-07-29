package com.inmobiliariadomain.promotionsection.entities;

import co.com.sofka.domain.generic.Entity;
import com.inmobiliariadomain.promotionsection.values.IsFinished;
import com.inmobiliariadomain.promotionsection.values.OfferDate;
import com.inmobiliariadomain.promotionsection.values.OfferID;

import java.util.Objects;

public class Offer extends Entity<OfferID> {

    private OfferDate offerDate;
    private IsFinished isFinished;

    public Offer(OfferID entityId, OfferDate offerDate) {
        super(entityId);
        this.offerDate = offerDate;
        this.isFinished = new IsFinished(false);
    }

    public OfferDate getOfferDate() {
        return offerDate;
    }

    public IsFinished getIsFinished() {
        return isFinished;
    }

    public void updateOfferDate(OfferDate offerDate) {
        this.offerDate = Objects.requireNonNull(offerDate);
    }

    public void toggleIsFinished(IsFinished isFinished) {
        this.isFinished = Objects.requireNonNull(isFinished);
    }
}
