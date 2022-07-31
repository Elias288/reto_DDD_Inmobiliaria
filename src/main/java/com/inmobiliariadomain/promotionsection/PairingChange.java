package com.inmobiliariadomain.promotionsection;

import co.com.sofka.domain.generic.EventChange;
import com.inmobiliariadomain.promotionsection.entities.Offer;
import com.inmobiliariadomain.promotionsection.entities.Establishment;
import com.inmobiliariadomain.promotionsection.entities.Interested;
import com.inmobiliariadomain.promotionsection.events.*;

import java.util.HashSet;

public class PairingChange extends EventChange {
    public PairingChange(Pairing pairing){

        apply((PairingCreated event) -> {
            pairing.interestedSet = new HashSet<>();
            pairing.offerSet = new HashSet<>();
        });

        //INTERESTED
        apply((InterestedAdded event) -> {
            Interested interested = new Interested(event.getInterestedID(), event.getName(), event.getQueryType(), event.getContact());
            pairing.interestedSet.add(interested);
        });

        apply((InterestedContactUpdated event) -> {
            Interested interested = pairing.findPropertyById(event.getInterestedID()).orElseThrow();
            interested.updateContact(event.getContact());
        });

        apply((InterestedNameUpdated event) -> {
            Interested interested = pairing.findPropertyById(event.getInterestedID()).orElseThrow();
            interested.updateName(event.getName());
        });

        apply((InterestedQueryTypeUpdated event) -> {
            Interested interested = pairing.findPropertyById(event.getInterestedID()).orElseThrow();
            interested.updateQueryType(event.getQueryType());
        });

        apply((InterestedRemoved event) -> {
            pairing.interestedSet.removeIf((interested -> interested.identity().equals(event.getInterestedID())));
        });

        //ESTABLISHMENT
        apply((EstablishmentAdded event) -> {
            pairing.establishment = new Establishment(event.getEstablishmentID(), event.getAddress());
        });

        apply((EstablishmentAddresUpdated event) -> {
            pairing.establishment.updateAddress(event.getAddress());
        });

        //Advertisement
        apply((OfferAdded event) -> {
            Offer advertisement = new Offer(event.getOfferID(), event.getOfferDate());
            pairing.offerSet.add(advertisement);
        });

        apply((OfferDateUpdated event) -> {
            Offer advertisement = pairing.findAdvertisementById(event.getOfferID()).orElseThrow();
            advertisement.updateOfferDate(event.getOfferDate());
        });

        apply((OfferIsFinishedUpdated event) -> {
            Offer advertisement = pairing.findAdvertisementById(event.getOfferID()).orElseThrow();
            advertisement.toggleIsFinished(event.getIsFinished());
        });

        apply((OfferRemoved event) -> {
            pairing.offerSet.removeIf((advertisement -> advertisement.identity().equals(event.getOfferID())));
        });
    }
}
