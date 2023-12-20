package laba_1;

public class Test {
    public static void main(String[] args) {
        // Тест для класу Book
        testBook();

        // Тест для класу EBook
        testEBook();
    }

    public static void testBook() {
        // Створення екземпляра книги за допомогою будівельника
        Book book = Book.builder()
                .title("The Great Gatsby")
                .author("F. Scott Fitzgerald")
                .year(1925)
                .build();

        // Перевірка toString()
        System.out.println("Book toString():");
        System.out.println(book.toString());
    }

    public static void testEBook() {
        // Створення екземпляра електронної книги за допомогою будівельника
        EBook eBook = new EBookBuilder()
                .title("1984")
                .author("George Orwell")
                .year(1949)
                .format("PDF")
                .build();

        // Перевірка toString()
        System.out.println("\nEBook toString():");
        System.out.println(eBook.toString());
    }

    /**
     * Клас-будівельник для класу EBook.
     */
    public static class EBookBuilder {
        private String title;
        private String author;
        private int year;
        private String format;

        /**
         * Метод для встановлення назви книги.
         *
         * @param title Назва книги.
         * @return Поточний об'єкт EBookBuilder.
         */
        public EBookBuilder title(String title) {
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
            this.author = author;
            return this;
        }

        /**
         * Метод для встановлення року випуску книги.
         *
         * @param year Рік випуску книги.
         * @return Поточний об'єкт EBookBuilder.
         */
        public EBookBuilder year(int year) {
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
            this.format = format;
            return this;
        }

        /**
         * Метод для побудови об'єкта EBook на основі параметрів, встановлених в будівельнику.
         *
         * @return Новий екземпляр класу EBook.
         */
        public EBook build() {
            return new EBook(title, author, year, format);
        }
    }
}
