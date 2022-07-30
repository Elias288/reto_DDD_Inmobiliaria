package com.inmobiliariadomain.proposal.proposal.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.inmobiliariadomain.proposal.proposal.values.EmployeeID;
import com.inmobiliariadomain.proposal.proposal.values.Commission;

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
