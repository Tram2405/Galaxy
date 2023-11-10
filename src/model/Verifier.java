package model;

import util.Currency;
import util.Validator;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Verifier extends Employee{
    private int errorNumber;

    @Override
    public double getSalary() {
        return this.getBasicSalary() + this.errorNumber;
    }

    public Verifier(){
        super();
        this.errorNumber = 0;
    }

    public Verifier(String name, int age, String phone, String email, double basicSalary){
        super(name, age, phone, email, basicSalary);
        this.errorNumber = errorNumber;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", Error Number: " + errorNumber +
                ", Salary: " + Currency.vndFormat(getSalary()) +
                " (Verifier)";
    }

    @Override
    public void printEmployee() {
        String st = super.toString() +
                ", Error Number: " + errorNumber +
                ", Salary: " + Currency.vndFormat(getSalary()) +
                " (Verifier)";
        System.out.println(st);
    }

    @Override
    public void inputInformation() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter verifier information:");
        super.inputInformation();
        this.errorNumber = Validator.getInt(br, "Error Number: ");
    }

    @Override
    public void action(){
        System.out.println("Test code");
    }

    public int getErrorNumber(){return errorNumber;}

    public void setErrorNumber(int errorNumber) {this.errorNumber=errorNumber;}
}
