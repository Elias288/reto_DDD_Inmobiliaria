package com.inmobiliariadomain.promotionsection.commands;

import co.com.sofka.domain.generic.Command;
import com.inmobiliariadomain.promotionsection.values.Address;
import com.inmobiliariadomain.promotionsection.values.PairingID;

public class UpdateEstablishmentAddress extends Command {
    private final PairingID pairingID;
    private final Address address;

    public UpdateEstablishmentAddress(PairingID pairingID, Address address) {
        this.pairingID = pairingID;
        this.address = address;
    }

    public PairingID getPairingID() {
        return pairingID;
    }

    public Address getAddress() {
        return address;
    }
}
