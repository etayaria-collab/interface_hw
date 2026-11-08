

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Payroll_Management_System {

    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>();

        employees.add(
                new FullTimeEmployee(
                        "E001",
                        "Ahmed",
                        5000,
                        LocalDate.of(2023, 1, 10),
                        1000
                )
        );

        employees.add(
                new FullTimeEmployee(
                        "E002",
                        "Mohamed",
                        4000,
                        LocalDate.of(2024, 3, 15),
                        800
                )
        );

        employees.add(
                new ContractorEmployee(
                        "C001",
                        "Ali",
                        LocalDate.of(2024, 6, 1),
                        50,
                        100
                )
        );

        employees.add(
                new ContractorEmployee(
                        "C002",
                        "Omar",
                        LocalDate.of(2023, 9, 20),
                        60,
                        120
                )
        );

        Collections.sort(employees);

        System.out.println("=== Employees Sorted by Net Salary ===");

        for (Employee employee : employees) {
            System.out.println(
                    employee.getName()
                            + " -> Net Salary: "
                            + employee.calculateNetSalary()
            );
        }

        employees.sort(
                Comparator.comparing(Employee::getName)
        );

        System.out.println("\n=== Employees Sorted by Name ===");

        for (Employee employee : employees) {
            System.out.println(
                    employee.getName()
                            + " -> "
                            + employee.calculateNetSalary()
            );
        }

        double totalPayroll = 0;

        System.out.println("\n=== Payroll Details ===");

        for (Employee employee : employees) {

            double salary = employee.calculateNetSalary();
            double tax = employee.calculateTax();

            double bonus;

            if (employee instanceof FullTimeEmployee) {
                bonus = employee.calculateBonus(5.0);
            } else {
                bonus = employee.calculateBonus(4.0);
            }

            double finalSalary = salary - tax + bonus;

            totalPayroll += finalSalary;

            System.out.println("\nEmployee: " + employee.getName());
            System.out.println("Salary: " + salary);
            System.out.println("Tax: " + tax);
            System.out.println("Bonus: " + bonus);
            System.out.println("Final Salary: " + finalSalary);
        }

        System.out.println("\n==============================");
        System.out.println("Total Payroll: " + totalPayroll);
        System.out.println("==============================");
    }
}