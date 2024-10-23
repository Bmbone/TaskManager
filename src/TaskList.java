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
}
