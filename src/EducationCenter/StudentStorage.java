package EducationCenter;

public class StudentStorage {
    private Student[] students;

    private int size;

    public StudentStorage(int capacity) {
        students = new Student[capacity];
    }

    public StudentStorage() {
        students = new Student[10];
    }


    public void add(Student student) {
        if (size == students.length) {
            extend();
        }
        students[size] = student;
        size += 1;
        for (int i = 0; i < students.length;i++){
            if(students[i] != null){
                System.out.println(students[i]);
            }

        }
    }

    private void extend() {
        Student[] temp = new Student[students.length + 10];
        System.arraycopy(students, 0, temp, 0, students.length);
        students = temp;
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            if(students != null){
                System.out.println(students[i]);
            }

        }
    }

    public Student[] getStudents() {
        return students;
    }

    public Student getByName(Student name) {
        for (int i = 0; i <size ; i++) {
            if (students[i].getLessons().equals(name)) {
                return students[i];
            }
        }
        return null;
    }

    public Student getStudentByName(String name) {
        for (int i = 0; i <size ; i++) {
            if (students[i].equals(name)) {
                return students[i];
            }
        }
        return null;
    }

}

