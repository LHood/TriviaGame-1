import java.util.*;
import java.io.*;
import javax.swing.JOptionPane;

public class Question {
    public String question; 
	public String OptionA;
	public String OptionB;
	public String OptionC;
	public String OptionD;
	public String correctOption;
	public static int score = 0;  // Keeps track of score 
	
	// Constructor for a new question
	public Question (String question, String OptionA, String OptionB, String OptionC, String OptionD, String correctOption){
		this.question = question;
		this.OptionA = OptionA;
		this.OptionB = OptionB;
		this.OptionC = OptionC;
		this.OptionD = OptionD;
		this.correctOption = correctOption;
	}
	
	public static void askQuestion(Question question){
			
		// Show the question in a GUI
		JOptionPane.showMessageDialog(null, question.question, "Atif's TriviaGame", JOptionPane.PLAIN_MESSAGE);
		System.out.println(question.OptionA);
		System.out.println(question.OptionB);
		System.out.println(question.OptionC);
		System.out.println(question.OptionD);
		
		// Take in the user input
		Scanner scan = new Scanner(System.in);
		String userInput = scan.next();
		
		
		// Check if correct; if so, increment score
		if(userInput.equals(question.correctOption)){
			System.out.println("Correct!\n");
			score++;
		}
		
		else {
			System.out.println("Wrong\n");
		}
		
		System.out.printf("Score = %d\n\n", score );  // Print out the score
	}	
}
	