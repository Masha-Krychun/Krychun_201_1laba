package laba_2;

import laba_1.Book;

import java.io.IOException;

public class EntitySerialazationTest {

    public static void main(String[] args) {
        // Example instances to serialize and deserialize
        Book book = new Book("Mother", "John Doe", 2023);
        SampleEntity sampleEntity = new SampleEntity("John Doe", 25, "john.doe@example.com");

        // JSON serialization and deserialization
//        JsonEntitySerializer jsonEntitySerializer = new JsonEntitySerializer();
//
//        try {
//            // Serialize to JSON
//            jsonEntitySerializer.serialize(book, "entity");
////            jsonEntitySerializer.serialize(sampleEntity);
//
////            // Deserialize from JSON
//              Book deserializedBook = jsonEntitySerializer.deserialize(Book.class, "entity");
////            SampleEntity deserializedEntity = jsonEntitySerializer.deserialize(SampleEntity.class, "entity.json");
////
////            System.out.println("JSON Serialization and Deserialization:");
//            System.out.println("Deserialized Book: " + deserializedBook);
////            System.out.println("Deserialized Entity: " + deserializedEntity);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        // TXT serialization and deserialization
//       TxtEntitySerializer txtEntitySerializer = new TxtEntitySerializer();
//        txtEntitySerializer.getClass(URI.create("entity.txt"));
//
//            try {
            // Serialize to TXT
//           txtEntitySerializer.serialize(book, "entity_txt");
//            txtEntitySerializer.serialize(sampleEntity);

            // Deserialize from TXT
//            Book deserializedBook = (Book) txtEntitySerializer.deserialize("entity_txt", Book.class);
//            SampleEntity deserializedEntity = txtEntitySerializer.deserialize(SampleEntity.class, "entity.txt");
//
//            System.out.println("\nTXT Serialization and Deserialization:");
//            System.out.println("Deserialized Book: " + deserializedBook);
//            System.out.println("Deserialized Entity: " + deserializedEntity);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//
        // XML serialization and deserialization//
         XmlEntitySerializer xmlEntitySerializer = new XmlEntitySerializer();
//        xmlEntitySerializer.getClass("entity.xml");

        try {
            // Serialize to XML
            xmlEntitySerializer.serialize(book, "entity_xml" );
//            xmlEntitySerializer.serialize(sampleEntity);

            // Deserialize from XML
//            Book deserializedBook = xmlEntitySerializer.deserialize(Book.class, "entity_xml");
//            SampleEntity deserializedEntity = xmlEntitySerializer.deserialize(SampleEntity.class, "entity.xml");
//            System.out.println("\nXML Serialization and Deserialization:");
//            System.out.println("Deserialized Book: " + deserializedBook);
////            System.out.println("Deserialized Entity: " + deserializedEntity);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
