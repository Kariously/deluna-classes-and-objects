import java.util.ArrayList;

public class Search_Book {
    void search(ArrayList<String> title, ArrayList<String> author, ArrayList<Integer> year, String titleToFind) {
        for (int i = 0; i < title.size(); i++) {
            if (title.get(i).equalsIgnoreCase(titleToFind)) {
                System.out.println("Book found!");
                System.out.println("Title: " + title.get(i));
                System.out.println("Author: " + author.get(i));
                System.out.println("Year: " + year.get(i));
                return;
            }
        }
        System.out.println("Book not found!");
    }
}