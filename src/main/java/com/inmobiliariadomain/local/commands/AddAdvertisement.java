package com.inmobiliariadomain.local.commands;

import co.com.sofka.domain.generic.Command;
import com.inmobiliariadomain.local.values.ExpirationDate;
import com.inmobiliariadomain.local.values.IsDone;
import com.inmobiliariadomain.local.values.ManagementID;

public class AddAdvertisement extends Command {
    private final ManagementID managementID;
    private final ExpirationDate expirationDate;
    private final IsDone isDone;

    public AddAdvertisement(ManagementID managementID, ExpirationDate expirationDate, IsDone isDone) {
        this.expirationDate = expirationDate;
        this.isDone = isDone;
        this.managementID = managementID;
    }

    public ManagementID getManagementID() {
        return managementID;
    }
    public ExpirationDate getExpirationDate() {
        return expirationDate;
    }

    public IsDone getIsDone() {
        return isDone;
    }
}
