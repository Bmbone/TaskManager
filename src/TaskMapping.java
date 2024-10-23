import java.util.HashMap;
import java.util.Map;

class TaskMapping {
    private Map<Graduate, Task> mapGradTask;

    public TaskMapping() {
        this.mapGradTask = new HashMap<>();
    }

    // Map a graduate to a task
    public void assignTask(Graduate graduate, Task task) {
        mapGradTask.put(graduate, task);
    }

    public Map<Graduate, Task> getMapGradTask() {
        return mapGradTask;
    }

    // Modify the mapping of a graduate to a task (if needed)
    public void modifyMapping(Graduate graduate, Task newTask) {
        if (mapGradTask.containsKey(graduate)) {
            mapGradTask.put(graduate, newTask);
        }
    }
}
