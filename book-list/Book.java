import java.time.LocalDate;

public class Book {
    private String name;
    private int pageCount;
    private String author;
    private int publishYear;

    public Book(String name, int pageCount, String authorName, int publishYear) {
        this.name = name;
        this.pageCount = pageCount;
        this.author = authorName;
        this.publishYear = publishYear;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String authorName) {
        this.author = authorName;
    }

    public int getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(LocalDate publishDate) {
        this.publishYear = publishYear;
    }

    public void printDetail() {
        System.out.printf("- Book name: %-22s -> Author: %-15s -> Page: %-5d -> Pub.Year: %-4d\n", this.name, this.author, this.pageCount, this.publishYear);
    }
}
