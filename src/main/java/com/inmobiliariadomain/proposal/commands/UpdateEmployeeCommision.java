package com.inmobiliariadomain.proposal.commands;

import co.com.sofka.domain.generic.Command;
import com.inmobiliariadomain.proposal.values.Commission;
import com.inmobiliariadomain.proposal.values.ContractID;
import com.inmobiliariadomain.proposal.values.EmployeeID;
import com.inmobiliariadomain.proposal.values.Name;

public class UpdateEmployeeCommision extends Command {
    private final ContractID contractID;
    private final EmployeeID employeeID;
    private final Commission commission;


    public UpdateEmployeeCommision(ContractID contractID, Commission commission, EmployeeID employeeID) {
        this.contractID = contractID;
        this.commission = commission;
        this.employeeID = employeeID;
    }

    public ContractID getContractID() {
        return contractID;
    }

    public EmployeeID getEmployeeID() {
        return employeeID;
    }

    public Commission getCommission() {
        return commission;
    }
}
