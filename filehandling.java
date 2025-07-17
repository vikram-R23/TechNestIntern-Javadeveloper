import java.io.*;
import java.util.*;

public class filehandling {
    static final String filePath = "sample.txt";
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        while (true) {
            System.out.println("\n1: Create File  2: Write  3: Read  4: Append  5: Exit");
            System.out.print("Choose option: ");
            int choice = sc.nextInt();
            sc.nextLine();  // to consume newline
            
            switch (choice) {
                case 1: createFile(); break;
                case 2: writeToFile(sc); break;
                case 3: readFromFile(); break;
                case 4: appendToFile(sc); break;
                case 5: System.exit(0);
                default: System.out.println("Invalid option.");
            }
        }
    }

    static void createFile() {
        File file = new File(filePath);
        try {
            if (file.createNewFile()) 
                System.out.println("File created successfully.");
            else 
                System.out.println("File already exists.");
        } catch (IOException e) {
            System.out.println("Error creating file: " + e.getMessage());
        }
    }

    static void writeToFile(Scanner sc) {
        try (FileWriter writer = new FileWriter(filePath, false)) {
            System.out.println("Enter text to write (overwrite):");
            String data = sc.nextLine();
            writer.write(data);
            System.out.println("Data written successfully.");
        } catch (IOException e) {
            System.out.println("Write error: " + e.getMessage());
        }
    }

    static void readFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            System.out.println("File Contents:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Read error: " + e.getMessage());
        }
    }

    static void appendToFile(Scanner sc) {
        try (FileWriter writer = new FileWriter(filePath, true)) {
            System.out.println("Enter text to append:");
            String data = sc.nextLine();
            writer.write("\n" + data);
            System.out.println("Data appended successfully.");
        } catch (IOException e) {
            System.out.println("Append error: " + e.getMessage());
        }
    }
}
