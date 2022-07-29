package com.inmobiliariadomain.promotionsection.value;

import co.com.sofka.domain.generic.Identity;

public class EstablishmentID extends Identity {
    public EstablishmentID(){}

    public EstablishmentID(String uuid) {
        super(uuid);
    }

    public static EstablishmentID of(String id){
        return new EstablishmentID(id);
    }
}
