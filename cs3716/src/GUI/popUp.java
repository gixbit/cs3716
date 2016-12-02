package GUI;

import java.awt.*;
import javax.swing.*;

/**
 * This is a popup that happens throughout the usage of the GUI
 * 
 * @author John Hollett
 * @author Keir Strickland Murphy
 * @author Rory Campbell
 * @author Jaimee Bessey
 * @author Kristan James Hart
 * @author Karl Chiasson
 */
public class popUp extends JFrame{
	private JLabel alert;
	private JPanel popUpPanel;
	
	public popUp(){
		alert = new JLabel("You pushed a Button! Yayy!!");
		alert.setFont(new Font("Arial", Font.PLAIN, 20));
		
		createPanel();
		setSize(500,200);
		setTitle("Alert");
	}
	public popUp(String word){
		alert = new JLabel(word);
		alert.setFont(new Font("Arial", Font.PLAIN, 20));
		
		createPanel();
		setSize(500,200);
		setTitle("Alert");
		
	}
	
	public void createPanel(){
		popUpPanel = new JPanel();
		popUpPanel.add(alert);
		add(popUpPanel);
	}
	
}
