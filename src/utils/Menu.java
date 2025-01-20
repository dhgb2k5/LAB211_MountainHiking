package utils;

public class Menu {

    public static void printMenu() {
        System.out.println("\n====================== MENU ======================");
        System.out.println("1. New Registration");
        System.out.println("2. Update Registration Information");
        System.out.println("3. Display Registered List");
        System.out.println("4. Delete Registration Information");
        System.out.println("5. Search Participants by Name");
        System.out.println("6. Filter Data by Campus");
        System.out.println("7. Statistics of Registration Numbers by Location");
        System.out.println("8. Save Data to File");
        System.out.println("9. Exit the Program");
    }

    public static void campusMenu() {
        System.out.println("Choose your campus: ");
        System.out.println("1. Ha Noi: HE");
        System.out.println("2. Sai gon: SE");
        System.out.println("3. Da Nang: DE");
        System.out.println("4. Quy Nhon: QE");
        System.out.println("5. Can Tho: CE");
    }

    
}
