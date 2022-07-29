package com.inmobiliariadomain.local.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.inmobiliariadomain.local.values.AdvertisementID;
import com.inmobiliariadomain.local.values.IsDone;

public class AdvertisementIsDoneUpdated extends DomainEvent {
    private final AdvertisementID advertisementID;
    private final IsDone isDone;

    public AdvertisementIsDoneUpdated(AdvertisementID advertisementID, IsDone isDone) {
        super("com.inmobiliariadomain.local.advertisementIsdoneUpdate");
        this.advertisementID = advertisementID;
        this.isDone = isDone;
    }

    public AdvertisementID getAdvertisementID() {
        return advertisementID;
    }

    public IsDone getIsDone() {
        return isDone;
    }
}
