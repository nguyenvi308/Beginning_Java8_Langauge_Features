package Chapter1_Annotations;

import Chapter1_Annotations.enities.Employee;
import Chapter1_Annotations.enities.Manager;

/*
1. Chapter Objectives
    - What annotations are
    - How to declare annotations
    - How to use annotations
    - What meta-annotations are and how to use them
    - Commonly used annotations
    - How to access annotations at runtime
    - How to process annotations in source code
2. What annotations are
    // What annotations do and not do 
    - Example 1
    - Note for example 1
        + @Override: to indicate the programmer’s intention to override the method in the superclass.
        +  When the compiler comes across the @Override annotation, it makes sure that the
           method really overrides the method in the superclass. If the method annotated does not
           override a method in the superclass, the compiler generates an error
    - It lets you associate (or annotate) metadata (or notes) to the program elements in a Java program.
      The program elements may be a package, a class, an interface, a field of a class, a local variable, a method,
      a parameter of a method, an enum, an annotation, a type parameter in a generic type/method declaration, a type use,
    - You do need regular documentation. At the same time, you need a way to enforce your intent using a
      documentation-like mechanism. Your documentation should be available to the compiler and the runtime.
    - You can annotate any declaration or type use in a Java program. An annotation is used as a modifier in a declaration
      of a program element like any other modifiers (public, private, final, static, etc.).
    - Annotations are also available at runtime so that a program can read and use it for any purpose it wants
    - Example of using annotation:
        +  Enterprise JavaBeans (EJB), you know the pain of
           keeping all the interfaces and classes in sync and adding entries to XML configuration files
        +  JUnit version 4.0. JUnit is a unit test framework for Java programs. It uses annotations to mark methods that
           are test cases. Before that, you had to follow a naming convention for the test case methods
    - An annotation does not change the semantics (or meaning) of the program element that it annotates
    - Unlike a modifier, an annotation does not modify the meaning of the program elements. It acts like a decoration or
      a note for the program element that it annotates. which does not affect the way the annotated
      program element works -> the @Override annotation for the setSalary() method did not change the way the method works.


 */

public class Main {

    public static void main(String[] args) {

// Example 1 : Manager class extends Employee class and override setSalary() method

        Employee manager =  new Manager();
        int salary = 200;
        manager.setSalary(200);
        // Expected output
            // Call setSalary from Manager class but it from Employee class -> Employee Salary : 200.0
        // Really output
            // Fix that by add @Override in setSalary in Manager class

        // add @Override
            /*
            -> Error when compile -> println "Manager Salary : " correct version you want to call
            -> If remove @Override -> "Employee Salary :" not correct version you want to call
             */
    }
}
