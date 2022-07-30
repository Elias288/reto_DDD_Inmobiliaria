package com.inmobiliariadomain.promotionsection.commands;

import co.com.sofka.domain.generic.Command;
import com.inmobiliariadomain.promotionsection.values.InterestedID;
import com.inmobiliariadomain.promotionsection.values.Name;
import com.inmobiliariadomain.promotionsection.values.PairingID;

public class UpdateInterestedName extends Command {
    private final PairingID pairingID;
    private final InterestedID interestedID;
    private final Name name;

    public UpdateInterestedName(PairingID pairingID,InterestedID interestedID, Name name) {
        this.pairingID = pairingID;
        this.name = name;
        this.interestedID = interestedID;
    }

    public PairingID getPairingID() {
        return pairingID;
    }

    public InterestedID getInterestedID() {
        return interestedID;
    }
    public Name getName() {
        return name;
    }
}


