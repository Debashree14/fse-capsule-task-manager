package com.fse.capsule.taskmanager.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="Task_ID")
    private int taskId;
    @Column(name="Task")
    private String taskName;
    @Column(name="Parent_ID")
    private int parentTaskId;
    @Column(name="Start_Date")
    private Date startDate;
    @Column(name="End_Date")
    private Date entDate;
    @Column(name="Priority")
    private int priority;

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public int getParentTaskId() {
        return parentTaskId;
    }

    public void setParentTaskId(int parentTaskId) {
        this.parentTaskId = parentTaskId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEntDate() {
        return entDate;
    }

    public void setEntDate(Date entDate) {
        this.entDate = entDate;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "Task{" +
                "taskId=" + taskId +
                ", taskName='" + taskName + '\'' +
                ", parentTaskId=" + parentTaskId +
                ", startDate=" + startDate +
                ", entDate=" + entDate +
                ", priority=" + priority +
                '}';
    }
}
