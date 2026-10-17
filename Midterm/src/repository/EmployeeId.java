package repository;

import java.util.Objects;

public class EmployeeId {
	private String dept;
    private int number;

    public EmployeeId(String dept, int number) {
        this.dept = dept;
        this.number = number;
    }

    public String getDept() {
        return dept;
    }

    public int getNumber() {
        return number;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        EmployeeId that = (EmployeeId) obj;
        return this.dept.equals(that.dept) && this.number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(dept, number);
    }

    public String toString() {
    	return getDept() + "-" + getNumber();
    }
}
