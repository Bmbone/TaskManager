import java.util.ArrayList;
import java.util.List;

class Task {
    protected String taskType;
    protected int taskID;
    protected String taskCourse;
    protected TaskCompletion taskCompletion;
    private boolean assigned;  // Attribute to track task assignment

    public Task(int taskID,String taskType, String taskCourse) {
        this.taskID = taskID;
        this.taskType = taskType;
        this.taskCourse = taskCourse;
        this.taskCompletion = new TaskCompletion();
        this.assigned = false;  // Initialize as not assigned
    }

    // Getter for task name
    public String getTaskType() {
        return taskType;
    }

    // Getter for task ID
    public int getTaskID() {
        return taskID;
    }

    // Getter for task proficiency
    public String getTaskCourse() {
        return taskCourse;
    }

    // Method to check if the task has been assigned
    public boolean isAssigned() {
        return assigned;
    }
    // Mark the task as complete
    public void markTaskAsCompleted() {
        taskCompletion.markTaskCompleted(this);
    }

    // Check if the task is completed
    public boolean isComplete() {
        return taskCompletion.getCompleteStatus();
    }

    }