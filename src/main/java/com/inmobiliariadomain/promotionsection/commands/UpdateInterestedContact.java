package com.inmobiliariadomain.promotionsection.commands;

import co.com.sofka.domain.generic.Command;
import com.inmobiliariadomain.promotionsection.value.Contact;
import com.inmobiliariadomain.promotionsection.value.PairingID;

public class UpdateInterestedContact extends Command {
    private final PairingID pairingID;
    private final Contact contact;

    public UpdateInterestedContact(PairingID pairingID, Contact contact) {
        this.pairingID = pairingID;
        this.contact = contact;
    }

    public PairingID getPairingID() {
        return pairingID;
    }

    public Contact getContact() {
        return contact;
    }
}
