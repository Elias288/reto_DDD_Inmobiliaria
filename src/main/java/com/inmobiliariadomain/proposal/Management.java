package com.inmobiliariadomain.proposal;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.inmobiliariadomain.proposal.entities.*;
import com.inmobiliariadomain.proposal.events.*;
import com.inmobiliariadomain.proposal.values.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public class Management extends AggregateEvent<ManagementID> {
    protected Set<Property> propetySet;
    protected Owner owner;
    protected Set<Advertisement> advertisementSet;

    public Management(ManagementID entityId, Owner owner) {
        super(entityId);
        appendChange(new ManagementCreated(owner)).apply();
    }

    public Management(ManagementID entityId) {
        super(entityId);
        subscribe(new ManagementChange(this));
    }

    public static Management from(ManagementID managementID, List<DomainEvent> domainEvents){
        Management management = new Management(managementID);
        domainEvents.forEach(management::applyEvent);
        return management;
    }

    //EVENTS
    //PROPERTY
    public void addProperty(Price price, Area area, Address address, PropertyType propertyType){
        PropertyID propertyID = new PropertyID();
        appendChange(new PropertyAdded(propertyID, price, address, propertyType, area)).apply();
    }

    public void updatePropertyAddress(PropertyID propertyID, Address address){
        appendChange(new PropertyAddressUpdated(propertyID, address)).apply();
    }

    public void updatePropertyArea(PropertyID propertyID, Area area){
        appendChange(new PropertyAreaUpdated(propertyID, area)).apply();
    }

    public void updatePropertyPrice(PropertyID propertyID, Price price){
        appendChange(new PropertyPriceUpdated(propertyID, price)).apply();
    }

    public void removeProperty(PropertyID propertyID){
        appendChange(new PropertyRemoved(propertyID)).apply();
    }

    //OWNER
    public void addOwner(Name name, Debit debit, Contact contact){
        OwnerID ownerID = new OwnerID();
        appendChange(new OwnerAdded(ownerID, name, debit, contact)).apply();
    }

    public void updateOwnerContact(OwnerID ownerID, Contact contact){
        appendChange(new OwnerContactUpdated(ownerID, contact)).apply();
    }

    public void updateOwnerDebit(OwnerID ownerID, Debit debit){
        appendChange(new OwnerDebitUpdated(ownerID, debit)).apply();
    }

    public void updateOwnerName(OwnerID ownerID, Name name){
        appendChange(new OwnerNameUpdated(ownerID, name)).apply();
    }

    //ADVERTISEMENT
    public void addAdvertisement(ExpirationDate expirationDate){
        AdvertisementID advertisementID = new AdvertisementID();
        appendChange(new AdvertisementAdded(advertisementID, expirationDate)).apply();
    }

    public void updateAdvertisementExpirationDate(AdvertisementID advertisementID, ExpirationDate expirationDate){
        appendChange(new AdvertisementExpirationDateUpdated(advertisementID, expirationDate)).apply();
    }

    public void updateAdvertisementIsDone(AdvertisementID advertisementID, IsDone isDone){
        appendChange(new AdvertisementIsDoneUpdated(advertisementID, isDone)).apply();
    }

    public void removeAdvertisement(AdvertisementID advertisementID){
        appendChange(new AdvertisementRemoved(advertisementID)).apply();
    }

    public Optional<Property> findPropertyById(PropertyID propertyID){
        return this.propetySet.stream().filter(property -> property.identity().equals(propertyID)).findFirst();
    }

    public Optional<Advertisement> findAdvertisementById(AdvertisementID advertisementID){
        return this.advertisementSet.stream().filter(advertisement -> advertisement.identity().equals(advertisementID)).findFirst();
    }

    public Owner getOwner() {
        return owner;
    }
}
