package ra.bussiness.model;

import java.time.LocalDate;

public class Employee {
private  Long employeeId;
private  String employeeName;
private LocalDate birthday;
private  String position;
private String departmentId;

    public Employee() {
    }

    public Employee(Long employeeId, String employeeName, LocalDate birthday, String position, String departmentId) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.birthday = birthday;
        this.position = position;
        this.departmentId = departmentId;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", employeeName='" + employeeName + '\'' +
                ", birthday=" + birthday +
                ", position='" + position + '\'' +
                ", departmentId='" + departmentId + '\'' +
                '}';
    }
}
