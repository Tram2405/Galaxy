package manager;
import model.Employee;
import model.Programmer;
import model.Verifier;
import util.Currency;
import util.Validator;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class EmployeeManager {
    private List<Employee> employees;

    public EmployeeManager(){
        employees = new ArrayList<>();
    }

    public void inputEmployee(){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("1. Input a programer");
        System.out.println("1. Input a verifier");
        int i;
        do {
            i = Validator.getInt(br, "Choice");
        }while ((i != 1) && (i!=2));

        Employee employee;
        switch (i){
            case 1:
                employee = new Programmer();
                break;
            case 2:
                employee = new Verifier();
                break;
            default:
                employee = new Employee() {
                    @Override
                    public double getSalary() {
                        return 0;
                    }

                    @Override
                    public void printEmployee() {

                    }
                };
        }
        employee.inputFormatmation();
        employees.add(employee);
    }

    public void showAllEmployeeList() {
        System.out.println("Show all Employee List:");
//        for (Employee employee : employees)
//            System.out.println(employee);
        for (Employee employee : employees)
            employee.printEmployee();
    }

    public void showAllProgrammerList() {
        System.out.println("Show all Employee List:");
        for (Employee employee : employees) {
            if (employee instanceof Programmer)
                System.out.println(employee);
        }
    }

    public void showAllVerifierList() {
        System.out.println("Show all Verifier List:");
        for (Employee employee : employees) {
            if (!(employee instanceof Verifier))
                continue;
            System.out.println(employee);
        }
    }

    public double averageSalary() {
        double sum = 0.0;
        for (Employee employee : employees)
            sum += employee.getSalary();
        return sum / employees.size();
    }

    public void listLowerAverageSalaryEmployee() {
        System.out.println("List Lower Average Salary Employee:");
        System.out.printf("(Average Salary = %s)\n", Currency.vndFormat(averageSalary()));
        for (Employee employee : employees) {
            if (employee.getSalary() < averageSalary())
                System.out.println(employee);
        }
    }

    public void sortEmployeeBySalaryAscending() {
        System.out.println("Sort Employee by Salary Ascending:");
        List<Employee> list1 = new ArrayList<>();
        list1.addAll(employees);

        Collections.sort(list1, new Comparator<Employee>() {
            @Override
            public int compare(Employee emp1, Employee emp2) {
                if (emp1.getSalary() > emp2.getSalary())
                    return 1;
                else if (emp1.getSalary() < emp2.getSalary())
                    return -1;
                else {
                    if (emp1.getAge() > emp1.getAge())
                        return 1;
                    else if (emp1.getAge() < emp2.getAge())
                        return -1;
                    else
                        return emp1.getName().compareToIgnoreCase(emp2.getName());
                }
            }
        });
    }

}

