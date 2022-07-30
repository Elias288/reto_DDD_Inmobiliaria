package com.inmobiliariadomain.proposal.proposal.entities;

import co.com.sofka.domain.generic.Entity;
import com.inmobiliariadomain.proposal.proposal.values.Commission;
import com.inmobiliariadomain.proposal.proposal.values.EmployeeID;
import com.inmobiliariadomain.proposal.proposal.values.Name;

import java.util.Objects;

public class Employee extends Entity<EmployeeID> {
    private Commission commission;
    private Name name;

    public Employee(EmployeeID entityId, Commission commission, Name name) {
        super(entityId);
        this.commission = commission;
        this.name = name;
    }

    public Commission commission() {
        return commission;
    }

    public void updateCommission(Commission commission) {
        this.commission = Objects.requireNonNull(commission);
    }

    public Name name() {
        return name;
    }

    public void updateName(Name name) {
        this.name = Objects.requireNonNull(name);
    }
}
