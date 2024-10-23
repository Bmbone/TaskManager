import java.util.*;

public class Main {
    public static void main(String[] args) {
        try {
            // Initialize CSV readers for students and tasks
            CSV studentCSV = new CSV("sheet1_studentsInfo.csv", ",");
            CSV surveyCSV = new CSV("sheet2_studentsSurveyResults.csv", ",");
            CSV taskCSV = new CSV("sheet3_taskOpenings.csv", ",");
            CSV assignedTasksCSV = new CSV("sheet4_assignedTasks.csv", ",");

            // Read CSV data
            List<String[]> studentData = studentCSV.readCSV();
            List<String[]> surveyData = surveyCSV.readCSV();
            List<String[]> taskData = taskCSV.readCSV();

            // Print the CSV data (for debugging purposes)
            System.out.println(studentData);
            System.out.println(surveyData);
            System.out.println(taskData);
            /*

            // Initialize GraduateList, TaskList, and ProficiencyLevel
            GraduateList graduateList = new GraduateList();
            TaskList taskList = new TaskList();
            ProficiencyLevel proficiencyLevel = new ProficiencyLevel();  // To track graduate proficiency

            // Create graduates based on CSV data and store their proficiencies
            GraduateList.createGraduates(studentData, surveyData, proficiencyLevel, graduateList);

            // Create tasks based on CSV data
            TaskList.createTasks(taskData, taskList);

            // Create the TaskManager with graduates, tasks, and proficiency levels
            TaskManager taskManager = new TaskManager(graduateList.getGraduatesList(), taskList.getTasksList(), proficiencyLevel);

            // Provide options for task assignment or task completion
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter 1 to assign tasks, 2 to mark task as completed:");
            int option = scanner.nextInt();

            if (option == 1) {
                // Run automated task matching
                taskManager.assignTasks();

                // Write the assigned tasks to sheet4 using the CSV class
                assignedTasksCSV.writeAssignedTasks(taskManager.getTaskMapping());

            } else if (option == 2) {
                // Mark task as completed
                System.out.println("Enter your student ID:");
                int studentID = scanner.nextInt();
                Graduate graduate = taskManager.getGraduateByID(studentID);
                if (graduate != null) {
                    Task assignedTask = taskManager.getTaskForGraduate(graduate);
                    if (assignedTask != null) {
                        System.out.println("You have been assigned the task: " + assignedTask.getTaskType() + " " + assignedTask.getTaskCourse());
                        System.out.println("Type 'complete' to mark the task as completed or 'quit' to exit:");
                        scanner.nextLine(); // Consume newline
                        String input = scanner.nextLine();
                        if ("complete".equalsIgnoreCase(input)) {
                            assignedTask.markTaskAsCompleted();
                            System.out.println("Task has been marked as completed.");
                        } else {
                            System.out.println("Task was not marked as completed.");
                        }
                    } else {
                        System.out.println("No task assigned to this graduate.");
                    }
                } else {
                    System.out.println("No graduate found with this ID.");
                }
            }

             */

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
