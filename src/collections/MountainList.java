package collections;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import model.Mountain;

public class MountainList {

    public static ArrayList<Mountain> mountains = new ArrayList<>();

    public static boolean isValidMountainCode(String mountainCode) {
        for (Mountain mountain : mountains) {
            if (mountain.getMountainCode().equalsIgnoreCase(mountainCode)) {
                return true;
            }
        }
        return false;
    }

    public static Mountain dataToObject(String text) {
        String[] parts = text.split(",", -1);
        if (parts.length <= 4) {
            Mountain mountain = new Mountain(parts[0].trim(),
                    parts[1].trim(),
                    parts[2].trim(),
                    parts[3].trim());
            return mountain;
        }
        return null;
    }

    public static ArrayList<Mountain> readFromFile() {
        String pathFile = "src/data/MountainList.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(pathFile))) {
            String line = br.readLine(); 
            while ((line = br.readLine()) != null) {
                Mountain mountain = dataToObject(line);
                if (mountain != null) {
                    mountains.add(mountain);
                }
            }
            System.out.println("Loaded " + mountains.size() + " mountains from file.");
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return mountains; 
    }
    
    public static void display() {
       MountainList mountain1 = new MountainList();
       mountain1.readFromFile();
        for (Mountain mountain : mountains) {
            System.out.println(mountain);
            System.out.println("");
        }
    }
}
