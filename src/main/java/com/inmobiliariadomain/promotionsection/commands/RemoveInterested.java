package com.inmobiliariadomain.promotionsection.commands;

import co.com.sofka.domain.generic.Command;
import com.inmobiliariadomain.promotionsection.values.InterestedID;
import com.inmobiliariadomain.promotionsection.values.PairingID;

public class RemoveInterested extends Command {
    private final PairingID pairingID;
    private final InterestedID interestedID;

    public RemoveInterested(PairingID pairingID, InterestedID interestedID) {
        this.pairingID = pairingID;
        this.interestedID = interestedID;
    }

    public PairingID getPairingID() {
        return pairingID;
    }

    public InterestedID getInterestedID() {
        return interestedID;
    }
}
