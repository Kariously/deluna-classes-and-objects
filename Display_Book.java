import java.util.ArrayList;

public class Display_Book {
    void showAll(ArrayList<String> title, ArrayList<String> author, ArrayList<Integer> year) {

        // Start with header lengths as the minimum width
        int titleWidth = "Title".length();
        int authorWidth = "Author".length();
        int yearWidth = "Year".length();

        // Check each entry and grow the width if it's longer
        for (int i = 0; i < title.size(); i++) {
            titleWidth = Math.max(titleWidth, title.get(i).length());
            authorWidth = Math.max(authorWidth, author.get(i).length());
            yearWidth = Math.max(yearWidth, String.valueOf(year.get(i)).length());
        }

        // Add a little padding so columns aren't cramped
        titleWidth += 2;
        authorWidth += 2;
        yearWidth += 2;

        // Build the format string dynamically
        String format = "%-" + titleWidth + "s %-" + authorWidth + "s %-" + yearWidth + "s%n";

        System.out.printf(format, "Title", "Author", "Year");

        for (int i = 0; i < title.size(); i++) {
            System.out.printf(format, title.get(i), author.get(i), String.valueOf(year.get(i)));
        }
    }
}