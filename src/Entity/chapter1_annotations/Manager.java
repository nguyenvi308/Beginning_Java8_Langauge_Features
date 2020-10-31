package Entity.chapter1_annotations;

public class Manager extends Employee{

     @Override
    public void setSalary(double salary) {
        System.out.println("Manager Salary : " + (salary + salary*1.5));
    }


}
