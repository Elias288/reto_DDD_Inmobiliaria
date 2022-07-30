package com.inmobiliariadomain.proposal.commands;

import co.com.sofka.domain.generic.Command;
import com.inmobiliariadomain.proposal.values.ManagementID;
import com.inmobiliariadomain.proposal.values.Price;

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
