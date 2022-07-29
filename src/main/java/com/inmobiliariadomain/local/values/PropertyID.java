package com.inmobiliariadomain.local.values;

import co.com.sofka.domain.generic.Identity;

public class PropertyID extends Identity {
    public PropertyID(){};

    public PropertyID(String uuid) {
        super(uuid);
    }

    public static PropertyID of(String id){
        return new PropertyID(id);
    }
}
