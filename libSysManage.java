import java.util.*;

public class libSysManage {

    // Nawala lahat ng commit ko, sir. Four commits para sa lahat ng files

    public static boolean isValidTitle(String input, ArrayList<String> existingTitles) {
        if (input == null || input.trim().isEmpty()) {
            return false;
        }
        if (input.length() > 100) {
            return false;
        }
        if (!input.matches(".*\\p{L}{2,}.*")) {
            return false;
        }
        for (String existing : existingTitles) {
            if (existing.equalsIgnoreCase(input.trim())) {
                return false;
            }
        }
        return true;
    }

    public static String getValidTitle(Scanner sc, String prompt, ArrayList<String> existingTitles) {
        String result = "";
        boolean isAgain = true;
        while (isAgain) {
            System.out.print(prompt);
            String input = sc.nextLine();
            if (isValidTitle(input, existingTitles)) {
                result = input.trim();
                isAgain = false;
            } else {
                System.out.println("Invalid title. Must contain a real word, be under 100 characters, and not already exist.");
            }
        }
        return result;
    }

    // ================= AUTHOR =================
    // Rules: not empty, max 50 characters, must contain at least
    // one real word (2+ letters in a row)
    public static boolean isValidAuthor(String input) {
        if (input == null || input.trim().isEmpty()) {
            return false;
        }
        if (input.length() > 50) {
            return false;
        }
        if (!input.matches(".*\\p{L}{2,}.*")) {
            return false;
        }
        return true;
    }

    public static String getValidAuthor(Scanner sc, String prompt) {
        String result = "";
        boolean isAgain = true;
        while (isAgain) {
            System.out.print(prompt);
            String input = sc.nextLine();
            if (isValidAuthor(input)) {
                result = input.trim();
                isAgain = false;
            } else {
                System.out.println("Invalid author. Must contain a real word and be under 50 characters.");
            }
        }
        return result;
    }

    public static boolean isValidYear(int input) {
        int currentYear = 2026;
        if (input < 1000 || input > currentYear) {
            return false;
        }
        return true;
    }

    public static int getValidYear(Scanner sc, String prompt) {
        int result = 0;
        boolean isAgain = true;
        while (isAgain) {
            System.out.print(prompt);
            String input = sc.nextLine();
            try {
                int year = Integer.parseInt(input.trim());
                if (isValidYear(year)) {
                    result = year;
                    isAgain = false;
                } else {
                    System.out.println("Invalid year. Must be between 1000 and 2026.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a whole number (e.g. 1999).");
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Add_Book adder = new Add_Book();
        Display_Book displayer = new Display_Book();
        Search_Book searcher = new Search_Book();

        System.out.println("=== WELCOME TO THE LIBRARY MANAGEMENT SYSTEM ===");

        boolean exit = true;
        while (exit) {
            System.out.println("[1]. Add Book(s)" +
                    "\n[2]. Open Digital Bookshelf" +
                    "\n[3]. Search Through Library" +
                    "\n[4]. Exit");
            System.out.print("Enter your choice: ");
            char choice = sc.next().charAt(0);
            System.out.println("================================================");


            switch (choice) {
                case '1':
                    try {
                        sc.nextLine();
                        String title = getValidTitle(sc, "Enter title: ", adder.getTitle());

                        String author = getValidAuthor(sc, "Enter author: ");

                        int year = getValidYear(sc, "Enter year: ");

                        adder.add(title, author, year);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case '2':
                    System.out.println("\n================= BOOK TITLES ==================");
                    System.out.println("================================================");
                    displayer.showAll(adder.getTitle(), adder.getAuthor(), adder.getYear());
                    System.out.println("================================================\n");
                    break;

                case '3':
                    System.out.println("\n================ SEARCH BOOK =================");
                    System.out.println("================================================");
                    System.out.print("Enter a book to search: ");
                    String titleToSearch = sc.nextLine();
                    searcher.search(adder.getTitle(), adder.getAuthor(), adder.getYear(), titleToSearch);
                    System.out.println("================================================\n");
                    break;
                case '4':
                    System.out.println("Exiting program...");
                    System.out.println("Thank you for using this service!");
                    exit = false;

                default:
                    System.out.println("Invalid choice, try again.");
            }
        }
        sc.close();
    }

}
