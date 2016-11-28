package GUI;

import javax.swing.*;

public class PlayerPanel extends JPanel{
	private JTextField playerName;
	private JTextField playerAge;
	
	public PlayerPanel(){
		playerName = new JTextField(25);
		playerName.setText("");

		playerAge = new JTextField(5);
		playerAge.setText("");
		
		add(playerName);
		add(playerAge);
	}
	
	public String getPlayerName(){
		return playerName.getText();
	}
	public String getPlayerAge(){
		return playerAge.getText();
	}	
}
