import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.font.*;
import java.util.ArrayList;
import javax.swing.SwingUtilities;
import java.awt.event.*;
import javax.swing.JTextField;

public class QuestionPanel extends JPanel{
	String Question;
	String OptionA;
	String OptionB;
	String OptionC;
	String OptionD;
    static String Correct;
	
	public QuestionPanel(String Question, String OptionA, String OptionB, String OptionC, String OptionD, String CorrectOption) {
		
		Dimension ButtonSize = new Dimension(200,100); // (width, height)
		Font QuestionFont = new Font("Arial", Font.BOLD, 36);
		Font ButtonFont = new Font("Arial", Font.BOLD, 16);
		
		setLayout(new GridBagLayout()); 
		GridBagConstraints d = new GridBagConstraints();
		GridBagConstraints c = new GridBagConstraints();
		
		// Are the this.field lines necessary?
		this.Question = Question;
		this.OptionA = OptionA;
		this.OptionB = OptionB;
		this.OptionC = OptionC;
		this.OptionD = OptionD;
		this.Correct = CorrectOption;
		
		JLabel QuestionLabel = new JLabel(Question);
		QuestionLabel.setFont(QuestionFont);
		
		JButton A = new JButton(OptionA);
		JButton B = new JButton(OptionB);
		JButton C = new JButton(OptionC);
		JButton D = new JButton(OptionD);
	
		// Make an ArrayList to hold all the buttons to use iterator
		ArrayList <JButton> ButtonList = new ArrayList<JButton>();
		
		ButtonList.add(A);
		ButtonList.add(B);
		ButtonList.add(C);
		ButtonList.add(D);
		
		System.out.print(Correct);
		
		// Add the buttons on GridBagLayout
		c.gridx = 0;
		c.gridy = 0;
		add(QuestionLabel, c);
		c.gridy++;
		add(A, c);
		c.gridy++;
		add(B, c);
		c.gridy++;
		add(C, c);
		c.gridy++;
		add(D, c);
		
		// Designing all the buttons
		for(int i=0; i < ButtonList.size(); ++i) {
			JButton b = ButtonList.get(i);
			b.setBackground(Color.LIGHT_GRAY);
			b.setPreferredSize(ButtonSize);
			b.setFont(ButtonFont);
			
			
//==================================================================================			
			b.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent event) {
					//System.out.println(event.getSource().toString());
					if(event.getSource().equals(A) ){
						b.setBackground(Color.GREEN);
						Main.score++;
					}
					
					else {
						b.setBackground(Color.RED);
					}
				}
			});
//==================================================================================			
		
		}
	
		setBackground(Color.WHITE);
	
	}
}
