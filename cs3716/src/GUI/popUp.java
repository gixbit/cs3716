//Jaimee
package GUI;

import java.awt.*;
import javax.swing.*;

public class popUp extends JFrame {
	private JLabel alert;
	private JPanel panel;
	
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
		panel = new JPanel();
		panel.add(alert);
		add(panel);
	}
	
}
