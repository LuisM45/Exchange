package core;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author LuisM45
 */
public abstract class Person {
    private Date birthDate;
    private String name;

    public Person(Date birthDate, String name) {
        this.birthDate = birthDate;
        this.name = name;
    }
    
    public void setPerson(Date birthDate, String name) {
        this.birthDate = birthDate;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    

    @Override
    public String toString() {
        return name + ":\nFecha de nacimiento=" + birthDate;
    }
    
}
