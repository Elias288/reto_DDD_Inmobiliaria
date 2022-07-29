package com.inmobiliariadomain.promotionsection.value;

import co.com.sofka.domain.generic.Identity;

public class OfferID extends Identity {
    public OfferID() {}

    public OfferID(String uuid) {
        super(uuid);
    }

    public static OfferID of(String id){
        return new OfferID(id);
    }
}
