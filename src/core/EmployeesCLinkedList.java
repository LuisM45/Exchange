/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.function.Predicate;
import java.util.LinkedList;//Ahora si el de java

/**
 *
 * @author LuisM45
 */
public class EmployeesCLinkedList {
    private LinkedList<Employee> employeesList;

    public EmployeesCLinkedList() {
        this.employeesList = new LinkedList<>();
    }
    
    public EmployeesCLinkedList(Collection<Employee> employeesList) {
        this.employeesList = new LinkedList<>();
        this.employeesList.addAll(employeesList);
    }
    
    public void addStartEmployee(Employee employee){
        employeesList.add(0,employee);
    }
    public void addEndEmployee(Employee employee){
        employeesList.add(employee);
    }
    public void addOrderedByNameEmployee(Employee employee){
        Comparator<Employee> comparatorEmployee = (t, t1) -> {
            return t.getName().compareToIgnoreCase(t1.getName()); //To change body of generated lambdas, choose Tools | Templates.
        };
        
        int size = employeesList.size();
        if(size==0)employeesList.add(employee);
        for(int i = 0; i<employeesList.size();i++){
            if(comparatorEmployee.compare(employee,employeesList.get(i))<0){ employeesList.add(i, employee);break;}
            i++;
        }
        if(size==employeesList.size())employeesList.add(employee);
    }
    
    public boolean deleteEmployee(String name){
        Predicate<Employee> predicateEmployee = (t) -> {
            return t.getName().equalsIgnoreCase(name); //To change body of generated lambdas, choose Tools | Templates.
        };
        
        return employeesList.removeIf(predicateEmployee);
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
        for(Employee employee: employeesList) sb.append("Empleado ").append(employee.toString()).append("\n\n");
        return sb.toString();
    }
}
