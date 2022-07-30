package com.inmobiliariadomain.proposal.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.inmobiliariadomain.proposal.values.AdvertisementID;
import com.inmobiliariadomain.proposal.values.ExpirationDate;

public class AdvertisementAdded extends DomainEvent {
    private final AdvertisementID advertisementID;
    private final ExpirationDate expirationDate;

    public AdvertisementAdded(AdvertisementID advertisementID, ExpirationDate expirationDate) {
        super("com.inmobiliariadomain.local.advertisementadded");
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
