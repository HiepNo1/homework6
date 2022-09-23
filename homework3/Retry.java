package oop.homework3;

import oop.collection.Collection;

import java.time.LocalDate;
import java.util.*;

public class Retry {
    public static void employeeByDepartment(Map<String, ArrayList<Employee>> department, ArrayList<Employee> employees) {
        for (Employee employee : employees) {
            ArrayList<Employee> employeeDepartment = department.get(employee.getDepartmentId());
            if (employeeDepartment == null) {
                employeeDepartment = new ArrayList<Employee>(){{
                    add(employee);
                }};
            } else {
                employeeDepartment.add(employee);
            }
            department.put(employee.getDepartmentId(), employeeDepartment);
        }
    }

    public static void printEmployeeList(Map<String, ArrayList<Employee>> department) {
        System.out.println("Phòng hành chính nhân sự : " + department.get("HCNS"));
        System.out.println("Phòng chăm sóc khách hàng : " + department.get("CSKH"));
        System.out.println("Phòng SALE : " + department.get("SALE"));
        System.out.println("Phòng ban điều hành : " + department.get("BOD"));
        System.out.println("Phòng sản xuất : " + department.get("PRODUCT"));
    }
    public static void main(String[] args) {
        ArrayList<Employee> employeeArrayList = new ArrayList<Employee>(){
            {
                add(new Employee("Hiệp", "0399640692", "Thái Bình", LocalDate.of(2001,11,6), "HCNS", "HR", 20, 100000));
                add(new Employee("Thắng", "0399640692", "Nghệ An", LocalDate.of(2000,11,7), "HCNS", "CTO", 18, 90000));
                add(new Employee("Thịnh", "0399640692", "Ninh Bình", LocalDate.of(2001,10,16), "SALE", "sale", 12, 30000));
                add(new Employee("Thủy", "0399640692", "Bắc Giang", LocalDate.of(2002,5,12), "SALE", "sale", 13, 30000));
                add(new Employee("Nam", "0399640692", "Thái Bình", LocalDate.of(2003,5,2), "CSKH", "Lễ tân", 8, 40000));
                add(new Employee("Hiếu", "0399640692", "Thái Bình", LocalDate.of(2002,1,1), "CSKH", "Dev", 9, 40000));
                add(new Employee("Đức", "0399640692", "Hà Nội", LocalDate.of(2001,5,8), "BOD", "Tech lead", 17, 60000));
                add(new Employee("Huy", "0399640692", "Quảng Ninh", LocalDate.of(2001,8,7), "BOD", "PM", 16, 60000));
                add(new Employee("Hoàng", "0399640692", "Thái Bình", LocalDate.of(2001,9,19), "PRODUCT", "Saler", 10, 80000));
                add(new Employee("Hà", "0399640692", "Thái Bình", LocalDate.of(2001,10,22), "PRODUCT", "CEO", 11, 80000));
            }
        };

        Map<String, ArrayList<Employee>> department = new HashMap<>();
        System.out.println("Danh sách nhân viên theo phòng ban");
        employeeByDepartment(department, employeeArrayList);
        printEmployeeList(department);

        //Sắp xếp theo tuổi giảm dần
        for (Employee employee : employeeArrayList) {
            Collections.sort(department.get(employee.getDepartmentId()), new Comparator<Employee>() {
                @Override
                public int compare(Employee o1, Employee o2) {
                    return o1.getDateOfBirth().compareTo(o2.getDateOfBirth());
                }
            });
        }
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("Danh sách nhân viên theo độ tuổi giảm dần của từng phòng ban");
        printEmployeeList(department);
        int vacationDay;

        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("Danh sách nhân viên sau khi tăng lương cơ bản");
        for (Employee employee : employeeArrayList) {
            ArrayList<Employee> employeeDepartment = department.get(employee.getDepartmentId());
            employee.setBasicSalary(employee.getBasicSalary() + employee.getBasicSalary() * 0.1 / employeeDepartment.size());
        }
        printEmployeeList(department);


        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("Danh sách nhân viên có thêm số ngày nghỉ phép ");
        for (int i = 0; i < employeeArrayList.size(); i++) {
            if (employeeArrayList.get(i).getSeniority() > 2 && employeeArrayList.get(i).getSeniority() <= 3) {
                vacationDay = 13;
            } else if (employeeArrayList.get(i).getSeniority() > 3 && employeeArrayList.get(i).getSeniority() <= 5) {
                vacationDay = 15;
            } else if (employeeArrayList.get(i).getSeniority() > 5 && employeeArrayList.get(i).getSeniority() <= 10) {
                vacationDay = 18;
            } else if (employeeArrayList.get(i).getSeniority() > 10) {
                vacationDay = 23;
            } else {
                vacationDay = 0;
            }
            System.out.println(employeeArrayList.get(i) + " vacationDay = " + vacationDay);
        }
    }
}
