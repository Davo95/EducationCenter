package EducationCenter;

public class LessonStorage {
    private Lesson[] lessons;

    private int size;

    public LessonStorage(int capacity) {
        lessons = new Lesson[capacity];
    }

    public LessonStorage() {
        lessons = new Lesson[10];
    }


    public void addLesson(Lesson lesson) {
        if (size == lessons.length) {
            extend();
        }
        lessons[size] = lesson;
    }

    private void extend() {
       Lesson[] temp = new Lesson[lessons.length + 10];
        System.arraycopy(lessons, 0, temp, 0, lessons.length);
        lessons = temp;
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            if(lessons[i] != null){
                System.out.println(lessons[i]);
            }

        }
    }

    public Lesson[] getLessons() {
        return lessons;
    }

    public Lesson getByName(Lesson name) {
        for (int i = 0; i <size ; i++) {
            if (lessons[1].getName().equals(name)) {
                return lessons[i];
            }
        }
        return null;
    }

}

