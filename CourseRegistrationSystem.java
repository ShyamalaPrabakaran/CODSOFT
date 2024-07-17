import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class CourseRegistrationSystem {

    private static Scanner s = new Scanner(System.in);
    private static HashMap<String, Course> courses = new HashMap<>(); // Course Database
    private static HashMap<String, Student> students = new HashMap<>(); // Student Database

    public static void main(String[] args) {
        // Sample Courses (modify with your actual data)
        courses.put("CS101", new Course("CS101", "Introduction to Computer Science", "A foundational course...", 50, "MWF 10:00 AM"));
        courses.put("MATH202", new Course("MATH202", "Calculus II", "Differential and integral calculus...", 30, "TTH 2:00 PM"));

        int choice;
        do {
            System.out.println("\nCourse Registration System");
            System.out.println("1. Register as Student");
            System.out.println("2. Login as Student");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = s.nextInt();

            switch (choice) {
                case 1:
                    registerStudent();
                    break;
                case 2:
                    loginStudent();
                    break;
                case 3:
                    System.out.println("Exiting system...");
                    break;
                default:
                    System.out.println("Invalid Choice!");
            }
        } while (choice != 3);

        s.close();
    }

    private static void registerStudent() {
        System.out.println("\nStudent Registration:");
        System.out.print("Enter student ID: ");
        String Id = s.next();
        System.out.print("Enter student name: ");
        String Name = s.next();

        Student student = new Student(Id, Name);
        students.put(Id, student);
        System.out.println("Student registration successful!");
    }

    private static void loginStudent() {
        System.out.print("Enter your student ID: ");
        String studentId = s.next();

        Student student = students.get(studentId);
        if (student == null) {
            System.out.println("Student not found!");
            return;
        }

        System.out.println("\nStudent Menu");
        System.out.println("1. View Course Listing");
        System.out.println("2. Register for a Course");
        System.out.println("3. Drop a Course");
        System.out.println("4. View Registered Courses");
        System.out.print("Enter your choice: ");
        int choice = s.nextInt();

        switch (choice) {
            case 1:
                viewCourseListing();
                break;
            case 2:
                registerCourse(student);
                break;
            case 3:
                dropCourse(student);
                break;
            case 4:
                viewRegisteredCourses(student);
                break;
            default:
                System.out.println("Invalid Choice!");
        }
    }
    private static void viewCourseListing() {
        if (courses.isEmpty()) {
            System.out.println("No courses available!");
            return;
        }

        System.out.println("\nAvailable Courses:");
        for (Course course : courses.values()) {
            System.out.println(course); // Print course details
        }
    }

    private static void registerCourse(Student student) {
        viewCourseListing(); // Display courses

        System.out.print("Enter course code to register (or 'q' to quit): ");
        String courseCode = s.next();

        if (courseCode.equalsIgnoreCase("q")) {
            return;
        }

        Course course = courses.get(courseCode);
        if (course == null) {
            System.out.println("Invalid course code!");
            return;
        }

        if (course.isFull()) {
            System.out.println("Course is full!");
            return;
        }

        if (student.getRegisteredCourses().contains(course)) {
            System.out.println("You are already registered for this course!");
            return;
        }

        student.addCourse(course);
        course.addStudent(student);
        System.out.println("Successfully registered for " + course.getTitle());
    }

    private static void dropCourse(Student student) {
        if (student.getRegisteredCourses().isEmpty()) {
            System.out.println("You are not registered for any courses!");
            return;
        }
System.out.println("\nYour Registered Courses:");
        for (Course course : student.getRegisteredCourses()) {
            System.out.println(course);
        }
    }
    private static void viewRegisteredCourses(Student student) {
    System.out.println("\nYour Registered Courses:");
    if (student.getRegisteredCourses().isEmpty()) {
        System.out.println("You are not registered for any courses.");
        return;
    }

    for (Course course : student.getRegisteredCourses()) {
        System.out.println(course);
    }
}
}
class Course {
    private String code;
    private String title;
    private String description;
    private int capacity;
    private String schedule;
    private List<Student> registeredStudents;

    public Course(String code, String title, String description, int capacity, String schedule) {
        this.code = code;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.schedule = schedule;
        this.registeredStudents = new ArrayList<>();
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

    public List<Student> getRegisteredStudents() {
        return registeredStudents;
    }

    public boolean isFull() {
        return registeredStudents.size() >= capacity;
    }

    public void addStudent(Student student) {
        registeredStudents.add(student);
    }

    public void removeStudent(Student student) {
        registeredStudents.remove(student);
    }

    @Override
    public String toString() {
        return "Course Code: " + code + "\nTitle: " + title + "\nDescription: " + description
                + "\nCapacity: " + capacity + "\nSchedule: " + schedule;
    }
}
class Student {
    private String id;
    private String name;
    private List<Course> registeredCourses;

    public Student(String id, String name) {
        this.id = id;
        this.name = name;
        this.registeredCourses = new ArrayList<>();
    }
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Course> getRegisteredCourses() {
        return registeredCourses;
    }

    public boolean isRegisteredFor(Course course) {
        return registeredCourses.contains(course);
    }

    public void addCourse(Course course) {
        registeredCourses.add(course);
    }

    public void removeCourse(Course course) {
        registeredCourses.remove(course);
    }
}