package com.inmobiliariadomain.promotionsection.entities;

import co.com.sofka.domain.generic.Entity;
import com.inmobiliariadomain.promotionsection.value.IsFinished;
import com.inmobiliariadomain.promotionsection.value.OfferDate;
import com.inmobiliariadomain.promotionsection.value.OfferID;

import java.util.Objects;

public class Offer extends Entity<OfferID> {

    private OfferDate offerDate;
    private IsFinished isFinished;

    public Offer(OfferID entityId, OfferDate offerDate, IsFinished isFinished) {
        super(entityId);
        this.offerDate = offerDate;
        this.isFinished = isFinished;
    }

    public OfferDate getOfferDate() {
        return offerDate;
    }

    public IsFinished getIsFinished() {
        return isFinished;
    }
}
