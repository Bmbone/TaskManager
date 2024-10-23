import java.util.HashMap;
import java.util.Map;

class ProficiencyLevel {
    // Map to hold each graduate's courses and proficiency levels
    private Map<Graduate, Map<String, String>> graduateProficiencyMap;

    // Constructor initializes the map
    public ProficiencyLevel() {
        this.graduateProficiencyMap = new HashMap<>();
    }

    // Method to add or update a graduate's proficiency for a specific course
    public void addOrUpdateProficiency(Graduate graduate, String course, String proficiency) {
        // Get or create the inner map (course -> proficiency)
        Map<String, String> courseProficiencyMap = graduateProficiencyMap.getOrDefault(graduate, new HashMap<>());

        // Update the course proficiency
        courseProficiencyMap.put(course, proficiency);

        // Update the outer map with the new or updated inner map
        graduateProficiencyMap.put(graduate, courseProficiencyMap);
    }

    // Method to check if a graduate is Advanced or Expert in a specific course
    public boolean isAdvancedOrExpert(Graduate graduate, String course) {
        // Get the course proficiency map for the given graduate
        Map<String, String> courseProficiencyMap = graduateProficiencyMap.get(graduate);

        // If the graduate has no proficiency record for this course, return false
        if (courseProficiencyMap == null) {
            return false;
        }

        // Get the proficiency level for the specified course
        String proficiency = courseProficiencyMap.get(course);

        // Check if the proficiency level is "Advanced" or "Expert"
        return proficiency != null && (proficiency.equalsIgnoreCase("Advanced") || proficiency.equalsIgnoreCase("Expert"));
    }

    // Method to get the proficiency map for a specific graduate
    public Map<String, String> getProficiencyMapForGraduate(Graduate graduate) {
        return graduateProficiencyMap.get(graduate);
    }
}
