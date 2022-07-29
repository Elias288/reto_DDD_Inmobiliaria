package com.inmobiliariadomain.promotionsection.entities;

import co.com.sofka.domain.generic.Entity;
import com.inmobiliariadomain.promotionsection.value.Address;
import com.inmobiliariadomain.promotionsection.value.EstablishmentID;

import java.util.Objects;

public class Establishment extends Entity<EstablishmentID> {
    private Address address;

    public Establishment(EstablishmentID entityId, Address address) {
        super(entityId);
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    public void updateAddress(Address address) {
        this.address = Objects.requireNonNull(address);
    }
}
