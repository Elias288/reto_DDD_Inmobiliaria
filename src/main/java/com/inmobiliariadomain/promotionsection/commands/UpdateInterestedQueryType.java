package com.inmobiliariadomain.promotionsection.commands;

import co.com.sofka.domain.generic.Command;
import com.inmobiliariadomain.promotionsection.values.PairingID;
import com.inmobiliariadomain.promotionsection.values.QueryType;

public class UpdateInterestedQueryType extends Command {
    private final PairingID pairingID;
    private final QueryType queryType;

    public UpdateInterestedQueryType(PairingID pairingID, QueryType queryType) {
        this.pairingID = pairingID;
        this.queryType = queryType;
    }

    public PairingID getPairingID() {
        return pairingID;
    }

    public QueryType getQueryType() {
        return queryType;
    }
}
