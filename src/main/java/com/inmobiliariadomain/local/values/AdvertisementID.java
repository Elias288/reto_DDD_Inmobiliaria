package com.inmobiliariadomain.local.values;

import co.com.sofka.domain.generic.Identity;

public class AdvertisementID extends Identity {
    public AdvertisementID(){};

    public AdvertisementID(String uuid) {
        super(uuid);
    }

    public static AdvertisementID of(String id){
        return new AdvertisementID(id);
    }
}
