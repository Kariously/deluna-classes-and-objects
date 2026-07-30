import java.util.*;

public class Add_Book {
    ArrayList<String> title = new ArrayList<String>();
    ArrayList<String> author = new ArrayList<String>();
    ArrayList<Integer> year = new ArrayList<Integer>();

    void add(String tit, String aut, int yr) {
        try {
            title.add(tit);
            author.add(aut);
            year.add(yr);
            System.out.println("Book(s) added successfully!");
        } catch (Exception e) {
            System.out.println("Book(s) unable to add!");
        }
    }

    ArrayList<String> getTitle() {
        return title;
    }

    ArrayList<String> getAuthor() {
        return author;
    }

    ArrayList<Integer> getYear() {
        return year;
    }
}
