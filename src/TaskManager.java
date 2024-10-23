import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

class TaskManager {
    private List<Graduate> graduates;
    private List<Task> tasks;
    private ProficiencyLevel proficiencyLevel;  // Proficiency level map
    private TaskMapping taskMapping;

    public TaskManager(List<Graduate> graduates, List<Task> tasks, ProficiencyLevel proficiencyLevel) {
        this.graduates = graduates;
        this.tasks = tasks;
        this.proficiencyLevel = proficiencyLevel;  // Initialize with proficiency levels
        this.taskMapping = new TaskMapping();
    }

    // Method to assign tasks and write the results to a CSV file
    public void assignTasks(String outputPath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath))) {
            writer.write("GraduateID,GraduateName,TaskID,TaskName,Proficiency\n"); // CSV header

            for (Task task : tasks) {
                if (task.isAssigned()) {
                    continue;  // Skip tasks that are already assigned
                }

                Graduate assignedGraduate = findEligibleGraduateForTask(task);

                if (assignedGraduate != null) {
                    task.assignTask();
                    taskMapping.assignTask(assignedGraduate, task);

                    // Write the assignment to the CSV file
                    writer.write(assignedGraduate.getID() + "," +
                            assignedGraduate.getGraduateName() + "," +
                            task.getTaskID() + "," +
                            task.getTaskName() + "," +
                            task.getTaskProficiency() + "\n");

                    System.out.println("Assigned task: " + task.getTaskName() + " to " + assignedGraduate.getGraduateName());
                } else {
                    System.out.println("No eligible graduate found for task: " + task.getTaskName());
                }
            }

            System.out.println("Task assignment complete. Results written to: " + outputPath);
        } catch (IOException e) {
            System.err.println("Error writing to CSV file: " + e.getMessage());
        }
    }

    // Find an eligible graduate for the task (prioritizing GraduateCat2)
    private Graduate findEligibleGraduateForTask(Task task) {
        // First, prioritize GraduateCat2
        for (Graduate graduate : graduates) {
            if (graduate instanceof GraduateCat2 && isEligible(graduate, task)) {
                return graduate;
            }
        }

        // If no eligible GraduateCat2, check GraduateCat1
        for (Graduate graduate : graduates) {
            if (graduate instanceof GraduateCat1 && isEligible(graduate, task)) {
                return graduate;
            }
        }

        return null; // No eligible graduate found
    }

    // Check if a graduate is eligible for a task
    private boolean isEligible(Graduate graduate, Task task) {
        // Check if the graduate has already been assigned a task
        if (taskMapping.getMapGradTask().containsKey(graduate)) {
            return false;
        }

        // Use ProficiencyLevel to check if the graduate has Advanced or Expert proficiency in the course required by the task
        String requiredCourse = task.getTaskProficiency();
        return proficiencyLevel.isAdvancedOrExpert(graduate, requiredCourse);
    }

    // Method to find a graduate by their student ID (used in feature #2)
    public Graduate getGraduateByID(int studentID) {
        for (Graduate graduate : graduates) {
            if (graduate.getID() == studentID) {
                return graduate;
            }
        }
        return null;  // Return null if no graduate with the given ID is found
    }

    // Method to get the task assigned to a particular graduate
    public Task getTaskForGraduate(Graduate graduate) {
        return taskMapping.getMapGradTask().get(graduate);
    }
}
