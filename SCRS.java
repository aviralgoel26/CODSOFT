import java.util.Scanner;
public class SCRS {
    private static final int max = 6;
    private static String[] registeredCourses = new String[max];
    private static int registeredCount = 0;

    public static void main() 
    {
        Scanner kb = new Scanner(System.in);
        System.out.println("Please register yourself");
        System.out.print("Enter your Name: ");
        String name = kb.nextLine();
        System.out.print("Enter your ID: ");
        String ID = kb.nextLine();
        System.out.println("Successfully Registered!!!");
        System.out.println();
        while (true) 
        {
            menu(name,ID);
        }
    }
    public static void menu(String name, String ID) {
        Scanner kb = new Scanner(System.in);
        System.out.println("\n--- MENU ---");
        System.out.println("1. My Information");
        System.out.println("2. Courses List");
        System.out.println("3. Drop Course");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
        int input = kb.nextInt();
        kb.nextLine(); 
        switch (input) {
            case 1:
                Information(name, ID);
                break;
            case 2:
                CourseList(name, ID);
                break;
            case 3:
                dropCourse(name, ID);
                break;
            case 4:
                System.out.println("Exiting...");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice, please try again.");
        }
    }
    public static void Information(String name, String ID) {
        System.out.println("\n--- STUDENT INFORMATION ---");
        System.out.println("Name: " + name);
        System.out.println("ID: " + ID);
        System.out.print("Registered Courses: ");
        for (String course : registeredCourses) {
            if (course != null) {
                System.out.print(course + " ");
            }
        }
        System.out.println();
    }

    public static void CourseList(String name, String ID) {
        Scanner kb = new Scanner(System.in);
        String[][] courses = {
            {"CSE101", "C/C++", "100", "January-March"},
            {"PYT101", "Python", "50", "March-May"},
            {"JAV101", "Java", "70", "May-July"},
            {"HTM101", "HTML & CSS", "80", "July-September"},
            {"JAS101", "JavaScript", "60", "September-November"},
            {"DBMS101", "SQL/PLSQL", "110", "November-January"}
        };

        System.out.println("\n--- AVAILABLE COURSES ---");
        for (String[] course : courses) {
            System.out.println("Course Code: " + course[0] + ", Course Title: " + course[1] +
                ", Available Slots: " + course[2] + ", Schedule: " + course[3]);
        }

        System.out.print("Do you want to register any course? (YES/NO): ");
        String response = kb.nextLine();
        if (response.equalsIgnoreCase("YES")) {
            registerCourses(name, ID);
        }
    }

    public static void registerCourses(String name, String ID) {
        Scanner kb = new Scanner(System.in);
        System.out.println("\nEnter the course codes for registration (up to 6 courses):");
        for (int i = registeredCount; i < max; i++) {
            System.out.print("Enter course code (or type 'done' to finish): ");
            String courseCode = kb.nextLine();
            if (courseCode.equalsIgnoreCase("done")) {
                break;
            }
            registeredCourses[i] = courseCode;
            registeredCount++;
        }

        System.out.println("Courses Registered Successfully");
    }
    public static void dropCourse(String name, String ID) {
        if (registeredCount == 0) {
            System.out.println("No courses to drop.");
            return;
        }
        Scanner kb = new Scanner(System.in);
        System.out.print("Enter the course code to drop the course: ");
        String courseCode = kb.nextLine();
        boolean courseFound = false;
        for (int i = 0; i < registeredCourses.length; i++) {
            if (courseCode.equals(registeredCourses[i])) {
                registeredCourses[i] = null;
                courseFound = true;
                registeredCount--;
                System.out.println("Course successfully dropped.");
                break;
            }
        }
        if (!courseFound) {
            System.out.println("Course not found in your registered courses.");
        }
    }
}
