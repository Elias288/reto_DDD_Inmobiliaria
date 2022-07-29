package com.inmobiliariadomain.promotionsection.commands;

import co.com.sofka.domain.generic.Command;
import com.inmobiliariadomain.promotionsection.values.OfferID;
import com.inmobiliariadomain.promotionsection.values.PairingID;

public class UpdateOfferDate extends Command {
    private final PairingID pairingID;
    private final OfferID offerID;

    public UpdateOfferDate(PairingID pairingID, OfferID offerID) {
        this.pairingID = pairingID;
        this.offerID = offerID;
    }

    public PairingID getPairingID() {
        return pairingID;
    }

    public OfferID getOfferID() {
        return offerID;
    }
}
