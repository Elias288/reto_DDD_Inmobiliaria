package com.inmobiliariadomain.local.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.inmobiliariadomain.local.values.InitialDate;
import com.inmobiliariadomain.promotionsection.values.PairingID;

public class ManagementCreated extends DomainEvent {
    private final InitialDate initialDate;
    private final PairingID pairingID;

    public ManagementCreated(InitialDate initialDate, PairingID pairingID) {
        super("com.propertyID.local.managementcreated");
        this.initialDate = initialDate;
        this.pairingID = pairingID;
    }

    public InitialDate getInitialDate() {
        return initialDate;
    }

    public PairingID getPairingID() {
        return pairingID;
    }
}
