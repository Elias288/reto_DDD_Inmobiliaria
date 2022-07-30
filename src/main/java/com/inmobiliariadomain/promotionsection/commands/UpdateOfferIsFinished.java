package com.inmobiliariadomain.promotionsection.commands;

import co.com.sofka.domain.generic.Command;
import com.inmobiliariadomain.promotionsection.values.IsFinished;
import com.inmobiliariadomain.promotionsection.values.OfferID;
import com.inmobiliariadomain.promotionsection.values.PairingID;

public class UpdateOfferIsFinished extends Command {
    private final PairingID pairingID;
    private final OfferID offerID;
    private final IsFinished isFinished;

    public UpdateOfferIsFinished(PairingID pairingID,OfferID offerID, IsFinished isFinished) {
        this.pairingID = pairingID;
        this.isFinished = isFinished;
        this.offerID = offerID;
    }

    public PairingID getPairingID() {
        return pairingID;
    }

    public OfferID getOfferID() {
        return offerID;
    }

    public IsFinished getIsFinished() {
        return isFinished;
    }
}
