package com.inmobiliariadomain.proposal.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.inmobiliariadomain.proposal.values.ActivityID;
import com.inmobiliariadomain.proposal.values.ActivityType;
import com.inmobiliariadomain.proposal.values.IsDone;

public class ActivityIsDoneUpdated extends DomainEvent {
    private final ActivityID activityID;
    private final IsDone isDone;


    public ActivityIsDoneUpdated(ActivityID activityID, IsDone isDone) {
        super("com.inmobiliariadomain.proposal.activityisdoneupdated");
        this.activityID = activityID;
        this.isDone = isDone;
    }

    public ActivityID getActivityID() {
        return activityID;
    }

    public IsDone getIsDone() {
        return isDone;
    }
}
