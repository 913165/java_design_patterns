package org.designpattern.structural.composite;

interface Employee {
    public void showEmployeeDetails();
}

class Developer implements Employee {
    private String name;
    private long empId;
    private String position;

    public Developer(long empId, String name, String position) {
        this.empId = empId;
        this.name = name;
        this.position = position;
    }

    @Override
    public void showEmployeeDetails() {
        System.out.println(empId + " " + name + " " + position);
    }
}
class Manager implements Employee {
    private String name;
    private long empId;
    private String position;

    public Manager(long empId, String name, String position) {
        this.empId = empId;
        this.name = name;
        this.position = position;
    }

    @Override
    public void showEmployeeDetails() {
        System.out.println(empId + " " + name + " " + position);
    }
}

class Department implements Employee {
    private String name;
    private long deptId;
    private java.util.List<Employee> employees = new java.util.ArrayList<Employee>();

    public Department(long deptId, String name) {
        this.deptId = deptId;
        this.name = name;
    }

    public void addEmployee(Employee emp) {
        employees.add(emp);
    }

    public void removeEmployee(Employee emp) {
        employees.remove(emp);
    }

    @Override
    public void showEmployeeDetails() {
        System.out.println(deptId + " " + name);
        for (Employee emp : employees) {
            emp.showEmployeeDetails();
        }
    }
}

public class CompositePatternDemo {
    public static void main(String[] args) {
        Developer dev1 = new Developer(100, "Lokesh Sharma", "Pro Developer");
        Developer dev2 = new Developer(101, "Vinay Sharma", "Developer");
        Department engDirectory = new Department(200, "Engineering");
        engDirectory.addEmployee(dev1);
        engDirectory.addEmployee(dev2);

        Manager man1 = new Manager(200, "Kushagra Garg", "SEO Manager");
        Manager man2 = new Manager(201, "Vikram Sharma ", "Kushagra's Manager");

        Department accDirectory = new Department(300, "Accounts");
        accDirectory.addEmployee(man1);
        accDirectory.addEmployee(man2);

        Department directory = new Department(100, "Directory");
        directory.addEmployee(engDirectory);
        directory.addEmployee(accDirectory);
        directory.showEmployeeDetails();
    }
}
