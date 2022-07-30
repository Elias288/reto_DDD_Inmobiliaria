package com.inmobiliariadomain.promotionsection.commands;

import co.com.sofka.domain.generic.Command;
import com.inmobiliariadomain.promotionsection.values.InterestedID;
import com.inmobiliariadomain.promotionsection.values.PairingID;
import com.inmobiliariadomain.promotionsection.values.QueryType;

public class UpdateInterestedQueryType extends Command {
    private final PairingID pairingID;
    private final InterestedID interestedID;
    private final QueryType queryType;

    public UpdateInterestedQueryType(PairingID pairingID,InterestedID interestedID, QueryType queryType) {
        this.pairingID = pairingID;
        this.queryType = queryType;
        this.interestedID = interestedID;
    }

    public PairingID getPairingID() {
        return pairingID;
    }

    public InterestedID getInterestedID() {
        return interestedID;
    }
    public QueryType getQueryType() {
        return queryType;
    }
}
