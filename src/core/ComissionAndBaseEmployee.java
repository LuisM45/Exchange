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
public class ComissionAndBaseEmployee extends ComissionEmployee{
    private double baseSalary;

    public ComissionAndBaseEmployee(double baseSalary, double bruteSells, double comissionPerncent, Date registrationDate, Date birthDate, String name) {
        super(bruteSells, comissionPerncent, registrationDate, birthDate, name);
        this.baseSalary = baseSalary;
    }

    @Override
    public double getSalary(){
        return baseSalary+super.getSalary();
    }
    
    @Override
    public String toString() {
        return super.toString() + "\nSalario Base=" + baseSalary;
    }
    
}
