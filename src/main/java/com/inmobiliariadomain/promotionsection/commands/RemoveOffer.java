package com.inmobiliariadomain.promotionsection.commands;

import co.com.sofka.domain.generic.Command;
import com.inmobiliariadomain.promotionsection.value.OfferID;
import com.inmobiliariadomain.promotionsection.value.PairingID;

public class RemoveOffer extends Command {
    private final PairingID pairingID;
    private final OfferID offerID;

    public RemoveOffer(PairingID pairingID, OfferID offerID) {
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