package laba_2;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JsonEntitySerializer implements EntitySerializer {

    private final ObjectMapper objectMapper = new ObjectMapper();
    private String filePath = new String();

    // Constructor that takes filePath as a parameter
    public JsonEntitySerializer() {
        String filePath1;
        filePath1 = null;
        filePath1 = filePath;
        filePath = filePath1;
    }

    @Override
    public <T> void serialize(T entity, String filePath) throws IOException {
        objectMapper.writeValue(new File(filePath), entity);
    }

    @Override
    public <T> T deserialize(Class<T> entityType, String filePath) throws IOException {
        return objectMapper.readValue(new File(filePath), entityType);
    }
}
