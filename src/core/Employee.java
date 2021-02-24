/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import core.Date;
import java.util.Comparator;

/**
 *
 * @author LuisM45
 */
public abstract class Employee extends Person{
    private Date entryDate;

    public Employee(Date registrationDate, Date birthDate, String name) {
        super(birthDate, name);
        this.entryDate = registrationDate;
    }
    
    public void setEmployee(Date registrationDate, Date birthDate, String name) {
        this.setPerson(birthDate, name);
        this.entryDate = registrationDate;
    }
    public abstract double getSalary();

    @Override
    public String toString() {
        return  super.toString()+"\nFecha de ingreso=" + entryDate+",\nSalario="+this.getSalary();
    }

    public static Comparator<Employee> compareName= (e, e1) -> {
        return e.getName().compareTo(e1.getName()); //To change body of generated lambdas, choose Tools | Templates.
    };
    
    public static Comparator<Employee> compareSalary= (e, e1) -> {
        return Double.compare(e.getSalary(),e1.getSalary()); //To change body of generated lambdas, choose Tools | Templates.
    };
    
    
    
}
