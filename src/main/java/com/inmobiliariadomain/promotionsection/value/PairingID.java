package com.inmobiliariadomain.promotionsection.value;

import co.com.sofka.domain.generic.Identity;

public class PairingID extends Identity {
    public PairingID(){}

    public PairingID(String id){
        super(id);
    }

    public static PairingID of(String id){
        return new PairingID(id);
    }
}
