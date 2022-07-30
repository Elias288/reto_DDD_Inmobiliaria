package com.inmobiliariadomain.promotionsection.commands;

import co.com.sofka.domain.generic.Command;
import com.inmobiliariadomain.promotionsection.values.Address;
import com.inmobiliariadomain.promotionsection.values.PairingID;

public class AddEstablishment extends Command {
    private final PairingID pairingID;
    private final Address address;

    public AddEstablishment(Address address, PairingID pairingID) {
        this.address = address;
        this.pairingID = pairingID;
    }

    public PairingID getPairingID() {
        return pairingID;
    }

    public Address getAddress() {
        return address;
    }
}
