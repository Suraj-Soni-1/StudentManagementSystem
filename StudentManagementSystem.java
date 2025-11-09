import java.util.*;

class Student {
    private int id;
    private String name;
    private String course;
    private double fee;

    public Student(int id, String name, String course, double fee) {
        this.id = id;
        this.name = name;
        this.course = course;
        this.fee = fee;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCourse() {
        return course;
    }

    public double getFee() {
        return fee;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    @Override
    public String toString() {
        return "Student ID: " + id +
               ", Name: " + name +
               ", Course: " + course +
               ", Fee: " + fee;
    }
}

public class StudentManagementSystem {
    private static Map<Integer, Student> students = new HashMap<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n===== Online Student Information Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> viewAllStudents();
                case 3 -> searchStudent();
                case 4 -> updateStudent();
                case 5 -> deleteStudent();
                case 6 -> System.out.println("Exiting... Thank you!");
                default -> System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 6);
    }

    private static void addStudent() {
        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();
        sc.nextLine(); // consume newline
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Course: ");
        String course = sc.nextLine();
        System.out.print("Enter Fee: ");
        double fee = sc.nextDouble();

        students.put(id, new Student(id, name, course, fee));
        System.out.println("✅ Student added successfully!");
    }

    private static void viewAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
            return;
        }
        System.out.println("\n--- Student List ---");
        for (Student s : students.values()) {
            System.out.println(s);
        }
    }

    private static void searchStudent() {
        System.out.print("Enter Student ID to search: ");
        int id = sc.nextInt();
        Student s = students.get(id);
        if (s != null)
            System.out.println(s);
        else
            System.out.println("Student not found!");
    }

    private static void updateStudent() {
        System.out.print("Enter Student ID to update: ");
        int id = sc.nextInt();
        Student s = students.get(id);
        if (s != null) {
            sc.nextLine(); // consume newline
            System.out.print("Enter new Name: ");
            s.setName(sc.nextLine());
            System.out.print("Enter new Course: ");
            s.setCourse(sc.nextLine());
            System.out.print("Enter new Fee: ");
            s.setFee(sc.nextDouble());
            System.out.println("✅ Student updated successfully!");
        } else {
            System.out.println("Student not found!");
        }
    }

    private static void deleteStudent() {
        System.out.print("Enter Student ID to delete: ");
        int id = sc.nextInt();
        if (students.remove(id) != null)
            System.out.println("✅ Student deleted successfully!");
        else
            System.out.println("Student not found!");
    }
}
