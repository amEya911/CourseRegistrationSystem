import java.util.ArrayList;
import java.util.List;

class Course {
    private String code;
    private String title;
    private String description;
    private int capacity;
    private String schedule;

    public Course(String code, String title, String description, int capacity, String schedule) {
        this.code = code;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.schedule = schedule;
    }

    public String getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getSchedule() {
        return schedule;
    }

    public String toString() {
        return "Course Code: " + code + "\nTitle: " + title + "\nDescription: " + description
                + "\nCapacity: " + capacity + "\nSchedule: " + schedule + "\n";
    }
}

class Student {
    private int studentId;
    private String name;
    private List<Course> registeredCourses;

    public Student(int studentId, String name) {
        this.studentId = studentId;
        this.name = name;
        this.registeredCourses = new ArrayList<>();
    }

    public int getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public List<Course> getRegisteredCourses() {
        return registeredCourses;
    }

    public void registerCourse(Course course) {
        if (registeredCourses.size() < 3) {
            registeredCourses.add(course);
            System.out.println(name + " registered for the course: " + course.getTitle());
        } else {
            System.out.println("Sorry, " + name + ". You can only register for up to 3 courses.");
        }
    }

    public void dropCourse(Course course) {
        if (registeredCourses.contains(course)) {
            registeredCourses.remove(course);
            System.out.println(name + " dropped the course: " + course.getTitle());
        } else {
            System.out.println(name + " is not registered for the course: " + course.getTitle());
        }
    }

    public String toString() {
        return "Student ID: " + studentId + "\nName: " + name + "\nRegistered Courses: " + registeredCourses.size() + "\n";
    }
}

public class CourseRegistrationSystem {
    public static void main(String[] args) {
        // Sample courses
        Course mathCourse = new Course("MATH101", "Introduction to Mathematics", "Basic math concepts", 29, "10:00 AM");
        Course javaCourse = new Course("COMP202", "Java Programming", "Fundamentals of Java programming", 23, "2:00 PM");
        Course bioCourse = new Course("BIOL301", "Biology", "Introduction to biology", 19, "1:30 PM");

        // Sample students
        Student student1 = new Student(1, "Nikhil Kamat");
        Student student2 = new Student(2, "Sundar Pichai");

        // Display available courses
        displayCourseListing(mathCourse, javaCourse, bioCourse);

        // Register students for courses
        student1.registerCourse(mathCourse);
        student1.registerCourse(javaCourse);
        student1.registerCourse(bioCourse);

        student2.registerCourse(javaCourse);
        student2.registerCourse(bioCourse);

        // Display student information
        displayStudentInformation(student1, student2);

        // Drop a course
        student1.dropCourse(mathCourse);

        // Display updated student information
        displayStudentInformation(student1, student2);
    }

    private static void displayCourseListing(Course... courses) {
        System.out.println("Available Courses:\n");
        for (Course course : courses) {
            System.out.println(course);
        }
    }

    private static void displayStudentInformation(Student... students) {
        System.out.println("Student Information:\n");
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
