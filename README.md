Java File I/O (FileWriter, BufferedWriter, PrintWriter, FileReader, BufferedReader)

Exception handling (try-with-resources, IOException, FileNotFoundException)

Menu-driven programs using Scanner

Appending vs. overwriting file content

🚀 Features

✅ Add a note (appends to the file without deleting old notes)
✅ View all saved notes
✅ Overwrite notes (replaces old content with new)
✅ Graceful error handling (file not found, I/O errors)
✅ Menu-driven interface

🛠️ Technologies Used

Java (JDK 8+)

File Handling (java.io.*)

Scanner for user input (java.util.Scanner)

📂 Project Structure
NotesApp.java   # Main Java source file
notes.txt       # File where notes are saved

▶️ How to Run

Compile the program:

javac NotesApp.java


Run the program:

java NotesApp


Follow the menu:

1 → Add Note

2 → View Notes

3 → Overwrite Notes

4 → Exit

📸 Sample Output
====== Notes App ======
1. Add Note (Append)
2. View Notes
3. Overwrite Notes
4. Exit
Enter your choice: 1
Enter your note: Hello Java File Handling!
Note added successfully.
