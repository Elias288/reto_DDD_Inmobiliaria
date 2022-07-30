package com.inmobiliariadomain.proposal.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.inmobiliariadomain.proposal.values.Debit;
import com.inmobiliariadomain.proposal.values.OwnerID;

public class OwnerDebitUpdated extends DomainEvent {
    private final OwnerID ownerID;
    private final Debit debit;

    public OwnerDebitUpdated(OwnerID ownerID, Debit debit) {
        super("com.inmobiliariadomain.local.ownerdebitupdated");
        this.ownerID = ownerID;
        this.debit = debit;
    }

    public OwnerID getOwnerID() {
        return ownerID;
    }

    public Debit getDebit() {
        return debit;
    }
}
