package com.inmobiliariadomain.promotionsection.commands;

import co.com.sofka.domain.generic.Command;
import com.inmobiliariadomain.promotionsection.value.IsFinished;
import com.inmobiliariadomain.promotionsection.value.OfferDate;

public class AddOffer extends Command {
    private final OfferDate offerDate;
    private final IsFinished isFinished;

    public AddOffer(OfferDate offerDate, IsFinished isFinished) {
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
