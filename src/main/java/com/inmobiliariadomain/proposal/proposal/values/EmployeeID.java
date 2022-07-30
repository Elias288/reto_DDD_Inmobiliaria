package com.inmobiliariadomain.proposal.proposal.values;

import co.com.sofka.domain.generic.Identity;

public class EmployeeID extends Identity {
    public EmployeeID(){}

    public EmployeeID(String id){
        super(id);
    }

    public static EmployeeID of(String id){
        return new EmployeeID(id);
    }
}
