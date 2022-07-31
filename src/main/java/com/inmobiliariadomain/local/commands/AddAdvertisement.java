package com.inmobiliariadomain.local.commands;

import co.com.sofka.domain.generic.Command;
import com.inmobiliariadomain.local.values.ExpirationDate;
import com.inmobiliariadomain.local.values.IsDone;
import com.inmobiliariadomain.local.values.ManagementID;

public class AddAdvertisement extends Command {
    private final ManagementID managementID;
    private final ExpirationDate expirationDate;

    public AddAdvertisement(ManagementID managementID, ExpirationDate expirationDate) {
        this.expirationDate = expirationDate;
        this.managementID = managementID;
    }

    public ManagementID getManagementID() {
        return managementID;
    }
    public ExpirationDate getExpirationDate() {
        return expirationDate;
    }

}
