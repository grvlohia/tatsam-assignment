package com.tatsam.priority.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "user_priority")
@IdClass(UserPriorityId.class)
public class UserPriority {
    @Id
    @Column(name = "user_id")
    private Long userId;
    @Id
    @Column(name = "priority_id")
    private Long priorityId;
    @Column(name = "satisfaction")
    private int satisfactionRating;
    @Column(name = "priority")
    private int priorityOrder;

    public UserPriority() {
    };

    public UserPriority(Long userId, Long priorityId, int satisfactionRating, int priorityOrder) {
        this.userId = userId;
        this.priorityId = priorityId;
        this.satisfactionRating = satisfactionRating;
        this.priorityOrder = priorityOrder;
    }

    public Long getUserId() {
        return this.userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getPriorityId() {
        return this.priorityId;
    }

    public void setPriorityId(Long priorityId) {
        this.priorityId = priorityId;
    }

    public int getSatisfactionRating() {
        return this.satisfactionRating;
    }

    public void setSatisfactionRating(int satisfactionRating) {
        this.satisfactionRating = satisfactionRating;
    }

    public int getPriorityOrder() {
        return this.priorityOrder;
    }

    public void setPriorityOrder(int priorityOrder) {
        this.priorityOrder = priorityOrder;
    }

    @Override
    public String toString() {
        return "UserPriority[userId=" + userId + ", priorityId=" + priorityId + ", satisfactionRating="
                + satisfactionRating + ", priorityOrder=" + priorityOrder + "]";
    }
}
