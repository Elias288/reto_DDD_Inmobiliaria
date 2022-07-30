package com.inmobiliariadomain.local.commands;

import co.com.sofka.domain.generic.Command;
import com.inmobiliariadomain.local.values.Debit;
import com.inmobiliariadomain.local.values.ManagementID;
import com.inmobiliariadomain.local.values.Name;
import com.inmobiliariadomain.local.values.Contact;

public class AddOwner extends Command {
    private final ManagementID managementID;
    private final Debit debit;
    private final Name name;
    private final Contact contact;

    public AddOwner(ManagementID managementID, Debit debit, Name name, Contact contact) {
        this.debit = debit;
        this.name = name;
        this.contact = contact;
        this.managementID = managementID;
    }

    public ManagementID getManagementID() {
        return managementID;
    }
    public Debit getDebit() {
        return debit;
    }

    public Contact getContact() {
        return contact;
    }

    public Name getName() {
        return name;
    }
}
