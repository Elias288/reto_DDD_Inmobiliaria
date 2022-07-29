package com.inmobiliariadomain.promotionsection.value;

import co.com.sofka.domain.generic.Identity;

public class InterestedID extends Identity {
    public InterestedID(){}

    public InterestedID(String uuid) {
        super(uuid);
    }

    public static InterestedID of(String id){
        return new InterestedID(id);
    }
}
