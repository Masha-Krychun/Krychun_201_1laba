package laba_2;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;

public class XmlEntitySerializer implements EntitySerializer {

    private String filePath;

    @Override
    public <T> void  serialize(T entity, String filePath) throws IOException {
        try {
            JAXBContext context = JAXBContext.newInstance(entity.getClass());
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(entity, new File(filePath));
        } catch (JAXBException e) {
            throw new IOException("Error during XML serialization", e);
        }
    }

    @Override
    public <T> T deserialize(Class<T> entityType, String filePath) throws IOException {
        try {
            File file = new File(String.valueOf(filePath));
            if (!file.exists()) {
                System.out.println("File " + filePath + " does not exist.");
            }

            JAXBContext context = JAXBContext.newInstance(entityType);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            return (T) unmarshaller.unmarshal(new File(filePath));
        } catch (JAXBException e) {
            throw new IOException("Error during XML deserialization", e);
        }
    }

    public void getClass(String s) {
    }

}
