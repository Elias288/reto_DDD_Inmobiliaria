package com.inmobiliariadomain.proposal.commands;

import co.com.sofka.domain.generic.Command;
import com.inmobiliariadomain.proposal.values.Debit;
import com.inmobiliariadomain.proposal.values.ManagementID;

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
