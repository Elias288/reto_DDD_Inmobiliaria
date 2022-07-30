package com.inmobiliariadomain.proposal.proposal.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.inmobiliariadomain.proposal.proposal.values.EmployeeID;
import com.inmobiliariadomain.proposal.proposal.values.Name;
import com.inmobiliariadomain.proposal.proposal.values.Commission;

public class EmployeeAdded extends DomainEvent {
    private final EmployeeID employeeID;
    private final Commission commission;
    private final Name name;


    public EmployeeAdded(EmployeeID employeeID, Commission commission, Name name) {
        super("com.inmobiliariadomain.proposal.Employeeadded");
        this.employeeID = employeeID;
        this.commission = commission;
        this.name = name;
    }

    public EmployeeID getEmployeeID() {
        return employeeID;
    }

    public Commission getCommission() {
        return commission;
    }

    public Name getName() {
        return name;
    }
}
