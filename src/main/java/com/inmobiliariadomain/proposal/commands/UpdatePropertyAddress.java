package com.inmobiliariadomain.proposal.commands;

import co.com.sofka.domain.generic.Command;
import com.inmobiliariadomain.proposal.values.Address;
import com.inmobiliariadomain.proposal.values.ManagementID;

public class UpdatePropertyAddress extends Command {
    private final ManagementID managementID;
    private final Address address;

    public UpdatePropertyAddress(ManagementID managementID, Address address) {
        this.managementID = managementID;
        this.address = address;
    }

    public ManagementID getManagementID() {
        return managementID;
    }

    public Address getAddress() {
        return address;
    }
}
