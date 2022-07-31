package com.inmobiliariadomain.promotionsection.commands;

import co.com.sofka.domain.generic.Command;
import com.inmobiliariadomain.promotionsection.values.PairingID;

public class CreatePairing extends Command {
    private final PairingID contractID;
    public CreatePairing(PairingID contractID) {
        this.contractID = contractID;
    }

    public PairingID getContractID() {
        return contractID;
    }
}
