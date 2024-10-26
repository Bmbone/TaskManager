import java.util.Map;

// GraduateCat1 class (inherits from Graduate)
class GraduateCat1 extends Graduate {
    private static final float SALARY = 500.0f;

    public GraduateCat1(String graduateName, int ID, ProficiencyLevel[] proficiencyLevels) {
        super(graduateName, ID, proficiencyLevels);
    }
    public GraduateCat1(String graduateName, int ID) {
        super(graduateName, ID);
    }

    @Override
    public float getSalary() {
        return SALARY;
    }
}