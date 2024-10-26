import java.util.HashMap;
import java.util.Map;

class ProficiencyLevel {
    // Map to hold each graduate's courses and proficiency levels
    private String courseId;
    private String profLevel;

    // Constructor initializes
    public ProficiencyLevel(String courseId, String profLevel) {
        this.courseId = courseId;
        this.profLevel = profLevel;
    }
    public ProficiencyLevel() {}

    // Method to add or update a graduate's proficiency for a specific course
    public void updateProficiency(String course, String proficiency) {
        this.courseId = courseId;
        this.profLevel = profLevel;
    }

    // Method to check if a graduate is Advanced or Expert in a specific course
    public boolean isAdvancedOrExpert() {
        // Check if the proficiency level is "Advanced" or "Expert"
        return profLevel != null && (profLevel.equalsIgnoreCase("Advanced") || profLevel.equalsIgnoreCase("Expert"));
    }

    public String getCourse() {
        return courseId;
    }

    //    // Method to get the proficiency map for a specific graduate
//    public Map<String, String> getProficiencyMapForGraduate(Graduate graduate) {
//        return graduateProficiencyMap.get(graduate);
//    }
}
