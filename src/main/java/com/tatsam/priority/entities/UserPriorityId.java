package com.tatsam.priority.entities;

import java.io.Serializable;
import java.util.Objects;

public class UserPriorityId implements Serializable {
    private Long userId;
    private Long priorityId;

    public UserPriorityId() {
    };

    public UserPriorityId(Long userId, Long priorityId) {
        this.userId = userId;
        this.priorityId = priorityId;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        UserPriorityId userPriorityId = (UserPriorityId) obj;
        return userId.equals(userPriorityId.userId) && priorityId.equals(userPriorityId.priorityId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, priorityId);
    }
}
