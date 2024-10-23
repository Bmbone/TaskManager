class TeachingSection extends Task {
    private int totalStudentsAttended;

    public TeachingSection(int taskID, String taskType, String taskCourse) {
        super(taskID, taskType, taskCourse);
        this.totalStudentsAttended = 0;
    }

    // Mark the attendance of students
    public void markAttendance(int studentCount) {
        totalStudentsAttended = studentCount;
    }

    // Mark the task as complete when attendance is provided
    @Override
    public boolean isComplete() {
        return totalStudentsAttended > 0;
    }

    public int getTotalStudentsAttended() {
        return totalStudentsAttended;
    }
}
