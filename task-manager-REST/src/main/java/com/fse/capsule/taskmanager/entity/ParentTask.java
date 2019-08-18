package com.fse.capsule.taskmanager.entity;

import javax.persistence.*;

@Table(name="Parent_Task")
@Entity
public class ParentTask{


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="Parent_ID")
    private int parentTaskId;
    @Column(name="Parent_Task")
    private String parentTaskName;

    public int getParentTaskId() {
        return parentTaskId;
    }

    public void setParentTaskId(int parentTaskId) {
        this.parentTaskId = parentTaskId;
    }

    public String getParentTaskName() {
        return parentTaskName;
    }

    public void setParentTaskName(String parentTaskName) {
        this.parentTaskName = parentTaskName;
    }

    @Override
    public String toString() {
        return "ParentTask{" +
                "parentTaskId=" + parentTaskId +
                ", parentTaskName='" + parentTaskName + '\'' +
                '}';
    }
}
