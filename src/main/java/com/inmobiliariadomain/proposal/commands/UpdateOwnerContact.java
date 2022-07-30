package com.inmobiliariadomain.proposal.commands;

import co.com.sofka.domain.generic.Command;
import com.inmobiliariadomain.proposal.values.Contact;
import com.inmobiliariadomain.proposal.values.ManagementID;

public class UpdateOwnerContact extends Command {
    private final ManagementID managementID;
    private final Contact contact;

    public UpdateOwnerContact(ManagementID managementID, Contact contact) {
        this.managementID = managementID;
        this.contact = contact;
    }

    public ManagementID getManagementID() {
        return managementID;
    }

    public Contact getContact() {
        return contact;
    }
}
