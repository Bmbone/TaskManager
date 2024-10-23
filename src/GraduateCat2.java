import java.util.Map;

// GraduateCat2 class (inherits from Graduate)
class GraduateCat2 extends Graduate {
    private static final float SALARY = 1000.0f;

    public GraduateCat2(String graduateName, int ID, Map<String, String> proficiencyLevels) {
        super(graduateName, ID, proficiencyLevels);
    }

    public GraduateCat2(String name, int id) {
        super(name, id);
    }

    @Override
    public float getSalary() {
        return SALARY;
    }
}