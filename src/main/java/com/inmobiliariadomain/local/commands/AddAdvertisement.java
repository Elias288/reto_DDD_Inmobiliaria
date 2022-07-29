package com.inmobiliariadomain.local.commands;

import co.com.sofka.domain.generic.Command;
import com.inmobiliariadomain.local.values.ExpirationDate;
import com.inmobiliariadomain.local.values.IsDone;

public class AddAdvertisement extends Command {
    private final ExpirationDate expirationDate;
    private final IsDone isDone;

    public AddAdvertisement(ExpirationDate expirationDate, IsDone isDone) {
        this.expirationDate = expirationDate;
        this.isDone = isDone;
    }

    public ExpirationDate getExpirationDate() {
        return expirationDate;
    }

    public IsDone getIsDone() {
        return isDone;
    }
}