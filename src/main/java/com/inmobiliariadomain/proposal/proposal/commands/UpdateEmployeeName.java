package com.inmobiliariadomain.proposal.proposal.commands;

import co.com.sofka.domain.generic.Command;
import com.inmobiliariadomain.proposal.proposal.values.ContractID;
import com.inmobiliariadomain.proposal.proposal.values.EmployeeID;
import com.inmobiliariadomain.proposal.proposal.values.Name;

public class UpdateEmployeeName extends Command {
    private final ContractID contractID;
    private final EmployeeID employeeID;
    private final Name name;

    public UpdateEmployeeName(ContractID contractID, Name name, EmployeeID employeeID) {
        this.contractID = contractID;
        this.name = name;
        this.employeeID = employeeID;
    }

    public ContractID getContractID() {
        return contractID;
    }

    public EmployeeID getEmployeeID() {
        return employeeID;
    }

    public Name getName() {
        return name;
    }
}
