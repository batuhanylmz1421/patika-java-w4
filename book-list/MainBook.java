import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MainBook {
    public static void main(String[] args) {

        // ArrayList initialising.
        ArrayList<Book> bookList = new ArrayList<>(10);
        bookList.add(new Book("Siddhartha", 81, "Hermann Hesse", 1922));
        bookList.add(new Book("Normal People", 273, "Sally Rooney", 2018));
        bookList.add(new Book("The Bell Jar", 294, "The Bell Jar", 1963));
        bookList.add(new Book("Frankenstein", 260, "Mary Shelley", 1818));
        bookList.add(new Book("The Giver", 208, "Lois Lowry", 1993));
        bookList.add(new Book("Animal Farm", 122, "George Orwell", 1945));
        bookList.add(new Book("The Little Prince", 96, "Antoine de Saint-Exupery", 1943));
        bookList.add(new Book("The Prince", 80, "Niccolo Machiavelli", 1532));
        bookList.add(new Book("A Christmas Carol", 68, "Charles Dickens", 1843));
        bookList.add(new Book("The Old Man & the Sea", 99, "Ernest Hemingway", 1952));

        // Mapping from arrayList.
        Map<String, String> bookMap = bookList.stream().collect(Collectors.toMap(book -> book.getName(), book -> book.getAuthor()));
        System.out.println("# Book List (Map):");
        bookMap.forEach((bookName, author) -> System.out.printf("- Book name: %-22s -> Author: %-15s\n", bookName, author));

        System.out.println("------------------------------------------------------------------------------------------------------");

        // Books that page count is over 100.
        System.out.println("# Book List ( Page count > 100):");
        List<Book> newBookList = bookList.stream().filter(book -> book.getPageCount() > 100).collect(Collectors.toList());
        newBookList.stream().forEach(book -> book.printDetail());
    }
}