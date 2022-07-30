package com.inmobiliariadomain.proposal.proposal;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.inmobiliariadomain.proposal.proposal.entities.Activity;
import com.inmobiliariadomain.proposal.proposal.entities.Client;
import com.inmobiliariadomain.proposal.proposal.entities.Employee;
import com.inmobiliariadomain.proposal.proposal.events.*;
import com.inmobiliariadomain.proposal.proposal.values.*;
import com.inmobiliariadomain.proposal.values.PropertyID;

import java.util.List;

public class Contract extends AggregateEvent<ContractID> {
    protected Employee employee;
    protected Client client;
    protected Activity activity;

    protected PropertyID propertyID;

    public Contract(ContractID entityId, PropertyID propertyID) {
        super(entityId);
        appendChange(new ContractCreated(propertyID)).apply();
    }

    private Contract(ContractID entityID){
        super(entityID);
        subscribe(new ContractChange(this));
    }

    public static Contract from(ContractID contractID, List<DomainEvent> domainEvents){
        Contract contract = new Contract(contractID);
        domainEvents.forEach(contract::applyEvent);
        return contract;
    }

    //events
    //Activity
    public void addActivity(ActivityType activityType){
        ActivityID activityID = new ActivityID();
        appendChange(new ActivityAdded(activityID, activityType)).apply();
    }

    public void updateActivityIsDone(ActivityID activityID, IsDone isDone){
        appendChange(new ActivityIsDoneUpdated(activityID, isDone)).apply();
    }

    public void updateActivityType(ActivityID activityID, ActivityType activityType){
        appendChange(new ActivityTypeUpdated(activityID, activityType)).apply();
    }

    //Client
    public void addClient(Name name, Age age, Contact contact){
        ClientID clientID = new ClientID();
        appendChange(new ClientAdded(clientID, name, age, contact)).apply();
    }

    public void updateClientAge(ClientID clientID, Age age){
        appendChange(new ClientAgeUpdated(clientID, age)).apply();
    }

    public void updateClientContact(ClientID clientID, Contact contact){
        appendChange(new ClientContactUpdated(clientID, contact)).apply();
    }

    public void updateClientName(ClientID clientID, Name name){
        appendChange(new ClientNameUpdated(clientID, name)).apply();
    }

    //Employee
    public void addEmployee(Commission commission, Name name){
        EmployeeID employeeID = new EmployeeID();
        appendChange(new EmployeeAdded(employeeID, commission, name)).apply();
    }

    public void updateEmployeeCommision(EmployeeID employeeID, Commission commission){
        appendChange(new EmployeeCommisionUpdated(employeeID, commission)).apply();
    }

    public void updateEmployeeName(EmployeeID employeeID, Name name){
        appendChange(new EmployeeNameUpdated(employeeID, name)).apply();
    }

}
