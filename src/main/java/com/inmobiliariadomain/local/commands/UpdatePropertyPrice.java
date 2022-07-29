package com.inmobiliariadomain.local.commands;

import co.com.sofka.domain.generic.Command;
import com.inmobiliariadomain.local.values.ManagementID;
import com.inmobiliariadomain.local.values.Price;

public class UpdatePropertyPrice extends Command {
    private final ManagementID managementID;
    private final Price price;

    public UpdatePropertyPrice(ManagementID managementID, Price price) {
        this.managementID = managementID;
        this.price = price;
    }

    public ManagementID getManagementID() {
        return managementID;
    }

    public Price getPrice() {
        return price;
    }
}
