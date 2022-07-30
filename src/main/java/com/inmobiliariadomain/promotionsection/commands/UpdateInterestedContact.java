package com.inmobiliariadomain.promotionsection.commands;

import co.com.sofka.domain.generic.Command;
import com.inmobiliariadomain.promotionsection.values.Contact;
import com.inmobiliariadomain.promotionsection.values.InterestedID;
import com.inmobiliariadomain.promotionsection.values.PairingID;

public class UpdateInterestedContact extends Command {
    private final PairingID pairingID;
    private final InterestedID interestedID;
    private final Contact contact;

    public UpdateInterestedContact(PairingID pairingID,InterestedID interestedID, Contact contact) {
        this.pairingID = pairingID;
        this.contact = contact;
        this.interestedID = interestedID;
    }

    public PairingID getPairingID() {
        return pairingID;
    }

    public InterestedID getInterestedID() {
        return interestedID;
    }

    public Contact getContact() {
        return contact;
    }
}
