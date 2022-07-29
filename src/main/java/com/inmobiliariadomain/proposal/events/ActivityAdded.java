package com.inmobiliariadomain.proposal.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.inmobiliariadomain.proposal.values.ActivityID;
import com.inmobiliariadomain.proposal.values.ActivityType;
import com.inmobiliariadomain.proposal.values.IsDone;

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
