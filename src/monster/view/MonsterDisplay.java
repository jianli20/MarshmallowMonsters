package monster.view;

import javax.swing.JOptionPane;


public class MonsterDisplay
{

	// Creates popup windows when called
	public void displayText(String textToDisplay)
	{
		JOptionPane.showMessageDialog(null, textToDisplay);
	}
	
	public String getResponse(String questionToDisplay)
	{
		String answer = "";
		
		answer += JOptionPane.showInputDialog(null, questionToDisplay);
		
		return answer;
	}
}
