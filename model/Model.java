package model;

import java.time.LocalDate;
import java.util.List;

public interface Model {

    // CREATE
    void createPerson(String name, LocalDate birthday);

    void createPerson(Person person);

    // READ
    int count();

    LocalDate getBirthday(int index);

    String getName(int index);

    Person getPerson(int index);

    List<Person> getPersonList();

    // UPDATE
    void updateBirthday(int index, LocalDate newBirthday);

    void updateName(int index, String newName);

    // DELETE
    void deletePerson(int index);
}
