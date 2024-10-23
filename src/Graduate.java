import java.util.List;
import java.util.Map;

// Abstract Graduate class
abstract class Graduate {
    protected String graduateName;
    protected int ID;
    protected String category;
    protected Map<String, String> proficiencyLevels; // Maps subject to proficiency level

    public Graduate(String graduateName, int ID, Map<String, String> proficiencyLevels) {
        this.graduateName = graduateName;
        this.ID = ID;
        this.proficiencyLevels = proficiencyLevels;
    }

    public Graduate(String graduateName, int id) {
        this.graduateName = graduateName;
        this.ID = ID;
    }

    public String getGraduateName() { return graduateName; }
    public int getID() { return ID; }
    public boolean isEligibleForTask(String taskProficiency) {
        String proficiency = proficiencyLevels.getOrDefault(taskProficiency, "Not familiar");
        return proficiency.equals("Advanced") || proficiency.equals("Expert");
    }
    public static void createGraduates(List<String[]> studentData) {
        for (String[] studentRow : studentData) {
            int id = Integer.parseInt(studentRow[1]);
            String name = studentRow[2];
            String category = studentRow[7];
            if (category.toUpperCase().equals("I")){
                GraduateCat1 graduate = new GraduateCat1(name, id);
            }
            else if(category.toUpperCase().equals("II")){
                GraduateCat2 graduate = new GraduateCat2(name, id);
            }
            else {
                System.out.println("Error: No category found");
            }
            GraduateList.addGraduate(graduate);
        }
    }
    // Abstract method to get salary based on category
    public abstract float getSalary();
}