package laba_2;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement
public class SampleEntity implements Comparable<SampleEntity>, Serializable {
    private String name;
    private int age;
    private String email;

    public SampleEntity() {
    }

    public SampleEntity(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    // Getters and setters for fields
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int compareTo(SampleEntity other) {
        // Implement comparison logic based on your requirements
        // For example, let's compare by name
        return this.name.compareTo(other.name);
    }

    @Override
    public String toString() {
        return "SampleEntity{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }
}
