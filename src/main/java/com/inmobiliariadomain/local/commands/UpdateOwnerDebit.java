package com.inmobiliariadomain.local.commands;

import co.com.sofka.domain.generic.Command;
import com.inmobiliariadomain.local.values.Debit;
import com.inmobiliariadomain.local.values.ManagementID;
import com.inmobiliariadomain.local.values.OwnerID;

public class UpdateOwnerDebit extends Command {
    private final ManagementID managementID;
    private final OwnerID ownerID;
    private final Debit debit;

    public UpdateOwnerDebit(OwnerID ownerID, ManagementID managementID, Debit debit) {
        this.managementID = managementID;
        this.debit = debit;
        this.ownerID = ownerID;
    }

    public ManagementID getManagementID() {
        return managementID;
    }

    public OwnerID getOwnerID() {
        return ownerID;
    }
    public Debit getDebit() {
        return debit;
    }
}
