package com.inmobiliariadomain.promotionsection;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.inmobiliariadomain.local.values.IsDone;
import com.inmobiliariadomain.promotionsection.values.*;
import com.inmobiliariadomain.promotionsection.entities.*;
import com.inmobiliariadomain.promotionsection.events.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public class Pairing extends AggregateEvent<PairingID> {
    protected Set<Interested> interestedSet;
    protected Establishment establishment;
    protected Set<Offer> offerSet;

    public Pairing(PairingID pairingID, Establishment owner) {
        super(pairingID);
        appendChange(new PairingCreated(owner)).apply();
    }

    public Pairing(PairingID pairingID) {
        super(pairingID);
        subscribe(new PairingChange(this));
    }

    public static Pairing from(PairingID pairingID, List<DomainEvent> domainEvents){
        Pairing pairing = new Pairing(pairingID);
        domainEvents.forEach(pairing::applyEvent);
        return pairing;
    }

    //EVENTS
    //OFFER
    public void addOffer(OfferDate offerDate){
        OfferID offerID = new OfferID();
        appendChange(new OfferAdded(offerID, offerDate)).apply();
    }

    public void updateOfferDate(OfferID offerID, OfferDate address){
        appendChange(new OfferDateUpdated(offerID, address)).apply();
    }

    public void updateOfferIsFinished(OfferID offerID, IsFinished isFinished){
        appendChange(new OfferIsFinishedUpdated(offerID, isFinished)).apply();
    }

    public void removeOffer(OfferID propertyID){
        appendChange(new OfferRemoved(propertyID)).apply();
    }

    //Establishment
    public void addEstablishment(Address address){
        EstablishmentID establishmentID = new EstablishmentID();
        appendChange(new EstablishmentAdded(establishmentID, address)).apply();
    }

    public void updateEstablishmentAddres(EstablishmentID establishmentID, Address address){
        appendChange(new EstablishmentAddresUpdated(establishmentID, address)).apply();
    }

    //INTERESTED
    public void addInterested(Name name, QueryType queryType, Contact contact){
        InterestedID interestedID = new InterestedID();
        appendChange(new InterestedAdded(interestedID, name, queryType, contact)).apply();
    }

    public void updateInterestedName(InterestedID interestedID, Name name){
        appendChange(new InterestedNameUpdated(interestedID, name)).apply();
    }

    public void updateInterestedQueryType(InterestedID advertisementID, QueryType isDone){
        appendChange(new InterestedQueryTypeUpdated(advertisementID, isDone)).apply();
    }

    public void updateInterestedContact(InterestedID interestedID, Contact contact){
        appendChange(new InterestedContactUpdated(interestedID, contact)).apply();
    }

    public void removeInterested(InterestedID interestedID){
        appendChange(new InterestedRemoved(interestedID)).apply();
    }


    public Optional<Interested> findPropertyById(InterestedID interestedID){
        return this.interestedSet.stream().filter(interested -> interested.identity().equals(interestedID)).findFirst();
    }

    public Optional<Offer> findAdvertisementById(OfferID offerID){
        return this.offerSet.stream().filter(advertisement -> advertisement.identity().equals(offerID)).findFirst();
    }

    public Establishment getEstablishment() {
        return establishment;
    }
}
