package com.inmobiliariadomain.promotionsection.commands;

import co.com.sofka.domain.generic.Command;
import com.inmobiliariadomain.promotionsection.values.IsFinished;
import com.inmobiliariadomain.promotionsection.values.OfferDate;
import com.inmobiliariadomain.promotionsection.values.PairingID;

public class AddOffer extends Command {
    private final PairingID pairingID;
    private final OfferDate offerDate;
    private final IsFinished isFinished;

    public AddOffer(PairingID pairingID, OfferDate offerDate, IsFinished isFinished) {
        this.pairingID = pairingID;
        this.offerDate = offerDate;
        this.isFinished = isFinished;
    }

    public PairingID getPairingID() {
        return pairingID;
    }
    public OfferDate getOfferDate() {
        return offerDate;
    }

    public IsFinished getIsFinished() {
        return isFinished;
    }
}
