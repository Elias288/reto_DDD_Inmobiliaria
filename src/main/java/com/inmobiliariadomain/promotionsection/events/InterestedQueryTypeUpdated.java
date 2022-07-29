package com.inmobiliariadomain.promotionsection.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.inmobiliariadomain.promotionsection.values.InterestedID;
import com.inmobiliariadomain.promotionsection.values.QueryType;

public class InterestedQueryTypeUpdated extends DomainEvent {
    private final InterestedID interestedID;
    private final QueryType queryType;

    public InterestedQueryTypeUpdated(InterestedID interestedID, QueryType queryType) {
        super("com.inmobiliariadomain.promotionsection.interestedquerytypeupdated");
        this.interestedID = interestedID;
        this.queryType = queryType;
    }

    public InterestedID getInterestedID() {
        return interestedID;
    }

    public QueryType getQueryType() {
        return queryType;
    }
}
