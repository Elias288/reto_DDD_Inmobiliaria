package com.inmobiliariadomain.local.commands;

import co.com.sofka.domain.generic.Command;
import com.inmobiliariadomain.local.entities.Owner;
import com.inmobiliariadomain.local.values.InitialDate;
import com.inmobiliariadomain.local.values.ManagementID;

public class CreateManagement extends Command {
    private final ManagementID managementID;
    private final InitialDate initialDate;

    public CreateManagement(ManagementID managementID, InitialDate initialDate) {
        this.managementID = managementID;
        this.initialDate = initialDate;
    }

    public ManagementID getManagementID() {
        return managementID;
    }

    public InitialDate getInitialDate() {
        return initialDate;
    }
}
