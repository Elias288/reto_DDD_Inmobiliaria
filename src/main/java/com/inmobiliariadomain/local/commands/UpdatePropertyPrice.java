package com.inmobiliariadomain.local.commands;

import co.com.sofka.domain.generic.Command;
import com.inmobiliariadomain.local.values.ManagementID;
import com.inmobiliariadomain.local.values.Price;
import com.inmobiliariadomain.local.values.PropertyID;

public class UpdatePropertyPrice extends Command {
    private final ManagementID managementID;
    private final PropertyID propertyID;
    private final Price price;

    public UpdatePropertyPrice(PropertyID propertyID, ManagementID managementID, Price price) {
        this.managementID = managementID;
        this.price = price;
        this.propertyID = propertyID;
    }

    public ManagementID getManagementID() {
        return managementID;
    }

    public PropertyID getPropertyID() {
        return propertyID;
    }
    public Price getPrice() {
        return price;
    }
}
