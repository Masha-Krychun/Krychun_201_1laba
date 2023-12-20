package laba_4;

import java.util.Objects;
import java.util.regex.Pattern;

/**
 * Клас, що представляє книгу.
 */
public class Book implements Comparable<Book> {
    private String title;
    private String author;
    private int year;

    /**
     * Конструктор класу Book.
     *
     * @param title  Назва книги.
     * @param author Автор книги.
     * @param year   Рік випуску книги.
     */
    private Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    // Регулярний вираз для перевірки назви книги
    private static final Pattern TITLE_PATTERN = Pattern.compile("^[a-zA-Z0-9]+$");

    // Регулярний вираз для перевірки автора книги
    private static final Pattern AUTHOR_PATTERN = Pattern.compile("^[a-zA-Z]+$");


    /**
     * Метод для отримання будівельника (Builder) для класу Book.
     *
     * @return Новий екземпляр класу BookBuilder.
     */
    public static BookBuilder builder() {
        return new BookBuilder();
    }

    public int getYear() {
        return year;
    }

    /**
     * Перевизначений метод toString.
     *
     * @return Рядок з інформацією про книгу.
     */
    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", year=" + year +
                '}';
    }

    /**
     * Перевизначений метод equals.
     *
     * @param o Об'єкт для порівняння.
     * @return true, якщо об'єкти однакові, інакше false.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return year == book.year &&
                Objects.equals(title, book.title) &&
                Objects.equals(author, book.author);
    }

    /**
     * Перевизначений метод hashCode.
     *
     * @return Код хешу для об'єкта.
     */
    @Override
    public int hashCode() {
        return Objects.hash(title, author, year);
    }

    /**
     * Перевизначений метод compareTo для сортування за роком випуску.
     *
     * @param otherBook Інша книга для порівняння.
     * @return Від'ємне число, нуль або додатне число в залежності від порівняння.
     */
    @Override
    public int compareTo(Book otherBook) {
        return Integer.compare(this.year, otherBook.year);
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    /**
     * Клас-будівельник для класу Book.
     */
    public static class BookBuilder {
        private String title;
        private String author;
        private int year;

        /**
         * Метод для встановлення назви книги.
         *
         * @param title Назва книги.
         * @return Поточний об'єкт BookBuilder.
         */
        public BookBuilder title(String title) {
            if (!TITLE_PATTERN.matcher(title).matches()) {
                throw new IllegalArgumentException("Invalid title format");
            }
            this.title = title;
            return this;
        }

        /**
         * Метод для встановлення автора книги.
         *
         * @param author Автор книги.
         * @return Поточний об'єкт BookBuilder.
         */
        public BookBuilder author(String author) {
            if (!AUTHOR_PATTERN.matcher(author).matches()) {
                throw new IllegalArgumentException("Invalid author format");
            }
            this.author = author;
            return this;
        }

        /**
         * Метод для встановлення року випуску книги.
         *
         * @param year Рік випуску книги.
         * @return Поточний об'єкт BookBuilder.
         */
        public BookBuilder year(int year) {
            // Додайте власні правила валідації для року, якщо потрібно
            this.year = year;
            return this;
        }

        /**
         * Метод для побудови об'єкта Book на основі параметрів, встановлених в будівельнику.
         *
         * @return Новий екземпляр класу Book.
         */
        public Book build() {
            if (title == null || author == null) {
                throw new IllegalArgumentException("Title and author are required fields");
            }
            return new Book(title, author, year);
        }
    }
}
