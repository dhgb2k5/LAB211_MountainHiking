package tool;

import java.util.UUID;
import java.util.Scanner;
import collections.MountainList;
import collections.StudentList;

public class Inputter {

    Boolean check = false;
    int choice = 0;

    public static String inputCampus() {
        int choice;
        Scanner sc = new Scanner(System.in);
        String campus = "";
        do {
            System.out.println("Choose your campus: ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    campus = "HE";
                    break;
                case 2:
                    campus = "SE";
                    break;
                case 3:
                    campus = "DE";
                    break;
                case 4:
                    campus = "QE";
                    break;
                case 5:
                    campus = "CE";
                    break;
                default:
                    System.out.println("Invalid choice! Please choose again!!!");
                    break;
            }
        } while (choice < 1 || choice > 5);
        return campus;
    }

    public static String getStudentID() {
        String randomNumber = UUID.randomUUID().toString().replaceAll("[^0-9]", "");
        String id = randomNumber.substring(0, 6);
        return inputCampus() + id;
    }

    public static boolean isValid(String input, String regex) {
        return input.matches(regex);
    }

    public static String inputName() {
        Scanner sc = new Scanner(System.in);
        String name = "";
        while (true) {
            System.out.println("Enter your name: ");
            name = sc.nextLine();
            if (isValid(name, Acceptable.NAME_VALID)) {
                break;
            } else {
                System.out.println("Your name is invalid, please try again!!!");
            }
        }
        return name;
    }

    public static String inputPhoneNumber() {
        Scanner sc = new Scanner(System.in);
        String phoneNumber = "";
        while (true) {
            System.out.println("Enter your phone number: ");
            phoneNumber = sc.nextLine();
            if (isValid(phoneNumber, Acceptable.PHONE_VALID)) {
                break;
            } else {
                System.out.println("Your phone number is invalid, please try again!!!");
            }
        }
        return phoneNumber;
    }

    public static String inputEmail() {
        Scanner sc = new Scanner(System.in);
        String email = "";
        while (true) {
            System.out.println("Enter your email: ");
            email = sc.nextLine();
            if (isValid(email, Acceptable.EMAIL_VALID)) {
                break;
            } else {
                System.out.println("Your email is invalid, please try again!!!");
            }
        }
        return email;
    }

    public static double tuitionFee(String phoneNumber) {
        double tuition = 6000000;
        if (isValid(phoneNumber, Acceptable.VIETTEL_VALID)
                || isValid(phoneNumber, Acceptable.VNPT_VALID)) {
            tuition = 6000000 - (6000000 * 35) / 100;
        }
        return tuition;
    }

    public static String mountainCode() {
        Scanner sc = new Scanner(System.in);
        String mountainCode;
        while (true) {
            System.out.println("Choose your mountain code: ");
            mountainCode = sc.nextLine();
            if (MountainList.isValidMountainCode(mountainCode)) {
                break;
            } else {
                System.out.println("Invalid mountain code! TRY AGAIN!!!");
            }
        }
        return "MT" + mountainCode;
    }

    public String Capitalize(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        StringBuilder capitalizeWords = new StringBuilder();
        String[] words = str.split("\\s+");
        for (String word : words) {
            if (word.isEmpty()) {
                continue;
            }
            String capitalizeWord = word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
            if (capitalizeWords.length() > 0) {
                capitalizeWords.append(" ");
            }
            capitalizeWords.append(capitalizeWord);
        }
        return capitalizeWords.toString();
    }
}
