package com.inmobiliariadomain.promotionsection.commands;

import co.com.sofka.domain.generic.Command;
import com.inmobiliariadomain.promotionsection.value.IsFinished;
import com.inmobiliariadomain.promotionsection.value.PairingID;

public class UpdateOfferIsFinished extends Command {
    private final PairingID pairingID;
    private final IsFinished isFinished;

    public UpdateOfferIsFinished(PairingID pairingID, IsFinished isFinished) {
        this.pairingID = pairingID;
        this.isFinished = isFinished;
    }

    public PairingID getPairingID() {
        return pairingID;
    }

    public IsFinished getIsFinished() {
        return isFinished;
    }
}
