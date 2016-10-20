package net.hdavid.easylayout;

import java.util.Date;

/**
 * Created by hdavid on 10/20/16.
 */
public class PersonDTO {

    private String name;
    private Date birthDate;
    private int age;

    public PersonDTO() {

    }

    public PersonDTO(String name, Date birthDate, int age) {
        this.name = name;
        this.birthDate = birthDate;
        this.age = age;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

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
}
