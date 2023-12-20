package laba_1;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "book")
public class Book {
    private String title;
    private String author;
    private int year;

    // Пустий конструктор для Jackson
    public Book() {
    }

    // Основний конструктор для створення об'єкта Book
    @JsonCreator
    public Book(@JsonProperty("title") String title,
                @JsonProperty("author") String author,
                @JsonProperty("year") int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public static BookBuilder builder() {
        return new BookBuilder();
    }

    public void setTitle(String title){
        this.title = title;
    }

    public void setAuthor(String author){
        this.author = author;
    }

    // Геттер для назви книги
    public String getTitle() {
        return title;
    }

    // Геттер для автора книги
    public String getAuthor() {
        return author;
    }

    // Геттер для року видання книги
    public int getYear() {
        return year;
    }

    // Перевизначений метод toString для зручного виведення об'єкту
    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", year=" + year +
                '}';
    }

    public static class BookBuilder {
        private String title;
        private String author;
        private int year;

        private BookBuilder() {
        }

        public BookBuilder title(String title) {
            this.title = title;
            return this;
        }

        public BookBuilder author(String author) {
            this.author = author;
            return this;
        }

        public BookBuilder year(int year) {
            this.year = year;
            return this;
        }

        public Book build() {
            return new Book(title, author, year);
        }
    }
}
