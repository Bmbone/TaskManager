import java.io.*;
import java.util.*;

// CSV class to handle reading and writing CSV files
class CSV {
    private String filePath;
    private String delimiter;

    public CSV(String filePath, String delimiter) {
        this.filePath = filePath;
        this.delimiter = delimiter;
    }

    // Reads the CSV file and returns a list of string arrays representing rows
    public ArrayList<String[]> readCSV() throws IOException {
        List<String[]> data = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        while ((line = reader.readLine()) != null) {
            data.add(line.split(delimiter));
        }
        reader.close();
        return data;
    }

    // Writes the data to a CSV file
    public void writeCSV(List<String[]> data) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
        for (String[] row : data) {
            writer.write(String.join(delimiter, row));
            writer.newLine();
        }
        writer.close();
    }

    // Method to write the assigned tasks to sheet4_assignedTasks.csv
    public void writeAssignedTasks(TaskMapping taskMapping) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("GraduateID,GraduateName,TaskID,TaskName,Proficiency\n"); // CSV header

            // Iterate over the map of graduate-task assignments and write to the file
            for (Map.Entry<Graduate, Task> entry : taskMapping.getMapGradTask().entrySet()) {
                Graduate graduate = entry.getKey();
                Task task = entry.getValue();

                writer.write(graduate.getID() + delimiter +
                        graduate.getGraduateName() + delimiter +
                        task.getTaskID() + delimiter +
                        task.getTaskType() + delimiter +
                        task.getTaskCourse() + "\n");
            }

            System.out.println("Task assignments written to file: " + filePath);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}
