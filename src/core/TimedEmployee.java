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
public class TimedEmployee extends Employee{
    private double salaryPerHour;
    private int workedHours;

    public TimedEmployee(double salaryPerHour, int workedHours, Date registrationDate, Date birthDate, String name) {
        super(registrationDate, birthDate, name);
        this.salaryPerHour = salaryPerHour;
        this.workedHours = workedHours;
    }
    
    @Override
    public double getSalary() {
        if(workedHours>40)  return salaryPerHour*(40+1.5*(workedHours-40));
        else                return salaryPerHour*workedHours;
    }

    @Override
    public String toString() {
        return super.toString() + ",\nSalario por hora=" + salaryPerHour + ",\nHoras trabajadas=" + workedHours;
    }
    
}
