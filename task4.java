import java.util.Scanner;
public class task4
 {
    private static final int NUM_QUESTIONS = 10;//10 questions
    private static final int QUESTION_TIME_LIMIT_SECONDS = 10;//10 seconds time limit for each question
    private static final String[][] questions = {//list of questions
            {"What is the capital of India?", "A. New Delhi", "B. Mumbai", "C. Kolkata", "D. Chennai", "A"},
            {"Which river is known as the lifeline of India?", "A. Ganges", "B. Yamuna", "C. Brahmaputra", "D. Godavari", "A"},
            {"Who is known as the Father of the Nation in India?", "A. Mahatma Gandhi", "B. Jawaharlal Nehru", "C. Sardar Vallabhbhai Patel", "D. Bhagat Singh", "A"},
            {"Which is the national animal of India?", "A. Lion", "B. Tiger", "C. Elephant", "D. Leopard", "B"},
            {"What is the national flower of India?", "A. Lotus", "B. Rose", "C. Jasmine", "D. Sunflower", "A"},
            {"Which city is known as the 'Pink City' of India?", "A. Jaipur", "B. Jodhpur", "C. Udaipur", "D. Ajmer", "A"},
            {"What is the main ingredient of the popular Indian dish 'Biryani'?", "A. Rice", "B. Pasta", "C. Noodles", "D. Bread", "A"},
            {"Which city is known as the 'City of Dreams' in India?", "A. Mumbai", "B. Kolkata", "C. Bangalore", "D. Chennai", "A"},
            {"What is the famous street food of Mumbai?", "A. Vada Pav", "B. Dosa", "C. Idli", "D. Samosa", "A"},
            {"Which Indian city is famous for its IT industry and is known as the 'Silicon Valley of India'?", "A. Bangalore", "B. Hyderabad", "C. Chennai", "D. Pune", "A"}
    };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int score = 0;
        //start quiz and acknowledge the player with instructions
        System.out.println("Welcome to the India Quiz Game!");
        System.out.println("You have " + QUESTION_TIME_LIMIT_SECONDS + " seconds to answer each question.");
        System.out.println("Type the letter corresponding to your answer and press Enter to submit.");
        //iterate questions
        for (int i = 0; i < NUM_QUESTIONS; i++) {
            System.out.println("\nQuestion " + (i + 1) + ": " + questions[i][0]);
            for (int j = 1; j < questions[i].length - 1; j++) {
                System.out.println(questions[i][j]);
            }
            long startTime = System.currentTimeMillis();//start timer
            String answer = sc.nextLine().toUpperCase().trim();//take user input
            long endTime = System.currentTimeMillis();//end timer
            //if the player's answer is correct
            if (answer.equals(questions[i][questions[i].length - 1]) && (endTime - startTime) / 1000 <= QUESTION_TIME_LIMIT_SECONDS) {
                System.out.println("Correct!");
                score++;
            }
            //if the player's answer is incorrect 
            else {
                System.out.println("Incorrect or Time's up!");
            }
        }
        //end quiz
        System.out.println("\nWell played! You've reached the end of the quiz.");
        //print player's final score
        System.out.println("Your final score: " + score + " out of " + NUM_QUESTIONS);
        sc.close();
    }
}
