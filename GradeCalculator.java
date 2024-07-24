import java.util.Scanner;
class GradeCalculator {
    public static void main() {
        Scanner kb = new Scanner(System.in);
        System.out.println("Enter the total number of subjects");
        int numSubjects = kb.nextInt();
        kb.nextLine();
        String[] subjects = new String[numSubjects];
        int[] marks = new int[numSubjects];
        int totalMarks = 0;

        for (int i = 0; i < numSubjects; i++) 
        {
            System.out.println("Enter the name of subject "+(i+1));
            subjects[i]=kb.nextLine();
        }

        for (int i=0;i<numSubjects;i++) 
        {
            System.out.println("Enter the marks of "+subjects[i]);
            marks[i]=kb.nextInt();
            totalMarks+=marks[i];
        }
        double avgPercentage = (totalMarks / (double) numSubjects);
        String grade;
        if (avgPercentage >= 95) {
            grade="O";
        } else if (avgPercentage >= 90) {
            grade="A+";
        } else if (avgPercentage >= 85) {
            grade="A";
        } else if (avgPercentage >= 80) {
            grade="B+";
        } else if (avgPercentage >= 70) {
            grade="B";
        } else if (avgPercentage >= 60) {
            grade="C";
        } else if (avgPercentage >= 50) {
            grade="D";
        } else {
            grade="F";
        }
        System.out.println("Grade awarded: " + grade);
    }
}
