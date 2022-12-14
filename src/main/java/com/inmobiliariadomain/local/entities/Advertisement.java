package com.inmobiliariadomain.local.entities;

import co.com.sofka.domain.generic.Entity;
import com.inmobiliariadomain.local.values.AdvertisementID;
import com.inmobiliariadomain.local.values.ExpirationDate;
import com.inmobiliariadomain.local.values.IsDone;

import java.util.Objects;

public class Advertisement extends Entity<AdvertisementID> {

    private ExpirationDate expirationDate;
    private IsDone isDone;

    public Advertisement(AdvertisementID entityId, ExpirationDate expirationDate) {
        super(entityId);
        this.expirationDate = expirationDate;
        this.isDone = new IsDone(false);
    }

    public ExpirationDate expirationDate() {
        return expirationDate;
    }

    public void updateExpirationDate(ExpirationDate expirationDate) {
        this.expirationDate = Objects.requireNonNull(expirationDate);
    }

    public IsDone isDone() {
        return isDone;
    }

    public void toggleIsDone(IsDone isDone) {
        this.isDone = Objects.requireNonNull(isDone);
    }
}
