package collections;

import java.util.ArrayList;
import java.text.DecimalFormat;
import model.Student;
import java.util.Scanner;
import tool.Inputter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import model.StastiticalInfo;
import utils.Menu;

public class StudentList {
    private static boolean isSaved = true;
    public static ArrayList<Student> students = new ArrayList<>();
    
    public static boolean isSaved() {
        return isSaved;
    }
    
    public static void addNewStudent() {

        String studentID = Inputter.getStudentID();
        String name = Inputter.inputName();
        String phoneNumber = Inputter.inputPhoneNumber();
        String email = Inputter.inputEmail();
        String mountainCode = Inputter.mountainCode();
        String tuitionFee = Double.toString(Inputter.tuitionFee(phoneNumber));

        Student student = new Student(studentID, name, phoneNumber, email, mountainCode, tuitionFee);
        students.add(student);
        showCurrent(student);

    }

    public static void update() {
        Scanner sc = new Scanner(System.in);
        String findStudentID;
        Student student;

        while (true) {
            System.out.println("Enter ID of the student to update: ");
            findStudentID = sc.nextLine();
            student = searchById(findStudentID);
            if (student != null) {
                student = searchById(findStudentID);
                System.out.println("Enter new information to update!");
                break;
            } else {
                System.out.println("Student not found, TRY AGAIN!");
            }
        }

        //name
        System.out.println("Enter new name to update or press 'ENTER' to skip: ");
        String newName = sc.nextLine();
        if (newName.isEmpty()) {
            System.out.println("No change! Keeping current name!");
        } else {
            newName = Inputter.inputName();
            System.out.println("New name has been saved.");
        }

        //phone number
        System.out.println("Enter new phone to update or press 'ENTER' to skip: ");
        String newPhone = sc.nextLine();

        if (newPhone.isEmpty()) {
            System.out.println("No change! Keeping current phone number!");
        } else {
            newPhone = Inputter.inputPhoneNumber();
            student.setPhoneNumber(newPhone);
            student.setTuitionFee(newPhone);
            System.out.println("New phone number has been saved.");
        }

        //email
        System.out.println("Enter new email to update or press 'ENTER' to skip: ");
        String newEmail = sc.nextLine();
        if (newEmail.isEmpty()) {
            System.out.println("No change! Keeping current email!");
        } else {
            newEmail = Inputter.inputEmail();
            student.setEmail(newEmail);
            System.out.println("New email has been saved.");
        }

        //mountain code
        System.out.println("Enter new email to update or press 'ENTER' to skip: ");
        String newMountain = sc.nextLine();
        if (newMountain.isEmpty()) {
            System.out.println("No change! Keeping current mountain code!");
        } else {
            newMountain = Inputter.mountainCode();
            student.setMountainCode(newMountain);
            System.out.println("New mountain code has been saved.");
        }
        isSaved = false;
        System.out.println("Successfully updated!!");
    }

    public static void delete() {
        String answer;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter student ID to delete: ");
        String findStudentID = sc.nextLine();
        Student student = searchById(findStudentID);
        if (student != null) {
            showMessage(student);
            System.out.println("Are you sure you want to delete this registration? (Y/N)");
            answer = sc.nextLine();
            if (answer.equalsIgnoreCase("Y")) {
                students.remove(student);
                isSaved = false;
                System.out.println("The registration has been successfully deleted.");
            } else {
                System.out.println("The deletion process is cancelled.");
            }
        } else {
            System.out.println("This student has not registered yet.");
        }
    }

    public static Student searchById(String id) {
        for (Student student : students) {
            if (student.getStudentID().equalsIgnoreCase(id)) {
                return student;
            }
        }
        return null;
    }

    public static void searchByName() {
        ArrayList<Student> searchedName = new ArrayList<>();
        System.out.println("Enter name to search: ");
        String name = Inputter.inputName().toLowerCase();
        for (Student student : students) {
            if (student.getName().toLowerCase().contains(name)) {
                searchedName.add(student);
            }
        }

        if (searchedName.isEmpty()) {
            System.out.println("No one matches the search criteria!");
        } else {
            System.out.println("Matching Students:");
            showAll(searchedName);
        }
    }

    public static void showAll(ArrayList<Student> students) {
        if (students.isEmpty()) {
            System.out.println("No students have registered yet.");
        } else {
            System.out.println("---------------------------------------------------------------------------------");
            System.out.println("| Student ID  | Name               | Phone        | Mountain Code | Tuition Fee |");
            System.out.println("---------------------------------------------------------------------------------");
            for (Student student : students) {
                String fee = formatTuitionFee(Inputter.tuitionFee(student.getPhoneNumber()));
                student.setTuitionFee(fee);
                System.out.println(student);
            }
            System.out.println("---------------------------------------------------------------------------------");
        }
    }

    public static void filterByCampusCode() {
        ArrayList<Student> filtedByCampus = new ArrayList<>();
        System.out.println("Choose campus to filter: ");
        Menu.campusMenu();
        String campus = Inputter.inputCampus();
        String campusName;

        for (Student student : students) {
            campusName = student.getStudentID().substring(0, 2);
            if (campusName.equals(campus)) {
                filtedByCampus.add(student);
            }
        }

        if (!filtedByCampus.isEmpty()) {
            System.out.println("Registered Students Under " + campus + ":");
            showAll(filtedByCampus);
        } else {
            System.out.println("No students have registered under this campus.");
        }
    }

    public static void statisticByMountainPeak() {
        HashMap<String, Integer> countPerPeak = new HashMap<>();
        HashMap<String, Double> totalFeeOfEachPeak = new HashMap<>();
        for (Student student : students) {
            String mountainCode = student.getMountainCode();
            double tuitionFee = Inputter.tuitionFee(student.getPhoneNumber());
            if (countPerPeak.containsKey(student.getMountainCode())) {
                countPerPeak.put(mountainCode, countPerPeak.get(mountainCode) + 1);
                totalFeeOfEachPeak.put(mountainCode, totalFeeOfEachPeak.get(mountainCode) + tuitionFee);
            } else {
                countPerPeak.put(mountainCode, 1);
                totalFeeOfEachPeak.put(mountainCode, tuitionFee);
            }
        }

        ArrayList<StastiticalInfo> statitics = new ArrayList<>();
        for (String mountainCode : countPerPeak.keySet()) {
            int numOfStudent = countPerPeak.get(mountainCode);
            String totalFee = formatTuitionFee(totalFeeOfEachPeak.get(mountainCode));
            statitics.add(new StastiticalInfo(mountainCode, numOfStudent, totalFee));
        }

        System.out.println("Statistics of Registration by Mountain Peak:");
        System.out.println("------------------------------------------------------");
        System.out.println("| Peak Name  | Number of Participants  | Total Cost  | ");
        System.out.println("------------------------------------------------------");
        for (StastiticalInfo statitic : statitics) {
            System.out.println(statitic);
        }
        System.out.println("------------------------------------------------------");
    }

    public static void writeToFile() {
        String filePath = "src/data/registrations.dat";
        try (FileOutputStream fos = new FileOutputStream(filePath);
                ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(students);
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    public static void readFromFile() {
        String filePath = "src/data/registrations.dat";
        try (FileInputStream fis = new FileInputStream(filePath);
                ObjectInputStream ois = new ObjectInputStream(fis)) {
            students = (ArrayList<Student>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void showCurrent(Student student) {
        System.out.println("---------------------------------------------------------------------------------");
        System.out.println("| Student ID  | Name               | Phone        | Mountain Code | Tuition Fee |");
        System.out.println("---------------------------------------------------------------------------------");
        System.out.println(student);
        System.out.println("---------------------------------------------------------------------------------");
    }

    public static void showMessage(Student student) {
        System.out.println("Student Details:");
        System.out.println("--------------------------------------------------");
        System.out.println("Student ID: " + student.getStudentID());
        System.out.println("Name      : " + student.getName());
        System.out.println("Phone     : " + student.getPhoneNumber());
        System.out.println("Mountain  : " + student.getMountainCode());
        System.out.println("Fee       : " + student.getTuitionFee());
        System.out.println("--------------------------------------------------");
    }

    public static void saveData() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Do you want to save Registration? (Y/N)");
        String message = sc.nextLine();
        if (message.equalsIgnoreCase("Y")) {
            writeToFile();
            isSaved = true;
            System.out.println("Registration data has been successfully saved to `registrations.dat`.");
        } else {
            System.out.println("Saving process is cancelled.");
        }
    }

    public static String formatTuitionFee(double tuitionFee) {
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        String finalTuitionFee = decimalFormat.format(tuitionFee);
        return finalTuitionFee;
    }
    
    public static void exitProgram() {
        Scanner sc = new Scanner(System.in);
        if (!isSaved) {
            System.out.println("Do you want to save the changes before exiting? (Y/N)");
            String choice1 = sc.nextLine();
            if (choice1.equalsIgnoreCase("Y")) {
                saveData();
            }
        }
    }
}
