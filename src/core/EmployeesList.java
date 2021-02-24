/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author LuisM45
 */
public class EmployeesList {
    private ArrayList<Employee> employeesList;

    public EmployeesList() {
        this.employeesList = new ArrayList<>();
    }
    public EmployeesList(ArrayList<Employee> employeesList) {
        this.employeesList = employeesList;
    }

    public void addEmployee(Employee employee){
        employeesList.add(employee);
    }

    public void sortByName(){
        employeesList.sort(Employee.compareName);
    }
    
    public void sortBySalary(){
        employeesList.sort(Employee.compareSalary);
    }
    
    public Employee getMostPaid(){
        return Collections.max(employeesList, Employee.compareSalary);
    }
    
    public Employee getLeastPaid(){
        return Collections.min(employeesList, Employee.compareSalary);
    }
    
    @Override
    public String toString() {
        StringBuilder sb= new StringBuilder();
        for(Employee employee: employeesList) sb.append(employee.toString()).append('\n');
        return sb.toString();
    }


    
}
