package laba_3;

import laba_1.Book;
import laba_1.EBook;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BookService {

    // Метод сортування книг за роком видання
    public static void sortByYear(List<Book> books) {
        // Використовуємо Comparator для сортування за роком
        books.sort(Comparator.comparing(Book::getYear));
    }

    // Метод сортування електронних книг за форматом
    public static void sortByFormat(List<EBook> ebooks) {
        // Використовуємо Comparator для сортування за форматом
        ebooks.sort(Comparator.comparing(EBook::getFormat));
    }

    // Метод фільтрації книг за автором
    public static List<Book> filterByAuthor(List<Book> books, String author) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            // Враховуємо великі та малі літери при порівнянні автора
            if (book.getAuthor().equalsIgnoreCase(author)) {
                result.add(book);
            }
        }
        return result;
    }

    // Метод для обчислення середнього року видання електронних книг
    public static double averageYearOfEBooks(List<EBook> ebooks) {
        return ebooks.stream()
                .mapToDouble(ebook -> {
                    try {
                        // Перетворення року в ціле число
                        return Double.parseDouble(String.valueOf(ebook.getYear()));
                    } catch (NumberFormatException e) {
                        // Обробляємо випадок, коли рік не є дійсним числом
                        return 0.0;
                    }
                })
                .average()
                .orElse(0.0);
    }

    // Метод сортування книг за назвою
    public static void sortByName(List<Book> books) {
        // Використовуємо Comparator для сортування за назвою
        books.sort(Comparator.comparing(book -> book.getTitle() != null ? book.getTitle() : ""));
    }
}
