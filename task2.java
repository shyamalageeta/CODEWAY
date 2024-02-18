import java.util.Scanner;

public class task2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of subjects: ");
        int numSubjects = sc.nextInt();// number of subjects
        //declare a variable to store total marks and initialize to zero
        int totalMarks = 0;
        //take input for each subject from user
        for (int i = 1; i <= numSubjects; i++) 
        {
            System.out.print("Enter marks obtained in subject " + i + ": ");
            int marks = sc.nextInt();
            totalMarks += marks;//add each subject's marks to total marks
        }
        //calculate average percentage by dividing total marks with number of subjects
        double averagePercentage = (double) totalMarks / numSubjects;
        char grade;
        //Calculate the grade based on the average percentage
        if (averagePercentage >= 90) {
            grade = 'A'; //90% or above gets an A
        } 
        else if (averagePercentage >= 80) {
            grade = 'B'; //80% or above gets a B
        } 
        else if (averagePercentage >= 70) {
            grade = 'C'; //70% or above gets a C
        } 
        else if (averagePercentage >= 60) {
            grade = 'D'; //60% or above gets a D
        } 
        else if (averagePercentage >= 50) {
            grade = 'E'; //50% or above gets an E
        } 
        else {
            grade = 'F'; //lesser gets an F
        }
        System.out.println("\nTotal Marks: " + totalMarks);//Print total marks
        System.out.println("Average Percentage: " + averagePercentage + "%");//Print average percentage
        System.out.println("Grade: " + grade);//Print grade   
        sc.close();
    }
}
