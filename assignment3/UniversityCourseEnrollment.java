import java.util.ArrayList;

class Student {
    private String name;
    private int id;
    private ArrayList<Course> courses;

    public Student (String name, int id) {
        this.name = name;
        this.id = id;
        this.courses = new ArrayList<>();
    }

    public void enrollToCourse(Course course) {
        if (!courses.contains(course)) {
            courses.add(course);
            course.enrollStudent(this);
        }
    }

    public void dropFromCourse(Course course) {
        if (courses.contains(course)) {
            courses.remove(course);
            course.dropStudent(this);
        }
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}

class Course {
    private String courseName;
    private ArrayList<Student> students;

    public Course(String courseName) {
        this.courseName = courseName;
        this.students = new ArrayList<>();
    }

    public void enrollStudent(Student student) {
        if (!students.contains(student)) {
            students.add(student);
        }
    }

    public void dropStudent(Student student) {
        if (students.contains(student)) {
            students.remove(student);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Enrollment data for the course ").append(this.courseName.toUpperCase()).append("\n");
        sb.append("-----------------------------------------------------------------------------\n");
        int studentSize = this.students.size();
        if (studentSize == 0) {
            sb.append("NO STUDENT HAVE ENROLLED IN THIS COURSE");
        } else {
            for (Student student : this.students) {
                sb.append("Student Name: ").append(student.getName()).append("\n")
                  .append("Student ID: ").append(student.getId()).append("\n\n");
            }
        }
        sb.append("-----------------------------------------------------------------------------");
        return sb.toString();
    }
}

public class UniversityCourseEnrollment {
    public static void main(String[] args) {
        Student s1 = new Student("Krish", 1);
        Student s2 = new Student("Dhanraj", 12);
        Student s3 = new Student("Meet", 43);

        Course java = new Course("Java");
        Course ml = new Course("Machine Learning");
        Course da = new Course("Data Analytics");

        s1.enrollToCourse(java);
        s2.enrollToCourse(java);
        s3.enrollToCourse(ml);
        s1.enrollToCourse(da);
        s2.enrollToCourse(da);

        System.out.println(java);
        System.out.println(ml);
        System.out.println(da);

        s2.dropFromCourse(da);

        System.out.println("\nAfter Dhanraj drops Data Analytics:\n");
        System.out.println(da);
    }
}
