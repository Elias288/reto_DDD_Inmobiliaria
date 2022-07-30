package com.inmobiliariadomain.local.commands;

import co.com.sofka.domain.generic.Command;
import com.inmobiliariadomain.local.values.AdvertisementID;
import com.inmobiliariadomain.local.values.IsDone;
import com.inmobiliariadomain.local.values.ManagementID;

public class UpdateAdvertisementIsDone extends Command {
    private final ManagementID managementID;
    private final AdvertisementID advertisementID;
    private final IsDone isDone;

    public UpdateAdvertisementIsDone(AdvertisementID advertisementID, ManagementID managementID, IsDone isDone) {
        this.managementID = managementID;
        this.isDone = isDone;
        this.advertisementID = advertisementID;
    }

    public ManagementID getManagementID() {
        return managementID;
    }

    public AdvertisementID getAdvertisementID() {
        return advertisementID;
    }
    public IsDone getIsDone() {
        return isDone;
    }
}
