package com.inmobiliariadomain.local.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.inmobiliariadomain.local.entities.Owner;
import com.inmobiliariadomain.local.values.InitialDate;
import com.inmobiliariadomain.local.values.ManagementID;

public class ManagementCreated extends DomainEvent {
    private final InitialDate initialDate;

    public ManagementCreated(InitialDate initialDate) {
        super("com.propertyID.local.managementcreated");
        this.initialDate = initialDate;
    }

    public InitialDate getInitialDate() {
        return initialDate;
    }
}
