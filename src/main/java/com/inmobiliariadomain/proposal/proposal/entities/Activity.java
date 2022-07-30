package com.inmobiliariadomain.proposal.proposal.entities;

import co.com.sofka.domain.generic.Entity;
import com.inmobiliariadomain.proposal.proposal.values.ActivityID;
import com.inmobiliariadomain.proposal.proposal.values.ActivityType;
import com.inmobiliariadomain.proposal.proposal.values.IsDone;

import java.util.Objects;

public class Activity extends Entity<ActivityID> {

    private ActivityType activityType;
    private IsDone isDone;

    public Activity(ActivityID entityId, ActivityType activityType) {
        super(entityId);
        this.activityType = activityType;
        this.isDone = new IsDone(false);
    }

    public ActivityType ActivityType() {
        return activityType;
    }

    public IsDone IsDone() {
        return isDone;
    }

    public void updateActivityType(ActivityType activityType) {
        this.activityType = Objects.requireNonNull(activityType);
    }

    public void toggleIsDone(IsDone isDone) {
        this.isDone = Objects.requireNonNull(isDone);
    }
}
