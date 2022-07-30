package com.inmobiliariadomain.proposal.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.inmobiliariadomain.proposal.values.Price;
import com.inmobiliariadomain.proposal.values.PropertyID;

public class PropertyPriceUpdated extends DomainEvent {
    private final PropertyID propertyID;
    private final Price price;

    public PropertyPriceUpdated(PropertyID propertyID, Price price) {
        super("com.inmobiliariadomain.local.propertypriceupdated");
        this.propertyID = propertyID;
        this.price = price;
    }

    public PropertyID getPropertyID() {
        return propertyID;
    }

    public Price getPrice() {
        return price;
    }
}
