package com.inmobiliariadomain.proposal.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.inmobiliariadomain.proposal.values.EmployeeID;
import com.inmobiliariadomain.proposal.values.Name;

public class EmployeeNameUpdated extends DomainEvent {
    private final EmployeeID employeeID;
    private final Name name;


    public EmployeeNameUpdated(EmployeeID employeeID, Name name) {
        super("com.inmobiliariadomain.proposal.employeenameupdated");
        this.employeeID = employeeID;
        this.name = name;
    }

    public EmployeeID getEmployeeID() {
        return employeeID;
    }

    public Name getName() {
        return name;
    }
}
