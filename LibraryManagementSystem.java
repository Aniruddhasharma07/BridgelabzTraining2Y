import java.util.NoSuchElementException;
import java.util.Scanner;
class Book {
    int bookId;
    String title;
    String author;
    double price;
    public Book(int bookId, String title, String author, double price) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.price = price;
    }
}
public class LibraryManagementSystem {
    public static int removeDuplicates(Book[] books, int n) {
        if (books == null || n == 0) return 0;
        int j = 0;
        for (int i = 1; i < n; i++) {
            if (books[i].bookId != books[j].bookId) {
                j++;
                if (j != i) books[j] = books[i]; // skip pointless self-copy
            }
        }
        int m = j + 1;
        for (int i = m; i < n; i++) {
            books[i] = null;
        }
        return m;
    }
    private static boolean containsIgnoreCase(String text, String query) {
        int qLen = query.length();
        int limit = text.length() - qLen;
        for (int i = 0; i <= limit; i++) {
            if (text.regionMatches(true, i, query, 0, qLen)) return true;
        }
        return false;
    }
    public static void searchByTitle(Book[] books, int count, String query) {
        System.out.println("Search Results for '" + query + "':");
        boolean found = false;
        for (int i = 0; i < count; i++) {
            if (containsIgnoreCase(books[i].title, query)) {
                System.out.println("- Found: [" + books[i].bookId + "] "
                        + books[i].title + " (Rs. " + books[i].price + ")");
                found = true;
            }
        }
        if (!found) {
            System.out.println("- No matching books found.");
        }
    }
    public static void sortByPrice(Book[] books, int count) {
        int swaps = 0;
        for (int i = 0; i < count - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < count; j++) {
                if (books[j].price < books[minIdx].price) {
                    minIdx = j;
                }
            }
            if (minIdx != i) { // only count real swaps
                Book temp = books[i];
                books[i] = books[minIdx];
                books[minIdx] = temp;
                swaps++;
            }
        }
        System.out.println("Books Sorted by Price:");
        for (int i = 0; i < count; i++) {
            System.out.println((i + 1) + ". [" + books[i].bookId + "] "
                    + books[i].title + " - Rs. " + books[i].price);
        }
        System.out.println("Total Swaps: " + swaps);
    }
    public static int searchByPrice(Book[] books, int count, double targetPrice) {
        final double EPS = 1e-9; // safe comparison for doubles
        int low = 0, high = count - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            double p = books[mid].price;
            if (Math.abs(p - targetPrice) < EPS) {
                return mid;
            } else if (p < targetPrice) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
    public static int minBooksForTargetCost(Book[] books, int count, double targetCost) {
        int minLen = Integer.MAX_VALUE;
        int left = 0;
        double currentSum = 0;
        for (int right = 0; right < count; right++) {
            currentSum += books[right].price;
            while (currentSum >= targetCost && left <= right) {
                int len = right - left + 1;
                if (len < minLen) minLen = len;
                if (minLen == 1) return 1; // cannot do better than one book
                currentSum -= books[left++].price;
            }
        }
        return (minLen == Integer.MAX_VALUE) ? 0 : minLen;
    }
    private static void printBooks(Book[] books, int count) {
        for (int i = 0; i < count; i++) {
            System.out.println("[" + books[i].bookId + "] " + books[i].title
                    + " - Rs. " + books[i].price);
        }
    }
    private static Book[] loadSampleBooks() {
        return new Book[] {
                new Book(101, "Data Structures",   "Mark",   400.0),
                new Book(101, "Data Structures",   "Mark",   400.0), // duplicate scan
                new Book(102, "Java Basics",       "James",  300.0),
                new Book(103, "Python Guide",      "Guido",  600.0),
                new Book(104, "Database Systems",  "Raghu",  500.0),
                new Book(105, "Computer Networks", "Andrew", 700.0)
        };
    }
    private static double readDouble(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = sc.nextLine().trim();
            try {
                return Double.parseDouble(line);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }
    private static void runMenu() {
        Scanner sc = new Scanner(System.in);
        Book[] books = loadSampleBooks();
        int count = books.length;
        boolean deduped = false;
        boolean sortedByPrice = false;
        System.out.println("=== Smart Library Management System ===");
        System.out.println("Loaded " + count + " scanned book records.");
        try {
            while (true) {
                System.out.println();
                System.out.println("1. Remove duplicate records");
                System.out.println("2. Search books by title");
                System.out.println("3. Sort books by price (cheapest first)");
                System.out.println("4. Search for a book by exact price");
                System.out.println("5. Find minimum consecutive books for a grant amount");
                System.out.println("6. Show all books");
                System.out.println("0. Exit");
                System.out.print("Choose an option: ");
                String choice = sc.nextLine().trim();
                switch (choice) {
                    case "1": {
                        if (deduped) {
                            System.out.println("Duplicates have already been removed.");
                        } else {
                            int before = count;
                            count = removeDuplicates(books, count);
                            deduped = true;
                            System.out.println("Removed " + (before - count)
                                    + " duplicate record(s). Unique books: " + count);
                            printBooks(books, count);
                        }
                        break;
                    }
                    case "2": {
                        System.out.print("Enter part of the title: ");
                        String query = sc.nextLine().trim();
                        if (query.isEmpty()) {
                            System.out.println("Search word cannot be empty.");
                        } else {
                            searchByTitle(books, count, query);
                        }
                        break;
                    }
                    case "3": {
                        if (!deduped) {
                            System.out.println("Please remove duplicates first (option 1).");
                        } else {
                            sortByPrice(books, count);
                            sortedByPrice = true;
                        }
                        break;
                    }
                    case "4": {
                        if (!sortedByPrice) {
                            System.out.println("Books must be sorted by price first (option 3).");
                        } else {
                            double target = readDouble(sc, "Enter the exact price to search for: Rs. ");
                            System.out.println("Searching for Price Rs. " + target + "...");
                            int idx = searchByPrice(books, count, target);
                            if (idx != -1) {
                                System.out.println("Result: Book found at index " + idx + ": ["
                                        + books[idx].bookId + "] " + books[idx].title
                                        + " (Rs. " + books[idx].price + ")");
                            } else {
                                System.out.println("Result: No book found with that price.");
                            }
                        }
                        break;
                    }
                    case "5": {
                        double s = readDouble(sc, "Enter the research grant amount (Rs.): ");
                        if (s <= 0) {
                            System.out.println("Amount must be greater than 0.");
                        } else {
                            System.out.println("Checking consecutive books in their current order...");
                            int min = minBooksForTargetCost(books, count, s);
                            if (min == 0) {
                                System.out.println("No group of consecutive books adds up to Rs. "
                                        + s + " or more.");
                            } else {
                                System.out.println("Minimum Consecutive Books Needed: " + min);
                            }
                        }
                        break;
                    }
                    case "6": {
                        printBooks(books, count);
                        break;
                    }
                    case "0": {
                        System.out.println("Goodbye!");
                        return;
                    }
                    default:
                        System.out.println("Invalid option. Please choose 0-6.");
                }
            }
        } catch (NoSuchElementException e) {
            System.out.println("\nInput closed. Goodbye!");
        }
    }
    private static void runSampleDemo() {
        Book[] books = loadSampleBooks();
        System.out.println("=== Task 1: Remove Duplicates ===");
        int count = removeDuplicates(books, books.length);
        System.out.println("Unique Books Count: " + count);
        System.out.println("Book List:");
        printBooks(books, count);
        System.out.println("\n=== Task 2: Search by Title ===");
        searchByTitle(books, count, "data");
        System.out.println("\n=== Task 3: Sort by Price ===");
        sortByPrice(books, count);
        System.out.println("\n=== Task 4: Search by Price ===");
        double targetPrice = 500.0;
        System.out.println("Searching for Price Rs. " + targetPrice + "...");
        int idx = searchByPrice(books, count, targetPrice);
        if (idx != -1) {
            System.out.println("Result: Book found at index " + idx + ": ["
                    + books[idx].bookId + "] " + books[idx].title
                    + " (Rs. " + books[idx].price + ")");
        } else {
            System.out.println("Result: No book found with that price.");
        }
        System.out.println("\n=== Task 5: Minimum Consecutive Books ===");
        double S = 1000.0;
        System.out.println("Finding minimum consecutive books whose total price >= Rs. " + S + "...");
        System.out.println("Minimum Consecutive Books Needed: "
                + minBooksForTargetCost(books, count, S));
    }
    public static void main(String[] args) {
        if (args.length > 0 && args[0].equalsIgnoreCase("demo")) {
            runSampleDemo();
        } else {
            runMenu();
        }
    }
}