package com.inmobiliariadomain.local.commands;

import co.com.sofka.domain.generic.Command;
import com.inmobiliariadomain.local.values.Contact;
import com.inmobiliariadomain.local.values.ManagementID;
import com.inmobiliariadomain.local.values.OwnerID;

public class UpdateOwnerContact extends Command {
    private final ManagementID managementID;
    private final OwnerID ownerID;
    private final Contact contact;

    public UpdateOwnerContact(OwnerID ownerID, ManagementID managementID, Contact contact) {
        this.managementID = managementID;
        this.contact = contact;
        this.ownerID = ownerID;
    }

    public ManagementID getManagementID() {
        return managementID;
    }

    public OwnerID getOwnerID() {
        return ownerID;
    }

    public Contact getContact() {
        return contact;
    }
}
