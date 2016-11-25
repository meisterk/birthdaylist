package de.kohnlehome.birthdaylist.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BirthdaylistModel {
    // Make the list immutable, so that it doesnt give references to the outside
    private final List<Person> list;

    public BirthdaylistModel() {
        list = new ArrayList();
    }

    // CREATE
    public void createPerson(String name, LocalDate birthday) {
        list.add(new Person(name, birthday));
    }

    public void createPerson(Person person) {
        list.add(new Person(person));
    }

    // READ
    public String getName(int index){
        return list.get(index).getName();
    }
    
    public LocalDate getBirthday(int index){
        return list.get(index).getBirthday(); // LocalDate is immutable
    }
    
    public Person getPerson(int index) {
        return new Person(this.list.get(index));
    }

    public List<Person> getPersonList() {
        List newList = new ArrayList();
        for(Person p : this.list){ // perhaps order is changed?
            newList.add(new Person(p));
        }
        return newList;
    }

    // UPDATE
    public void updateName(int index, String newName) {
        this.list.get(index).setName(newName);
    }

    public void updateBirthday(int index, LocalDate newBirthday) {
        this.list.get(index).setBirthday(newBirthday);
    }

    // DELETE
    public void deletePerson(int index) {
        this.list.remove(index);
    }
}
