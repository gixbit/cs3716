package GUI;

import javax.swing.*;

/**
 * This class describes the Player panels that appear when creating a new team.
 * 
 * @author John Hollett
 * @author Keir Strickland Murphy
 * @author Rory Campbell
 * @author Jaimee Bessey
 * @author Kristan James Hart
 * @author Karl Chiasson
 */
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
