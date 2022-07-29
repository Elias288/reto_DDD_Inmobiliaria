package com.inmobiliariadomain.proposal.commands;

import co.com.sofka.domain.generic.Command;
import com.inmobiliariadomain.proposal.values.ContractID;
import com.inmobiliariadomain.proposal.values.EmployeeID;

public class RemoveEmployee extends Command {
    private final ContractID contractID;
    private final EmployeeID employeeID;

    public RemoveEmployee(ContractID contractID, EmployeeID employeeID) {
        this.contractID = contractID;
        this.employeeID = employeeID;
    }

    public ContractID getContractID() {
        return contractID;
    }

    public EmployeeID getEmployeeID() {
        return employeeID;
    }
}
