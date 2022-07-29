package com.inmobiliariadomain.proposal.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.inmobiliariadomain.proposal.values.Commission;
import com.inmobiliariadomain.proposal.values.EmployeeID;

public class EmployeeCommisionUpdated extends DomainEvent {
    private final EmployeeID employeeID;
    private final Commission commission;

    public EmployeeCommisionUpdated(EmployeeID employeeID, Commission commission) {
        super("com.inmobiliariadomain.proposal.employeecommisionupdated");
        this.employeeID = employeeID;
        this.commission = commission;
    }

    public EmployeeID getEmployeeID() {
        return employeeID;
    }

    public Commission getCommission() {
        return commission;
    }
}
