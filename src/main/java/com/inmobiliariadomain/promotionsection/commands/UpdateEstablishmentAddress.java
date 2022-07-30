package com.inmobiliariadomain.promotionsection.commands;

import co.com.sofka.domain.generic.Command;
import com.inmobiliariadomain.promotionsection.values.Address;
import com.inmobiliariadomain.promotionsection.values.EstablishmentID;
import com.inmobiliariadomain.promotionsection.values.PairingID;

public class UpdateEstablishmentAddress extends Command {
    private final PairingID pairingID;
    private final EstablishmentID establishmentID;
    private final Address address;

    public UpdateEstablishmentAddress(PairingID pairingID,EstablishmentID establishmentID, Address address) {
        this.pairingID = pairingID;
        this.address = address;
        this.establishmentID = establishmentID;
    }

    public PairingID getPairingID() {
        return pairingID;
    }

    public EstablishmentID getEstablishmentID() {
        return establishmentID;
    }

    public Address getAddress() {
        return address;
    }
}
