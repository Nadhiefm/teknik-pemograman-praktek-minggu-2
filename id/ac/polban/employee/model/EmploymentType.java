package id.ac.polban.employee.model;

public class EmploymentType {
    private String type;
    protected static final EmploymentType FULL_TIME = new EmploymentType("Full Time");
    protected static final EmploymentType PART_TIME = new EmploymentType("Part Time");
    protected static final EmploymentType CONTRACT = new EmploymentType("Contract");

    public EmploymentType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}