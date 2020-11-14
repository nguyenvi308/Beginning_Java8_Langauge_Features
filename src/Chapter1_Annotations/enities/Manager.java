package Chapter1_Annotations.enities;

import Chapter1_Annotations.enities.Employee;

public class Manager extends Employee {

     @Override
    public void setSalary(double salary) {
        System.out.println("Manager Salary : " + (salary + salary*1.5));
    }


}
