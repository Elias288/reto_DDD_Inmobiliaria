package com.inmobiliariadomain.local.commands;

import co.com.sofka.domain.generic.Command;
import com.inmobiliariadomain.local.values.Debit;
import com.inmobiliariadomain.local.values.ManagementID;

public class UpdateOwnerDebit extends Command {
    private final ManagementID managementID;
    private final Debit debit;

    public UpdateOwnerDebit(ManagementID managementID, Debit debit) {
        this.managementID = managementID;
        this.debit = debit;
    }

    public ManagementID getManagementID() {
        return managementID;
    }

    public Debit getDebit() {
        return debit;
    }
}
