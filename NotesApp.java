import java.io.*;
import java.util.Scanner;

public class NotesApp {
    private static final String FILE_NAME = "notes.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n====== Notes App ======");
            System.out.println("1. Add Note (Append)");
            System.out.println("2. View Notes");
            System.out.println("3. Overwrite Notes");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addNote(scanner);
                    break;
                case 2:
                    viewNotes();
                    break;
                case 3:
                    overwriteNotes(scanner);
                    break;
                case 4:
                    System.out.println("Exiting... Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again!");
            }
        } while (choice != 4);

        scanner.close();
    }

    // Method to append note to file
    private static void addNote(Scanner scanner) {
        System.out.print("Enter your note: ");
        String note = scanner.nextLine();

        // try-with-resources automatically closes the stream
        try (FileWriter fw = new FileWriter(FILE_NAME, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {

            out.println(note);
            System.out.println("Note added successfully.");

        } catch (IOException e) {
            System.err.println("Error while writing to file: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Method to read notes from file
    private static void viewNotes() {
        System.out.println("\n--- Your Notes ---");

        try (FileReader fr = new FileReader(FILE_NAME);
             BufferedReader br = new BufferedReader(fr)) {

            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

        } catch (FileNotFoundException e) {
            System.err.println("No notes found! (File not created yet)");
        } catch (IOException e) {
            System.err.println("Error while reading file: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Method to overwrite file with new notes
    private static void overwriteNotes(Scanner scanner) {
        System.out.println("This will overwrite all existing notes!");
        System.out.print("Enter new note content: ");
        String note = scanner.nextLine();

        try (FileWriter fw = new FileWriter(FILE_NAME, false);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {

            out.println(note);
            System.out.println("Notes overwritten successfully.");

        } catch (IOException e) {
            System.err.println("Error while overwriting file: " + e.getMessage());
            e.printStackTrace();
        }
    }
}