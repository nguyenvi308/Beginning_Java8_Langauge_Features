package Chapter4_Generics;

import Chapter4_Generics.Entity.Person;
import Chapter4_Generics.Entity.Student;

// Example 5
public class WrapperUtils {

    public void printDetails(Wrapper<Object> objectWrapper)
    {
        System.out.println(objectWrapper.getRef());
    }

    // Overload
    public void printDetails1(Wrapper<?> objectWrapper)
    {
        System.out.println(objectWrapper.getRef());
    }
    // Example 6
    public double sum(Wrapper<? extends Number> n1 , Wrapper<? extends  Number> n2)
    {

        Number num1 = n1.getRef();
        Number num2 = n2.getRef();
        double sum = num1.doubleValue() + num2.doubleValue();
        return sum;
    }
    // Example 7
    public static  <T> void  copy(Wrapper<T> source , Wrapper<? super T > dest)
    {
        T value = source.getRef();
        dest.setRef(value);
    }
    // Example 7  Version 2
    public  void copyLowerBound(Wrapper<Student> source , Wrapper<? super Student> dest)
    {
        Student d = source.getRef();
        dest.setRef(d); // super type of Double must be Double or Float
    }

    // Example 7 version 2
    public  void copyLowerBoundV1(Wrapper<Student> source , Wrapper<Person> dest)
    {
        Student d = source.getRef();
        dest.setRef(d); // super type of Double must be Double or Float
    }
}
