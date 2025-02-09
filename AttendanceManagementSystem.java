import java.util.HashMap; 
import java.util.Map; 
import java.util.Scanner;

public class Student 
{ 
    String name; 
    String rollNumber; 
    boolean attendance;

    public Student(String name, String rollNumber) 
    {
    this.name = name;
    this.rollNumber = rollNumber;
    this.attendance = false;
    }
}


public class AttendanceManagementSystem 
{ 
    private Map<String, Student> students; 
    private Scanner scanner;

    public AttendanceManagementSystem() 
    {
        this.students = new HashMap<>();
        this.scanner = new Scanner(System.in);
    }

    public void run() 
    {
        while (true) 
        {
            System.out.println("Attendance Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Mark Attendance");
            System.out.println("3. View Attendance");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int option = Integer.parseInt(scanner.nextLine());

            switch (option) 
            {
                case 1:
                    addStudent();
                    break;
                case 2:
                    markAttendance();
                    break;
                case 3:
                    viewAttendance();
                    break;
                case 4:
                    deleteStudent();
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option. Please choose a valid option.");
        }
    }
}

private void addStudent() 
{
    System.out.print("Enter student name: ");
    String name = scanner.nextLine();
    System.out.print("Enter student roll number: ");
    String rollNumber = scanner.nextLine();

    if (students.containsKey(rollNumber)) 
    {
        System.out.println("Student with roll number " + rollNumber + " already exists.");
    } 
    else 
    {
        students.put(rollNumber, new Student(name, rollNumber));
        System.out.println("Student added successfully.");
    }
}

private void markAttendance() 
{
    System.out.print("Enter student roll number: ");
    String rollNumber = scanner.nextLine();

    if (students.containsKey(rollNumber)) 
    {
        Student student = students.get(rollNumber);
        student.attendance = true;
        System.out.println("Attendance marked for " + student.name);
    } 
    else 
    {
        System.out.println("Student with roll number " + rollNumber + " does not exist.");
    }
}

private void viewAttendance() 
{
    System.out.println("Attendance Report:");
    for (Student student : students.values()) 
    {
        System.out.println(student.name + " (" + student.rollNumber + "): " + (student.attendance ? "Present" : "Absent"));
    }
}

private void deleteStudent() 
{
    System.out.print("Enter student roll number: ");
    String rollNumber = scanner.nextLine();

    if (students.containsKey(rollNumber)) 
    {
        students.remove(rollNumber);
        System.out.println("Student deleted successfully.");
    } 
    else 
    {
        System.out.println("Student with roll number " + rollNumber + " does not exist.");
    }
}

public static void main(String[] args) 
{
    AttendanceManagementSystem attendanceManagementSystem = new AttendanceManagementSystem();
    attendanceManagementSystem.run();
}
}
