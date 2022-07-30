package com.inmobiliariadomain.proposal.commands;

import co.com.sofka.domain.generic.Command;
import com.inmobiliariadomain.proposal.values.ExpirationDate;
import com.inmobiliariadomain.proposal.values.ManagementID;

public class UpdateAdvertisementExpirationDate extends Command {
    private final ManagementID managementID;
    private final ExpirationDate expirationDate;

    public UpdateAdvertisementExpirationDate(ManagementID managementID, ExpirationDate expirationDate) {
        this.managementID = managementID;
        this.expirationDate = expirationDate;
    }

    public ManagementID getManagementID() {
        return managementID;
    }

    public ExpirationDate getExpirationDate() {
        return expirationDate;
    }
}
