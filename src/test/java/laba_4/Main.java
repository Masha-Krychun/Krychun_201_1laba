package laba_4;

public class Main {
    public static void main(String[] args) {
        // Приклад для класу Book
        Book book = Book.builder()
                .title("Sea")
                .author("Katia Santiia ")
                .year(2023)
                .build();

        System.out.println("Book Information:");
        System.out.println(book);

        // Приклад для класу EBook
        EBook eBook = new EBook.EBookBuilder()
                .title("Sun")
                .author("Jane Doe")
                .year("2023")
                .format("PDF")
                .build();

        System.out.println("\nEBook Information:");
        System.out.println(eBook);
    }
}
