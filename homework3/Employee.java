package oop.homework3;

import java.time.LocalDate;

public class Employee {
    private String name;
    private String phone;
    private String address;
    private LocalDate dateOfBirth;
    private String departmentId;
    private String position;
    private float seniority;
    private double basicSalary;

    public Employee() {

    }

    public Employee(String name, String phone, String address,LocalDate dateOfBirth, String departmentId, String position, float seniority, double basicSalary) {
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.departmentId = departmentId;
        this.position = position;
        this.seniority = seniority;
        this.basicSalary = basicSalary;
        this.dateOfBirth = dateOfBirth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public float getSeniority() {
        return seniority;
    }

    public void setSeniority(float seniority) {
        this.seniority = seniority;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(double basicSalary) {
        this.basicSalary = basicSalary;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", date of birth='" + dateOfBirth + "\'" +
                ", departmentId='" + departmentId + '\'' +
                ", position='" + position + '\'' +
                ", seniority='" + seniority + '\'' +
                ", basicSalary=" + basicSalary +
                '}';
    }
}
