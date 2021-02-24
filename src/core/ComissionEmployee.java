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
public class ComissionEmployee extends Employee{
    private double bruteSells;
    private double comissionPercent;

    public ComissionEmployee(double bruteSells, double comissionPerncent, Date registrationDate, Date birthDate, String name) {
        super(registrationDate, birthDate, name);
        this.bruteSells = bruteSells;
        this.comissionPercent = comissionPerncent;
    }
    
    @Override
    public double getSalary() {
        return bruteSells*comissionPercent;
    }

    @Override
    public String toString() {
        return super.toString()+ "\nbruteSells=" + bruteSells + ",\ncomissionPerncent=" + comissionPercent;
    }
    
}
