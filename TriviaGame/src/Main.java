/**
 * Project: TriviaGame
 * 
 * Description: Plays a game of trivia with the user 
 * 
 * File: Main.java: Functions as the controller of the application (MVC framework)
 * 
 * @author Atif Mahmud
 * @Date 2nd June 2017
 * 
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import java.io.*;
import javax.swing.SwingUtilities;
import java.awt.CardLayout;

public class Main extends JFrame {
	
	private static int score = 0;
	private static volatile int start = 0;
	private static boolean run;
	
	public static void incrementScore() {
		score ++;
	}
	
	public void startYes() {
		start = 1;
	}
	
	public void setRun(boolean setVal) {
		run = setVal;
	}
	
	
	public static void main (String [] args)  throws Exception {
				
		ArrayList <Question> QuestionList = new ArrayList <Question>(); 
		ArrayList <QuestionPanel> PanelList = new ArrayList <QuestionPanel>();
		
		CardLayout card = new CardLayout();
		 	
		
		 	try {
				FileReader QuestionFile = new FileReader ("QuestionBank.txt");	
				BufferedReader Reader = new BufferedReader(QuestionFile);
				FileReader LineReader = new FileReader("QuestionBank.txt");
				
				LineNumberReader LineNumber = new LineNumberReader(LineReader);	
				LineNumber.skip(Long.MAX_VALUE);                               // Not sure why this line here; ask someone
				int numQuestions = (LineNumber.getLineNumber() + 1) / 6;       // +1 because it starts counting at 0, divide by 6 because 6 lines per question
			    LineNumber.close();                                           
			
				for (int j=0; j < numQuestions; j++){ 
					Question NewQuestion;
					
					NewQuestion.setQuestion(Reader.readLine()); 
					NewQuestion.setOptionA(Reader.readLine());
					NewQuestion.setOptionB(Reader.readLine());
					NewQuestion.setOptionC(Reader.readLine());
					NewQuestion.setOptionD(Reader.readLine());
					QuestionList.add(NewQuestion);
					
				}
				
			} catch (IOException e){
				JOptionPane.showMessageDialog(null, "We have encountered an error. Please confirm that the QuestionFile has not been removed from the game directory.\n\n");
				e.printStackTrace();
				System.exit(0);          
		  } 
		 	
		 	
		 	
		 JPanel Content = new JPanel();
		 Content.setLayout(card);
		 		 
		 for (int i=0; i < QuestionList.size(); ++i) {
			 Question QuestionForPanel = QuestionList.get(i);
			 QuestionPanel NewPanel = new QuestionPanel (QuestionForPanel.getQuestion(), QuestionForPanel.getOptionA(), QuestionForPanel.getOptionB(), // line break here
					 					QuestionForPanel.getOptionC(), QuestionForPanel.getOptionD(), QuestionForPanel.getCorrectOption());
			 PanelList.add(NewPanel);
			 Content.add(NewPanel, Integer.toString(i)); 
		 }
		 
		 MainMenu MainMenu = new MainMenu();
		 GUI GameGUI = new GUI();
	     GameGUI.add(MainMenu);
		 GameGUI.setVisible(true);  
		 
		
		 while (start == 0) {
			 Thread.sleep(500);
			 if(start != 0) break;
		 }
		 
		 GameGUI.remove(MainMenu);
		 GameGUI.add(Content);
		 GameGUI.repaint();
		 GameGUI.revalidate();
		 
		 for (int i =0; i < 15; i++) {
			run = true;
			while(run) {
				card.show(Content, Integer.toString(i));
				if(run == false) {
					Thread.sleep(500);
					break;
				}
				continue;
			}
		 }
		
		
		 System.exit(0);
		 
		// This will ensure main runs once the mouse event is detected 
		// Event Dispatching Thread: Figure out what it is for
		 SwingUtilities.invokeLater(new Runnable(){
				@Override
				public void run(){
					new Main();
				}
			});
		}
}