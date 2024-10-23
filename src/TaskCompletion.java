class TaskCompletion {
    private boolean completeStatus;

    public TaskCompletion() {
        this.completeStatus = false;
    }

    // Mark the task as completed
    public void markTaskCompleted(Task task) {
        if (task.isComplete()) {
            this.completeStatus = true;
        }
    }

    public boolean getCompleteStatus() {
        return completeStatus;
    }
}
