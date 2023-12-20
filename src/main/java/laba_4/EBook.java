package laba_4;

import java.util.Objects;
import java.util.regex.Pattern;

/**
 * Клас, що представляє електронну книгу.
 */
public class EBook {
    private final String title;
    private final String author;
    private final String year;
    private final String format;

    /**
     * Конструктор класу EBook.
     *
     * @param title  Назва книги.
     * @param author Автор книги.
     * @param year   Рік випуску книги.
     * @param format Формат електронної книги.
     */
    private EBook(String title, String author, String year, String format) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.format = format;
    }

    // Регулярний вираз для перевірки назви книги
    private static final Pattern TITLE_PATTERN = Pattern.compile("^[a-zA-Z0-9 ]+$");

    // Регулярний вираз для перевірки автора книги
    private static final Pattern AUTHOR_PATTERN = Pattern.compile("^[a-zA-Z ]+$");

    // Регулярний вираз для перевірки формату електронної книги
    private static final Pattern FORMAT_PATTERN = Pattern.compile("^[a-zA-Z]+$");

    /**
     * Метод для отримання назви книги.
     *
     * @return Назва книги.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Метод для отримання автора книги.
     *
     * @return Автор книги.
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Метод для отримання року випуску книги.
     *
     * @return Рік випуску книги.
     */
    public String getYear() {
        return year;
    }

    /**
     * Метод для отримання формату електронної книги.
     *
     * @return Формат електронної книги.
     */
    public String getFormat() {
        return format;
    }

    /**
     * Перевизначений метод toString.
     *
     * @return Рядок з інформацією про електронну книгу.
     */
    @Override
    public String toString() {
        return "EBook{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", year=" + year +
                ", format='" + format + '\'' +
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
        EBook eBook = (EBook) o;
        return Objects.equals(title, eBook.title) &&
                Objects.equals(author, eBook.author) &&
                Objects.equals(year, eBook.year) &&
                Objects.equals(format, eBook.format);
    }

    /**
     * Перевизначений метод hashCode.
     *
     * @return Код хешу для об'єкта.
     */
    @Override
    public int hashCode() {
        return Objects.hash(title, author, year, format);
    }

    /**
     * Клас-будівельник для класу EBook.
     */
    public static class EBookBuilder {
        private String title;
        private String author;
        private String year;
        private String format;

        /**
         * Метод для встановлення назви книги.
         *
         * @param title Назва книги.
         * @return Поточний об'єкт EBookBuilder.
         */
        public EBookBuilder title(String title) {
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
         * @return Поточний об'єкт EBookBuilder.
         */
        public EBookBuilder author(String author) {
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
         * @return Поточний об'єкт EBookBuilder.
         */
        public EBookBuilder year(String year) {
            // Додайте власні правила валідації для року, якщо потрібно
            this.year = year;
            return this;
        }

        /**
         * Метод для встановлення формату електронної книги.
         *
         * @param format Формат електронної книги.
         * @return Поточний об'єкт EBookBuilder.
         */
        public EBookBuilder format(String format) {
            if (!FORMAT_PATTERN.matcher(format).matches()) {
                throw new IllegalArgumentException("Invalid format format");
            }
            this.format = format;
            return this;
        }

        /**
         * Метод для побудови об'єкта EBook на основі параметрів, встановлених в будівельнику.
         *
         * @return Новий екземпляр класу EBook.
         */
        public EBook build() {
            if (title == null || author == null || year == null || format == null) {
                throw new IllegalArgumentException("Title, author, year, and format are required fields");
            }
            return new EBook(title, author, year, format);
        }
    }
}
