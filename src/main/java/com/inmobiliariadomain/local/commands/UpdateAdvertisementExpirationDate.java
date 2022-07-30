package com.inmobiliariadomain.local.commands;

import co.com.sofka.domain.generic.Command;
import com.inmobiliariadomain.local.values.AdvertisementID;
import com.inmobiliariadomain.local.values.ExpirationDate;
import com.inmobiliariadomain.local.values.ManagementID;

public class UpdateAdvertisementExpirationDate extends Command {
    private final ManagementID managementID;
    private final AdvertisementID advertisementID;
    private final ExpirationDate expirationDate;

    public UpdateAdvertisementExpirationDate(AdvertisementID advertisementID, ManagementID managementID, ExpirationDate expirationDate) {
        this.managementID = managementID;
        this.expirationDate = expirationDate;
        this.advertisementID = advertisementID;
    }

    public ManagementID getManagementID() {
        return managementID;
    }

    public AdvertisementID getAdvertisementID() {
        return advertisementID;
    }

    public ExpirationDate getExpirationDate() {
        return expirationDate;
    }
}
