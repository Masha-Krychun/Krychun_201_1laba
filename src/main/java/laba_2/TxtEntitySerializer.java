package laba_2;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class TxtEntitySerializer implements EntitySerializer {

    private URI filePath;

    @Override
    public <T> void serialize(T entity, String filePath) throws IOException {
        try {
            String serializedEntity = serializeToString(entity);
            Files.write(Path.of(filePath), List.of(serializedEntity), StandardOpenOption.CREATE);
        } catch (IOException e) {
            throw new IOException("Error during TXT serialization", e);
        }
    }

    @Override
    public <T> T deserialize(Class<T> entityType, String filePath) throws IOException {
        try {
            List<String> lines = Files.readAllLines(Path.of(String.valueOf(filePath)));
            String serializedEntity = String.join("", lines);
            return deserializeFromString(serializedEntity, entityType);
        } catch (IOException e) {
            throw new IOException("Error during TXT deserialization", e);
        }
    }

    private <T> String serializeToString(T entity) {
        return entity.toString();
    }

    private <T> T deserializeFromString(String serializedEntity, Class<T> entityType) {
        return (T) entityType.toString();
    }

    public void getClass(URI uri) {
    }
}
