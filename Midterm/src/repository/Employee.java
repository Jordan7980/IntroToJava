package repository;

public class Employee extends Entity<EmployeeId> {
    private String name;
    private int salary;

    public Employee(EmployeeId id, String name, int salary) {
        super(id);
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "name=" + name + ", salary=" + salary + ", Id=" + super.getId();
    }
}
