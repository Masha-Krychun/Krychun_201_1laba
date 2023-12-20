package laba_3;

import laba_1.Book;
import laba_1.EBook;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Створення списку книг
        List<Book> books = new ArrayList<>();
        books.add(Book.builder().title("Анна Кареніна").author("Лев Толстой").year(1877).build());
        books.add(Book.builder().title("1984").author("Джордж Оруелл").year(1949).build());
        books.add(Book.builder().title("Майстер і Маргарита").author("Михайло Булгаков").year(1966).build());

        // Сортування за роком випуску
        BookService.sortByYear(books);
        System.out.println("Список книг за роком випуску:");
        books.forEach(System.out::println);

        // Створення списку електронних книг
        List<EBook> ebooks = new ArrayList<>();
        ebooks.add(new EBook("Електронна книга 1", "Автор 1", 2000, "PDF"));
        ebooks.add(new EBook("Електронна книга 2", "Автор 2", 2010, "EPUB"));
        ebooks.add(new EBook("Електронна книга 3", "Автор 3", 2020, "MOBI"));

        // Сортування електронних книг за форматом
        BookService.sortByFormat(ebooks);
        System.out.println("\nСписок електронних книг за форматом:");
        ebooks.forEach(System.out::println);

        // Відфільтрувати книги за автором
        String authorToFilter = "Лев Толстой";
        List<Book> filteredBooks = BookService.filterByAuthor(books, authorToFilter);
        System.out.println("\nКниги автора " + authorToFilter + ":");
        filteredBooks.forEach(System.out::println);

        // Середній рік випуску електронних книг
        double averageYear = BookService.averageYearOfEBooks(ebooks);
        System.out.println("\nСередній рік випуску електронних книг: " + averageYear);

        // Додатковий метод для сортування за назвою
        BookService.sortByName(books);
        System.out.println("\nСписок книг за назвою:");
        books.forEach(System.out::println);
    }
}
