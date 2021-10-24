package dto_entities;

/**
 *
 * @author Laura
 */
public class Book {

    private int code;
    private String title;
    private String author;
    private String publisher;
    private String subject;
    private String condition;

    public Book() {
    }

    public Book(int code, String title, String author, String publisher, String subject, String condition) {
        this.code = code;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.subject = subject;
        this.condition = condition;
    }

    //GETTERS 
    public int getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getSubject() {
        return subject;
    }

    public String getCondition() {
        return condition;
    }
    
    //SETTERS
    public void setCode(int code) {
        this.code = code;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }
    

}
