class TeachingSection extends Task {
    private int totalStudentsAttended;

    public TeachingSection(String taskName, int taskID, String taskProficiency) {
        super(taskName, taskID, taskProficiency);
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
