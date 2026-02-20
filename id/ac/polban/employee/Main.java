package id.ac.polban.employee;

import id.ac.polban.employee.model.*;
import id.ac.polban.employee.service.EmployeeService;

public class Main {
    public static void main(String[] args) {
        // Membuat beberapa department
        Department itDept = new Department("IT");
        Department hrDept = new Department("HR");

        // Membuat service untuk mengelola employee
        EmployeeService service = new EmployeeService();

        // Menambahkan beberapa employee
        Employee emp1 = Employee.createFullTimeEmployee("budi", itDept, 5000);
        Employee emp2 = Employee.createPartTimeEmployee("Rudi", hrDept, 3000);
        Employee emp3 = Employee.createContractEmployee("Siti", itDept, 4000);

        service.addEmployee(emp1);
        service.addEmployee(emp2);
        service.addEmployee(emp3);

        // Menampilkan data employee
        System.out.println("=== Data Employee ===");
        System.out.println("ID: " + emp1.getId() + ", Nama: " + emp1.getName() +
                           ", Dept: " + emp1.getDepartment().getName() +
                           ", Tipe: " + emp1.getType().getType() +
                           ", Gaji: " + emp1.getSalary());

        System.out.println("ID: " + emp2.getId() + ", Nama: " + emp2.getName() +
                           ", Dept: " + emp2.getDepartment().getName() +
                           ", Tipe: " + emp2.getType().getType() +
                           ", Gaji: " + emp2.getSalary());

        System.out.println("ID: " + emp3.getId() + ", Nama: " + emp3.getName() +
                           ", Dept: " + emp3.getDepartment().getName() +
                           ", Tipe: " + emp3.getType().getType() +
                           ", Gaji: " + emp3.getSalary());

        // Menaikkan gaji employee dengan ID 1 sebesar 10%
        service.raiseSalary(1, 10);

        // Menampilkan kembali data employee setelah kenaikan gaji
        System.out.println("\n=== Setelah Kenaikan Gaji ===");
        Employee updatedEmp1 = service.getEmployee(1);
        System.out.println("ID: " + updatedEmp1.getId() + ", Nama: " + updatedEmp1.getName() +
                           ", Dept: " + updatedEmp1.getDepartment().getName() +
                           ", Tipe: " + updatedEmp1.getType().getType() +
                           ", Gaji: " + updatedEmp1.getSalary());
    }
}