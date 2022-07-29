package com.inmobiliariadomain.local.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.inmobiliariadomain.local.values.AdvertisementID;
import com.inmobiliariadomain.local.values.ExpirationDate;

public class AdvertisementExpirationDateUpdated extends DomainEvent {
    private final AdvertisementID advertisementID;
    private final ExpirationDate expirationDate;

    public AdvertisementExpirationDateUpdated(AdvertisementID advertisementID, ExpirationDate expirationDate) {
        super("com.inmobiliariadomain.local.advertisementexpirationdateupdated");
        this.advertisementID = advertisementID;
        this.expirationDate = expirationDate;
    }

    public AdvertisementID getAdvertisementID() {
        return advertisementID;
    }

    public ExpirationDate getExpirationDate() {
        return expirationDate;
    }
}
