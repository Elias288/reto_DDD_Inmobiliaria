package com.inmobiliariadomain.local.commands;

import co.com.sofka.domain.generic.Command;
import com.inmobiliariadomain.local.values.AdvertisementID;
import com.inmobiliariadomain.local.values.ManagementID;

public class RemoveAdvertisement extends Command {
    private final ManagementID managementID;
    private final AdvertisementID advertisementID;

    public RemoveAdvertisement(ManagementID managementID, AdvertisementID advertisementID) {
        this.managementID = managementID;
        this.advertisementID = advertisementID;
    }

    public ManagementID getManagementID() {
        return managementID;
    }

    public AdvertisementID getAdvertisementID() {
        return advertisementID;
    }
}
