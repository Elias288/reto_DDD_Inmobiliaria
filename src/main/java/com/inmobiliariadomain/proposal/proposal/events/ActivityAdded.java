package com.inmobiliariadomain.proposal.proposal.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.inmobiliariadomain.proposal.proposal.values.ActivityID;
import com.inmobiliariadomain.proposal.proposal.values.ActivityType;

public class ActivityAdded extends DomainEvent {
    private final ActivityID activityID;
    private final ActivityType activityType;

    public ActivityAdded(ActivityID activityID, ActivityType activityType) {
        super("com.inmobiliariadomain.proposal.activityadded");
        this.activityID = activityID;
        this.activityType = activityType;
    }

    public ActivityID getActivityID() {
        return activityID;
    }

    public ActivityType getActivityType() {
        return activityType;
    }
}
