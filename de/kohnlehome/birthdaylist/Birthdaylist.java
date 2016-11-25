package de.kohnlehome.birthdaylist;

import de.kohnlehome.birthdaylist.model.BirthdaylistModel;
import de.kohnlehome.birthdaylist.model.Person;
import java.time.LocalDate;

public class Birthdaylist {

    public static void main(String[] args) {
        BirthdaylistModel model = new BirthdaylistModel();
        
        // Create
        model.createPerson("Franz Kohnle", LocalDate.of(1968,10,5));
        model.createPerson("Anna Arm", LocalDate.of(1970,10,1));
        
        // Read       
        for(Person p : model.getPersonList()){
            System.out.println("Name: " + p.getName() + ", " + p.getBirthday().toString());
        }
        
        System.out.println(model.getPerson(0).getName());
        System.out.println(model.getPerson(0).getBirthday().toString());
        
        // Update
        model.updateBirthday(1, LocalDate.of(1,2,3));
        model.updateName(1, "Sepp");
        
        // Delete
        model.deletePerson(1);
        
       
        
        // Read       
        for(Person p : model.getPersonList()){
            System.out.println("Name: " + p.getName() + ", " + p.getBirthday().toString());
        }
        
    }

}
