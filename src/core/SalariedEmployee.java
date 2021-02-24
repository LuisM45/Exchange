/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

/**
 *
 * @author LuisM45
 */
public class SalariedEmployee extends Employee{
    private double weeklySalary;

    public SalariedEmployee(double weeklySalary, Date registrationDate, Date birthDate, String name) {
        super(registrationDate, birthDate, name);
        this.weeklySalary = weeklySalary;
    }

    @Override
    public double getSalary() {
        return weeklySalary;
    }

    @Override
    public String toString() {
        return super.toString()+"\nSalario semanal=" + weeklySalary;
    }
    
}
