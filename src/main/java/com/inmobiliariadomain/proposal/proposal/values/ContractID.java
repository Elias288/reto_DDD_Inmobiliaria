package com.inmobiliariadomain.proposal.proposal.values;

import co.com.sofka.domain.generic.Identity;

public class ContractID extends Identity {
    public ContractID(){}

    public ContractID(String uuid) {
        super(uuid);
    }

    public static ContractID of(String id){
        return new ContractID(id);
    }
}
