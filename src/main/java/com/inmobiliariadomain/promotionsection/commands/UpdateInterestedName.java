package com.inmobiliariadomain.promotionsection.commands;

import co.com.sofka.domain.generic.Command;
import com.inmobiliariadomain.promotionsection.values.Name;
import com.inmobiliariadomain.promotionsection.values.PairingID;

public class UpdateInterestedName extends Command {
    private final PairingID pairingID;
    private final Name name;

    public UpdateInterestedName(PairingID pairingID, Name name) {
        this.pairingID = pairingID;
        this.name = name;
    }

    public PairingID getPairingID() {
        return pairingID;
    }

    public Name getName() {
        return name;
    }
}


