package com.inmobiliariadomain.proposal;

import co.com.sofka.domain.generic.EventChange;
import com.inmobiliariadomain.proposal.entities.Activity;
import com.inmobiliariadomain.proposal.entities.Client;
import com.inmobiliariadomain.proposal.entities.Employee;
import com.inmobiliariadomain.proposal.events.*;

public class ContractChange extends EventChange {

    public ContractChange(Contract contract){

        apply((ContractCreated event) -> {
            contract.propertyID = event.getPropertyID();
        });

        apply((ActivityAdded event) -> {
            contract.activity = new Activity(event.getActivityID(), event.getActivityType());
        });

        apply((ClientAdded event) -> {
            contract.client = new Client(event.getClientID(), event.getAge(), event.getContact(), event.getName());
        });

        apply((EmployeeAdded event) -> {
            contract.employee = new Employee(event.getEmployeeID(), event.getCommission(), event.getName());
        });

        apply((ActivityTypeUpdated event) -> {
            contract.activity.updateActivityType(event.getActivityType());
        });

        apply((ActivityIsDoneUpdated event) -> {
            contract.activity.toggleIsDone(event.getIsDone());
        });

        apply((ClientAgeUpdated event) -> {
            contract.client.updateAge(event.getAge());
        });

        apply((ClientContactUpdated event) -> {
            contract.client.updateContact(event.getContact());
        });

        apply((ClientNameUpdated event) -> {
            contract.client.updateName(event.getName());
        });

        apply((EmployeeCommisionUpdated event) -> {
            contract.employee.updateCommission(event.getCommission());
        });

        apply((EmployeeNameUpdated event) -> {
            contract.employee.updateName(event.getName());
        });
    }
}
