/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author Stian
 */
@Entity
@Table(name = "Employees")
public class Employee_E implements Serializable {
    
    private int id;
    private int employeeId;
    private double hourlySalary;

    public Employee_E() {}
    
    public Employee_E(int empId, double salary) {
        employeeId = empId;
        hourlySalary = salary;
    }

    @Id
    @GeneratedValue(generator = "increment", strategy = IDENTITY)
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "EmployeeID")
    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    @Column(name = "Salary")
    public double getHourlySalary() {
        return hourlySalary;
    }

    public void setHourlySalary(double hourlySalary) {
        this.hourlySalary = hourlySalary;
    }
    
}
