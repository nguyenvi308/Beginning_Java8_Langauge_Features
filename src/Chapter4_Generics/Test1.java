package Chapter4_Generics;

import Chapter4_Generics.Entity.Student;

public class Test1 {

    private Student student;

    public Test1(Student student) {
        this.student = student;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
