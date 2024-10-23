import java.util.ArrayList;
import java.util.HashMap;

public class GraduateList {

    private ArrayList<Graduate> graduateList;

    public GraduateList() {
        this.graduateList = new ArrayList<>();
    }

    public ArrayList<Graduate> getGraduatesList() {
        return this.graduateList;
    }

    // Adjusted createGraduates method
    public void createGraduates(ArrayList<String[]> studentData, ArrayList<String[]> surveyData) {
        for (String[] studentRow : studentData) {
            int id = Integer.parseInt(studentRow[1]); // Correct index for ID
            String name = studentRow[2];              // Correct index for name
            String category = studentRow[7];          // Correct index for category

            // Create the graduate based on category
            Graduate graduate;
            if (category.equalsIgnoreCase("I")) {
                graduate = new GraduateCat1(name, id, new HashMap<>());
            } else if (category.equalsIgnoreCase("II")) {
                graduate = new GraduateCat2(name, id, new HashMap<>());
            } else {
                System.out.println("Error: No category found for graduate " + name);
                continue;
            }
            // Add the graduate to the graduate list
            addGraduate(graduate);
            ProficiencyLevel proficiencyLevel = new ProficiencyLevel();
            // Add/update the graduate's proficiency in courses based on survey data
            for (String[] surveyRow : surveyData) {
                if (Integer.parseInt(surveyRow[1]) == id) {
                    String course = surveyRow[1];
                    String proficiency = surveyRow[2];
                    proficiencyLevel.addOrUpdateProficiency(graduate, course, proficiency);
                }
            }
        }
    }

    // Method to add a graduate to the list
    public void addGraduate(Graduate graduate) {
        this.graduateList.add(graduate);
    }
}
