package model;

import util.Currency;
import util.Validator;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Programmer extends Employee{
    private int overtimeHours;

    public Programmer() {
        super(); //
        this.overtimeHours = 0;
    }

    public Programmer(String name, int age, String phone, String email, double basicSalary, int overtimeHours) {
        super(name, age, phone, email, basicSalary);
        this.overtimeHours = overtimeHours;
    }

    @Override
    public double getSalary() {
        return this.getBasicSalary() + this.overtimeHours * 400000;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", Overtime Hours: " + overtimeHours +
                ", Salary: " + Currency.vndFormat(getSalary()) +
                " (Programmer)";
    }

    @Override
    public void printEmployee() {
        String st = super.toString() +
                ", Overtime Hours: " + overtimeHours +
                ", Salary: " + Currency.vndFormat(getSalary()) +
                " (Programmer)";
        System.out.println(st);
    }

    @Override
    public void inputInformation() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter programmer information:");
        super.inputInformation();
        this.overtimeHours = Validator.getInt(br, "Overtime Hours: ");
    }
    @Override
    public void action() {
        System.out.println("Code App");
    }
    public int getOvertimeHours() {
        return overtimeHours;
    }

    public void setOvertimeHours(int overtimeHours) {
        this.overtimeHours = overtimeHours;
    }
}
