package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BirthdaylistModel implements Model {
    // Make the list immutable, so that it doesnt give references to the outside
    private final List<Person> list;

    public BirthdaylistModel() {
        list = new ArrayList();
    }

    // CREATE
    @Override
    public void createPerson(String name, LocalDate birthday) {
        list.add(new Person(name, birthday));
    }

    @Override
    public void createPerson(Person person) {
        list.add(new Person(person));
    }

    // READ
    @Override
    public int count() {
        return list.size();
    }
    
    @Override
    public String getName(int index){
        return list.get(index).getName();
    }
    
    @Override
    public LocalDate getBirthday(int index){
        return list.get(index).getBirthday(); // LocalDate is immutable
    }
    
    @Override
    public Person getPerson(int index) {
        return new Person(this.list.get(index));
    }

    @Override
    public List<Person> getPersonList() {
        List newList = new ArrayList();
        for(Person p : this.list){ // perhaps order is changed?
            newList.add(new Person(p));
        }
        return newList;
    }

    // UPDATE
    @Override
    public void updateName(int index, String newName) {
        this.list.get(index).setName(newName);
    }

    @Override
    public void updateBirthday(int index, LocalDate newBirthday) {
        this.list.get(index).setBirthday(newBirthday);
    }

    // DELETE
    @Override
    public void deletePerson(int index) {
        this.list.remove(index);
    }    
}
