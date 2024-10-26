import java.util.Arrays;
import java.util.List;
import java.util.Map;

// Abstract Graduate class
abstract class Graduate {
    protected String graduateName;
    protected int ID;
    protected String category;
    protected ProficiencyLevel[] proficiencyLevels; // Maps subject to proficiency level

    public Graduate(String graduateName, int ID, ProficiencyLevel[] proficiencyLevels) {
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
    public boolean isEligibleForTask(String course) {
        for (int i = 0; i < proficiencyLevels.length; i++) {
            if(proficiencyLevels[i].getCourse().compareToIgnoreCase(course) == 0){
                return proficiencyLevels[i].isAdvancedOrExpert();
            }
        }
        return false;
    }
    public void createGraduates(List<String[]> studentData) {
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
            //GraduateList.addGraduate(graduate);
        }
    }
    // Abstract method to get salary based on category
    public abstract float getSalary();

    public void addUpdateProf(ProficiencyLevel profLevel){
        for (int i = 0; i < proficiencyLevels.length; i++) {
            if(proficiencyLevels[i].getCourse().compareToIgnoreCase(profLevel.getCourse()) == 0){
                proficiencyLevels[i] = profLevel;
                return;
            }
        }
        ProficiencyLevel[] newLevels = Arrays.copyOf(proficiencyLevels, proficiencyLevels.length+1);
        newLevels[proficiencyLevels.length] = profLevel;
        setProficiencyLevels(newLevels);
    }

    private void setProficiencyLevels(ProficiencyLevel[] profLevels){
        proficiencyLevels = profLevels;
    }
}