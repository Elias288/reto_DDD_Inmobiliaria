package com.inmobiliariadomain.promotionsection.commands;

import co.com.sofka.domain.generic.Command;
import com.inmobiliariadomain.promotionsection.values.OfferDate;
import com.inmobiliariadomain.promotionsection.values.OfferID;
import com.inmobiliariadomain.promotionsection.values.PairingID;

public class UpdateOfferDate extends Command {
    private final PairingID pairingID;
    private final OfferID offerID;
    private final OfferDate offerDate;

    public UpdateOfferDate(PairingID pairingID, OfferID offerID, OfferDate offerDate) {
        this.pairingID = pairingID;
        this.offerID = offerID;
        this.offerDate = offerDate;
    }

    public PairingID getPairingID() {
        return pairingID;
    }

    public OfferID getOfferID() {
        return offerID;
    }

    public OfferDate getOfferDate() {
        return offerDate;
    }
}
