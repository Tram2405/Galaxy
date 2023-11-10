package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.regex.Pattern;

public class Validator {
    public static String getString(BufferedReader br, String prompt){
        String st = "";
        boolean isValid = false;
        do {
         try {
             System.out.print(prompt);
             st = br.readLine().trim();
             isValid = true;
         }catch (IOException e){
             System.out.println(e.getMessage());
         }
        }while (!isValid);
            return st;
    }

    public static int getInt(BufferedReader br, String prompt){
        int value = 0;
        boolean isValid = false;
        do {
            try {
                System.out.print(prompt);
                value = Integer.parseInt(br.readLine().trim());
                isValid = true;
            } catch (NumberFormatException e) {
                System.out.println("Error! Invalid number, try again");
            } catch (IOException f) {
                System.out.println(f.getMessage());
            }
        } while (!isValid);
        return value;
    }

    public static Float getFloat(BufferedReader br, String prompt){
        Float value = 0.0f;
        boolean isValid = false;
        do {
            try {
                System.out.print(prompt);
                value = Float.parseFloat(br.readLine().trim());
                isValid = true;
            } catch (NumberFormatException e) {
                System.out.println("Error! Invalid number, try again");
            } catch (IOException f) {
                System.out.println(f.getMessage());
            }
        } while (!isValid);
        return value;
    }
    public static Double getDouble(BufferedReader br, String prompt){
        Double value = 0.0;
        boolean isValid = false;
        do {
            try {
                System.out.print(prompt);
                value = Double.parseDouble(br.readLine().trim());
                isValid = true;
            } catch (NumberFormatException e) {
                System.out.println("Error! Invalid number, try again");
            } catch (IOException f) {
                System.out.println(f.getMessage());
            }
        } while (!isValid);
       return value;
    }
    //super gọi đến contructor không tham số của class cha
    public static boolean emailIsValid(String email) {
        String emailPattern =
                "^[a-zA-Z][\\w-]+@([\\w]+\\.[\\w]+|[\\w]+\\.[\\w]{2,}\\.[\\w]{2,})$";
        return Pattern.matches(emailPattern, email);
    }


}
