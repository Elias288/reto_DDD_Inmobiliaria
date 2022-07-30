package com.inmobiliariadomain.proposal.commands;

import co.com.sofka.domain.generic.Command;
import com.inmobiliariadomain.proposal.values.AdvertisementID;
import com.inmobiliariadomain.proposal.values.ManagementID;

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
