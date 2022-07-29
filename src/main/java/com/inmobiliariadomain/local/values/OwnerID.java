package com.inmobiliariadomain.local.values;

import co.com.sofka.domain.generic.Identity;

public class OwnerID extends Identity {
    public OwnerID(){};

    public OwnerID(String uuid) {
        super(uuid);
    }

    public static OwnerID of(String id){
        return new OwnerID(id);
    }
}
