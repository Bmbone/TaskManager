import java.util.ArrayList;
class TaskList {
    private ArrayList<Task> allTasks;

    public TaskList() {
        allTasks = new ArrayList<>();
    }

    // Get the list of all tasks
    public ArrayList<Task> getTasksList() {
        return allTasks;
    }

    // Add a new task to the list
    public void addTask(Task task) {
        allTasks.add(task);
    }

    // Remove a task from the list
    public void removeTask(Task task) {
        allTasks.remove(task);
    }

    // Modify a task in the list based on its ID
    public void modifyTask(int taskID, Task updatedTask) {
        for (int i = 0; i < allTasks.size(); i++) {
            if (allTasks.get(i).getTaskID() == taskID) {
                allTasks.set(i, updatedTask);
            }
        }
    }

    // Iterate through all tasks and print their names
    public void iterateAllTasks() {
        for (Task task : allTasks) {
            System.out.println(task.getTaskType());
        }
    }
    // Method to create tasks from CSV data (non-static)
    public void createTasks(ArrayList<String[]> taskData) {
        for (String[] taskRow : taskData) {
            int taskID = Integer.parseInt(taskRow[0]);  // Task ID (assuming index 0)
            String taskType = taskRow[3];               // Task Name (assuming index 1)
            String taskCourse = taskRow[4];        // Required Proficiency (assuming index 2)

            // Create a new Task object and add it to the task list
            Task task = new Task(taskID, taskType, taskCourse);
            this.addTask(task);
        }
    }
}
