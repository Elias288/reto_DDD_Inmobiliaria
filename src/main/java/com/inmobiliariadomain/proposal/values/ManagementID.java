package com.inmobiliariadomain.proposal.values;

import co.com.sofka.domain.generic.Identity;

public class ManagementID extends Identity {
    public ManagementID(){}

    public ManagementID(String uuid) {
        super(uuid);
    }

    public static ManagementID of(String id){
        return new ManagementID(id);
    }
}
