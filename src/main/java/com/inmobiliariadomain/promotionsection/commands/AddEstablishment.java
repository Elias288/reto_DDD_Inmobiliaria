package com.inmobiliariadomain.promotionsection.commands;

import co.com.sofka.domain.generic.Command;
import com.inmobiliariadomain.promotionsection.value.Address;

public class AddEstablishment extends Command {
    private final Address address;

    public AddEstablishment(Address address) {
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }
}
