package laba_2;

import java.io.IOException;

public interface EntitySerializer {

    <T> void serialize(T entity, String filePath) throws IOException;

    <T> T deserialize(Class<T> entityType, String filePath) throws IOException;
}
