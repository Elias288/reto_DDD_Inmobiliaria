package com.inmobiliariadomain.proposal;

import co.com.sofka.domain.generic.EventChange;
import com.inmobiliariadomain.proposal.entities.Advertisement;
import com.inmobiliariadomain.proposal.entities.Owner;
import com.inmobiliariadomain.proposal.entities.Property;
import com.inmobiliariadomain.proposal.events.*;

import java.util.HashSet;

public class ManagementChange extends EventChange {
    public ManagementChange(Management management){

        apply((ManagementCreated event) -> {
            management.owner = event.getOwner();
            management.propetySet = new HashSet<>();
            management.advertisementSet = new HashSet<>();
        });

        //PROPERTY
        apply((PropertyAdded event) -> {
            Property property = new Property(event.getPropertyID(), event.getPrice(), event.getArea(), event.getAddress());
            management.propetySet.add(property);
        });

        apply((PropertyAddressUpdated event) -> {
            Property property = management.findPropertyById(event.getPropertyID()).orElseThrow();
            property.updateAddress(event.getAddress());
        });

        apply((PropertyAreaUpdated event) -> {
            Property property = management.findPropertyById(event.getPropertyID()).orElseThrow();
            property.updateArea(event.getArea());
        });

        apply((PropertyTypeUpdated event) -> {
            Property property = management.findPropertyById(event.getPropertyID()).orElseThrow();
            property.updatePropertyType(event.getPropertyType());
        });

        apply((PropertyPriceUpdated event) -> {
            Property property = management.findPropertyById(event.getPropertyID()).orElseThrow();
            property.updatePrice(event.getPrice());
        });

        apply((PropertyRemoved event) -> {
            management.propetySet.removeIf((property -> property.identity().equals(event.getPropertyID())));
        });

        //OWNER
        apply((OwnerAdded event) -> {
            management.owner = new Owner(event.getOwnerID(), event.getDebit(), event.getName(), event.getContact());
        });

        apply((OwnerContactUpdated event) -> {
            management.owner.updateContact(event.getContact());
        });

        apply((OwnerDebitUpdated event) -> {
            management.owner.updateDebit(event.getDebit());
        });

        apply((OwnerNameUpdated event) -> {
            management.owner.updateName(event.getName());
        });

        //Advertisement
        apply((AdvertisementAdded event) -> {
            Advertisement advertisement = new Advertisement(event.getAdvertisementID(), event.getExpirationDate());
            management.advertisementSet.add(advertisement);
        });

        apply((AdvertisementExpirationDateUpdated event) -> {
            Advertisement advertisement = management.findAdvertisementById(event.getAdvertisementID()).orElseThrow();
            advertisement.updateExpirationDate(event.getExpirationDate());
        });

        apply((AdvertisementIsDoneUpdated event) -> {
            Advertisement advertisement = management.findAdvertisementById(event.getAdvertisementID()).orElseThrow();
            advertisement.toggleIsDone(event.getIsDone());
        });

        apply((AdvertisementRemoved event) -> {
            management.advertisementSet.removeIf((advertisement -> advertisement.identity().equals(event.getAdvertisementID())));
        });
    }
}
