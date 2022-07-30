package com.inmobiliariadomain.proposal.commands;

import co.com.sofka.domain.generic.Command;
import com.inmobiliariadomain.local.values.PropertyID;
import com.inmobiliariadomain.proposal.values.ContractID;

public class CreateContract extends Command {
    private final ContractID contractID;
    private final PropertyID propertyID;

    public CreateContract(ContractID contractID, PropertyID propertyID) {
        this.contractID = contractID;
        this.propertyID = propertyID;
    }

    public ContractID getContractID() {
        return contractID;
    }

    public PropertyID getPropertyID() {
        return propertyID;
    }
}
