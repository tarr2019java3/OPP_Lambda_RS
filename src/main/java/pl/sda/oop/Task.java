package pl.sda.oop;

import java.time.LocalDate;

public class Task {
    private String taskName;
    private LocalDate startDate;
    private LocalDate stopDate;

    public Task(String taskName, LocalDate startDate, LocalDate stopDate) {
        this.taskName = taskName;
        this.startDate = startDate;
        this.stopDate = stopDate;
    }

    public String getTaskName() {
        return taskName;
    }

    @Override
    public String toString() {
        return "Task{" +
                "taskName='" + taskName + '\'' +
                ", startDate=" + startDate +
                ", stopDate=" + stopDate +
                '}';
    }
    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getStopDate() {
        return stopDate;
    }

    public void setStopDate(LocalDate stopDate) {
        this.stopDate = stopDate;
    }


}
