package laba_1;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class EBook {
    private String title;
    private String author;
    private int year;
    private String format;

    // Конструктор для створення об'єкта EBook
    @JsonCreator
    public EBook(@JsonProperty("title") String title,
                 @JsonProperty("author") String author,
                 @JsonProperty("year") int year,
                 @JsonProperty("format") String format) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.format = format;
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

    // Геттер для формату електронної книги
    public String getFormat() {
        return format;
    }

    // Перевизначений метод toString для зручного виведення об'єкту EBook
    @Override
    public String toString() {
        return "EBook{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", year=" + year +
                ", format='" + format + '\'' +
                '}';
    }
}
