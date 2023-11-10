package model;

import util.Currency;
import util.Validator;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public abstract class Employee {
    public static int increment = 0;
    private int code;
    private String name;
    private int age;
    private String phone;
    private String email;
    private double basicSalary;

    public abstract double getSalary();

    public Employee() { //contructor kh tham số
        increment++;
        this.code = increment;
        this.name = "";
        this.age = 0;
        this.phone = "";
        this.email = "";
        this.basicSalary = 0.0;
    }


    public Employee(String name, int age, String phone, String email, double basicSalary) { //contructor có tham số
        increment++;
        this.code = increment;
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.email = email;
        this.basicSalary = basicSalary;
    }

    @Override
    public String toString() {
        return
                "Code: " + code +
                ", Name:'" + name + '\'' +
                ", Age:" + age +
                ", Phone:'" + phone + '\'' +
                ", email:'" + email + '\'' +
                ", BasicSalary: " + Currency.vndFormat(basicSalary)+
                '}';
    }

    public void printEmplyee(){
        String st = "Code: " + code +
                ", Name:'" + name + '\'' +
                ", Age:" + age +
                ", Phone:'" + phone + '\'' +
                ", email:'" + email + '\'' +
                ", BasicSalary: " + Currency.vndFormat(basicSalary)+
                '}';
        System.out.println(st);
    }
    
    public void action(){
        System.out.println("I am an employee");
    }

    public void inputFormatmation(){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //tao bo nho dem
        this.name = Validator.getString(br, "Name: ");
        
//        this.age = Validator.getInt(br, "Age: ");
        boolean isValid = false;
        do {
            try {
                System.out.print("Age: ");
                this.age = Integer.parseInt(br.readLine().trim());
                isValid = true;
            } catch (NumberFormatException e) {
                System.out.println("Error! Invalid number, try again");
            } catch (IOException f) {
                System.out.println(f.getMessage());
            }
        } while (!isValid);
        
        this.phone = Validator.getString(br, "Phone");
        do {
            this.email = Validator.getString(br, "Email: ");
            System.out.println("Error!");
        }while (!Validator.emailIsValid(this.email));

        this.basicSalary = Validator.getDouble(br, "Basic Salary: ");
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(double basicSalary) {
        this.basicSalary = basicSalary;
    }

    public abstract void printEmployee();

    protected void inputInformation() {
    }
}
