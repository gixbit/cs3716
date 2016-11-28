package skeletonCode;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class SingleElim extends JFrame{
	private JLabel alert;
	private JLabel alert1;
	private JPanel panel;
	private JPanel panel1;
	private JPanel panel2;
	
	public SingleElim(){
		alert = new JLabel("Team1");
		alert.setFont(new Font("Arial", Font.PLAIN, 20));
		alert1 = new JLabel("Team2");
		alert1.setFont(new Font("Arial", Font.PLAIN, 20));

		createPanel();
		setSize(500,200);
		setTitle("Alert");
	}

	public void createPanel(){
		panel = new JPanel(new GridLayout(0,5));
		panel1 = new JPanel();
		panel2 = new JPanel();

		TitledBorder title;
		Border blackline = BorderFactory.createLineBorder(Color.black);
		title = BorderFactory.createTitledBorder(blackline, "title");
		title.setTitleJustification(TitledBorder.RIGHT);
		panel1.setBorder(title);
		panel2.setBorder(title);
		
		panel1.add(alert);
		panel2.add(alert1);
		panel.add(panel1);
		panel.add(panel2);
		add(panel);
	}

}
