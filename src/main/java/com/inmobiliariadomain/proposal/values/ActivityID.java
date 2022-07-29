package com.inmobiliariadomain.proposal.values;

import co.com.sofka.domain.generic.Identity;

public class ActivityID extends Identity {
    public ActivityID() {}

    public ActivityID(String uuid) {
        super(uuid);
    }

    public static ActivityID of(String id){
        return new ActivityID(id);
    }
}
