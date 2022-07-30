package com.inmobiliariadomain.proposal.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.inmobiliariadomain.proposal.values.Address;
import com.inmobiliariadomain.proposal.values.PropertyID;

public class PropertyAddressUpdated extends DomainEvent {
    private final PropertyID propertyID;
    private final Address address;

    public PropertyAddressUpdated(PropertyID propertyID, Address address) {
        super("com.inmobiliariadomain.local.propertyaddressupdated");
        this.propertyID = propertyID;
        this.address = address;
    }

    public PropertyID getPropertyID() {
        return propertyID;
    }

    public Address getAddress() {
        return address;
    }
}
