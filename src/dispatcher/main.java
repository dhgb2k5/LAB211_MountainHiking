package dispatcher;

import collections.StudentList;
import static collections.StudentList.students;
import java.util.Scanner;
import utils.Menu;
import collections.MountainList;
public class main {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        StudentList.readFromFile();
        MountainList.readFromFile();
        int choice;
        do {
            Menu.printMenu();
            System.out.println("\n");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    Menu.campusMenu();
                    StudentList.addNewStudent();
                    System.out.println("Your information has been registered.");
                    break;
                case 2:
                    StudentList.update();
                    break;
                case 3:
                    System.out.println("Registered students:");
                    StudentList.showAll(students);
                    break;
                case 4:
                    StudentList.delete();
                    break;
                case 5:
                    StudentList.searchByName();
                    break;
                case 6:
                    StudentList.filterByCampusCode();
                    break;
                case 7:
                    StudentList.statisticByMountainPeak();
                    break;
                case 8:
                    StudentList.saveData();
                    break;
                case 9:
                    StudentList.exitProgram();
                    break;
                default: 
                    System.out.println("This function is not available. TRY AGAIN!!!");
                    break;
            }
        } while (choice != 9);
    }
}
