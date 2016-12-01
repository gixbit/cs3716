package GUI;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.*;

import SkeletonCode.Tournament;

public class ListOfTeams extends JFrame{
	private JTextArea textArea1;
	private JScrollPane listArea;
	private JLabel listLabel;
	private JLabel teamLabel;
	private JLabel listLabel1;
	private JPanel panel;
	private JPanel panel1;
	private JPanel panel2;
	private JPanel panel3;
	private JPanel textPanel;
	private JButton contButton;
	private JButton regButton;
	private Tournament tour;
	private String tName;
	private ArrayList<Tournament> listOfTourns = new ArrayList<Tournament>();
	private int n = 0;

	public ListOfTeams(){
		createItems();
		createText();
		createPanel();
		setSize(550,725);
		setTitle("");
	}

	public ListOfTeams(Tournament t){
		tour = t;
		tName = t.getName();
		n++;
		createItems();
		createButton();
		createText();
		createPanel();
		setSize(500,500);
		setTitle("");
	}
	
	private void createItems(){
		listLabel = new JLabel("List Of Teams for Tournament: ", SwingConstants.CENTER);
		listLabel.setFont(new Font("Arial", Font.BOLD, 24));

		listLabel1 = new JLabel(tName, SwingConstants.CENTER);
		listLabel1.setFont(new Font("Arial", Font.BOLD, 24));

		teamLabel = new JLabel("Team Name");
		teamLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		
		textArea1 = new JTextArea(19,35);
		textArea1.setFont(new Font("Arial", Font.PLAIN, 16));
		textArea1.setEditable(false);
	}

	private void createButton(){
		ActionListener listener = new choiceListener();
		contButton = new JButton("Home");
		contButton.addActionListener(listener);
		contButton.setFont(new Font("Arial", Font.PLAIN, 16));
		
		regButton = new JButton("Register Another Team");
		regButton.addActionListener(listener);
		regButton.setFont(new Font("Arial", Font.PLAIN, 16));
	}

	private void createText(){
		for(int i = 0; i < tour.getTeamList().size(); i++){
			textArea1.append(tour.getTeamList().get(i).getTeamName() + "\n");
		}
	}
	
	class choiceListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			if(event.getSource() == regButton){
				JFrame frame1 = new Register();
//				frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame1.setVisible(true);
				dispose();
			}
			else{	//event.getSource() == contButton
				JFrame frame1 = new MainScreen(listOfTourns);
//				frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame1.setVisible(true);
				dispose();
			}
		}
	}
	
	private void createPanel(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = new JPanel(new BorderLayout());
		panel1 = new JPanel();
		panel2 = new JPanel(new GridLayout(1,2));		
		panel3 = new JPanel(new GridLayout(3,1));		
		textPanel = new JPanel();
		
		textPanel.add(textArea1);
		listArea = new JScrollPane(textPanel);
		
		panel1.add(regButton);
		panel1.add(contButton);
		panel2.add(teamLabel);
		panel3.add(listLabel);
		panel3.add(listLabel1);
		panel3.add(panel2);
		
		panel.add(panel3, BorderLayout.NORTH);
		panel.add(listArea, BorderLayout.CENTER);
		panel.add(panel1, BorderLayout.SOUTH);
		add(panel);
	}
}
