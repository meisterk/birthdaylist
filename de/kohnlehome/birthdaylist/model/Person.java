package de.kohnlehome.birthdaylist.model;

import java.time.LocalDate;

public class Person {

    private String name;
    private LocalDate birthday;

    public Person(String name, LocalDate birthday) {
        this.name = name;
        this.birthday = birthday;
    }
    
    public Person(Person person){
        this.name = person.name;
        this.birthday = person.birthday;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setName(String newName) {
        this.name = newName;
     }

   public void setBirthday(LocalDate newBirthday) {
        this.birthday = newBirthday;
     }

}
