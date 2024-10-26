import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

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
        ArrayList<String> courseList = new ArrayList<String>();
        for (int i = 0; i < surveyData.get(0).length; i++) {
            if(i>4 && i < surveyData.get(0).length -1){
                courseList.add(surveyData.get(0)[i]);
            }
        }
        for (String[] studentRow : studentData.subList( 1, studentData.size() )) {
            int id = Integer.parseInt(studentRow[1]); // Correct index for ID
            String name = studentRow[2];              // Correct index for name
            String category = studentRow[7];          // Correct index for category

            // Create the graduate based on category
            Graduate graduate;
            if (category.equalsIgnoreCase("Category I")) {
                graduate = new GraduateCat1(name, id, new ProficiencyLevel[]{});
            } else if (category.equalsIgnoreCase("Category II")) {
                graduate = new GraduateCat2(name, id, new ProficiencyLevel[]{});
            } else {
                System.out.println("Error: No category found for graduate " + name);
                continue;
            }
            // Add the graduate to the graduate list
            addGraduate(graduate);
            // Add/update the graduate's proficiency in courses based on survey data
            for (String[] surveyRow : surveyData.subList( 1, surveyData.size() )) {
                if (Integer.parseInt(surveyRow[1]) == id) {
                    AtomicInteger i = new AtomicInteger();
                    Arrays.stream(surveyRow).skip(5).forEach(
                            prof -> {
                                if(i.get()!=13){
                                    graduate.addUpdateProf(new ProficiencyLevel(courseList.get(i.get()), prof));
                                    i.getAndIncrement();
                                }
                            }
                    );
                }
            }
        }
    }

    // Method to add a graduate to the list
    public void addGraduate(Graduate graduate) {
        this.graduateList.add(graduate);
    }
}
