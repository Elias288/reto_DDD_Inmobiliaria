package com.inmobiliariadomain.promotionsection.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.inmobiliariadomain.promotionsection.value.QueryType;

public class InterestedQueryTypeUpdated extends DomainEvent {
    private final InterestedAdded interestedAdded;
    private final QueryType queryType;

    public InterestedQueryTypeUpdated(InterestedAdded interestedAdded, QueryType queryType) {
        super("com.inmobiliariadomain.promotionsection.interestedquerytypeupdated");
        this.interestedAdded = interestedAdded;
        this.queryType = queryType;
    }

    public InterestedAdded getInterestedAdded() {
        return interestedAdded;
    }

    public QueryType getQueryType() {
        return queryType;
    }
}
