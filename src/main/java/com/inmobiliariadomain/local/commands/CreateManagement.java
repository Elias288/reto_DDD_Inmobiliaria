package com.inmobiliariadomain.local.commands;

import co.com.sofka.domain.generic.Command;
import com.inmobiliariadomain.local.entities.Owner;
import com.inmobiliariadomain.local.values.InitialDate;
import com.inmobiliariadomain.local.values.ManagementID;
import com.inmobiliariadomain.promotionsection.Pairing;
import com.inmobiliariadomain.promotionsection.values.PairingID;

public class CreateManagement extends Command {
    private final ManagementID managementID;
    private final InitialDate initialDate;
    private final PairingID pairing;

    public CreateManagement(ManagementID managementID, InitialDate initialDate, PairingID pairing) {
        this.managementID = managementID;
        this.initialDate = initialDate;
        this.pairing = pairing;
    }

    public ManagementID getManagementID() {
        return managementID;
    }

    public InitialDate getInitialDate() {
        return initialDate;
    }

    public PairingID getPairing() {
        return pairing;
    }
}
