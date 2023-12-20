package laba_3;

import laba_1.Book;
import laba_1.EBook;

import java.util.List;

public interface BookServiceInterface {

    /**
     * Сортує список книг за роком випуску (використання Comparable).
     *
     * @param books Список книг для сортування.
     */
    void sortByYear(List<Book> books);

    /**
     * Сортує список електронних книг за форматом (використання Comparator).
     *
     * @param ebooks Список електронних книг для сортування.
     */
    void sortByFormat(List<EBook> ebooks);

    /**
     * Фільтрує список книг за автором (використання Stream API).
     *
     * @param books  Список книг для фільтрації.
     * @param author Автор для фільтрації.
     * @return Список книг, які мають вказаного автора.
     */
    List<Book> filterByAuthor(List<Book> books, String author);

    /**
     * Обчислює середній рік випуску електронних книг (використання Stream API).
     *
     * @param ebooks Список електронних книг для обчислення середнього року випуску.
     * @return Середній рік випуску електронних книг.
     */
    double averageYearOfEBooks(List<EBook> ebooks);
}
