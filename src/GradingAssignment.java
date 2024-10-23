import java.util.ArrayList;
import java.util.List;

class GradingAssignment extends Task {
    private List<Float> gradesList;

    public GradingAssignment(int taskID, String taskType, String taskCourse) {
        super(taskID, taskType, taskCourse);
        this.gradesList = new ArrayList<>();
    }

    // Add a grade to the list
    public void addGrade(float grade) {
        gradesList.add(grade);
    }

    // Modify a grade at a specific index
    public void modifyGrade(int index, float newGrade) {
        if (index >= 0 && index < gradesList.size()) {
            gradesList.set(index, newGrade);
        }
    }

    // Remove a grade at a specific index
    public void removeGrade(int index) {
        if (index >= 0 && index < gradesList.size()) {
            gradesList.remove(index);
        }
    }

    // Calculate the average grade
    private float calculateAverage() {
        float sum = 0;
        for (Float grade : gradesList) {
            sum += grade;
        }
        return sum / gradesList.size();
    }

    // Mark the task as completed by calculating the average
    @Override
    public boolean isComplete() {
        return !gradesList.isEmpty() && calculateAverage() > 0;
    }

    public List<Float> getGrades() {
        return gradesList;
    }
}
