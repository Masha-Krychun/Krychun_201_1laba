package laba_5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {

    // JDBC URL, ім'я користувача та пароль сервера MySQL
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/book?useUnicode=true&characterEncoding=UTF-8";
    private static final String USERNAME = "masha";
    private static final String PASSWORD = "masha2109";

    // SQL-запити для створення таблиць
    private static final String CREATE_BOOK_TABLE =
            "CREATE TABLE IF NOT EXISTS books (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY," +
                    "title VARCHAR(255) NOT NULL," +
                    "author VARCHAR(255) NOT NULL," +
                    "year INT NOT NULL" +
                    ")";

    private static final String CREATE_EBOOK_TABLE =
            "CREATE TABLE IF NOT EXISTS ebooks (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY," +
                    "title VARCHAR(255) NOT NULL," +
                    "author VARCHAR(255) NOT NULL," +
                    "year INT NOT NULL," +
                    "format VARCHAR(50) NOT NULL" +
                    ")";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
             Statement statement = connection.createStatement()) {

            // Створення таблиці books
            statement.executeUpdate(CREATE_BOOK_TABLE);

            // Створення таблиці ebooks
            statement.executeUpdate(CREATE_EBOOK_TABLE);

            System.out.println("Таблиці успішно створено.");

        } catch (SQLException e) {
            // Обробка винятку відповідним чином, наприклад, логуванням чи виведенням повідомлення про помилку
            e.printStackTrace();
        }
    }
}
