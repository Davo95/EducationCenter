package EducationCenter;

public class Lesson {
    private String name;
    private int duration;
    private double prace;
    private String lecturerName;

    public Lesson(String name, int duration, double prace, String lecturerName) {
        this.name = name;
        this.duration = duration;
        this.prace = prace;
        this.lecturerName = lecturerName;
    }

    public Lesson() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public double getPrace() {
        return prace;
    }

    public void setPrace(double prace) {
        this.prace = prace;
    }

    public String getLecturerName() {
        return lecturerName;
    }

    public void setLecturerName(String lecturerName) {
        this.lecturerName = lecturerName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Lesson lesson = (Lesson) o;

        if (duration != lesson.duration) return false;
        if (Double.compare(lesson.prace, prace) != 0) return false;
        if (name != null ? !name.equals(lesson.name) : lesson.name != null) return false;
        return lecturerName != null ? lecturerName.equals(lesson.lecturerName) : lesson.lecturerName == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name != null ? name.hashCode() : 0;
        result = 31 * result + duration;
        temp = Double.doubleToLongBits(prace);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (lecturerName != null ? lecturerName.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "name='" + name + '\'' +
                ", duration=" + duration +
                ", prace=" + prace +
                ", lecturerName='" + lecturerName + '\'' +
                '}';
    }
}
