package GUI;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.*;

import SkeletonCode.Tournament;

public class ListOfTeams extends JPanel {
	private JTextArea listText;
	private JScrollPane listArea;
	private JLabel listLabel;
	private JLabel teamLabel;
	private JLabel teamName;
	private JPanel borderLayout;
	private JPanel btnPanel;
	private JPanel teamPanel;
	private JPanel northTeamPanel;
	private JPanel textPanel;
	private JButton contButton;
	private JButton regButton;
	private Tournament tour;
	private String tName;
	private ArrayList<Tournament> listOfTourns = new ArrayList<Tournament>();
	private int n = 0;

	public ListOfTeams() {
		createItems();
		createText();
		createPanel();
		setSize(500,500);
	}

	public ListOfTeams(Tournament t, ArrayList<Tournament> listT) {
		tour = t;
		tName = t.getName();
		n++;
		listOfTourns = listT;
		createItems();
		createButton();
		createText();
		createPanel();
		setSize(500,500);
	}
	
	private void createItems() {
		listLabel = new JLabel("List Of Teams for Tournament: ", SwingConstants.CENTER);
		listLabel.setFont(new Font("Arial", Font.BOLD, 24));

		teamName = new JLabel(tName, SwingConstants.CENTER);
		teamName.setFont(new Font("Arial", Font.BOLD, 24));

		teamLabel = new JLabel("Team Name");
		teamLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		
		listText = new JTextArea(19,35);
		listText.setFont(new Font("Arial", Font.PLAIN, 16));
		listText.setEditable(false);
	}

	private void createButton() {
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
			listText.append(tour.getTeamList().get(i).getTeamName() + "\n");
		}
	}
	
	class choiceListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			if(event.getSource() == regButton) {
//				JFrame frame1 = new Register(tour.getTeamList(), listOfTourns, tour);
//				frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//				frame1.setVisible(true);
			}
			else {	//event.getSource() == contButton
				JFrame frame1 = new MainScreen(listOfTourns);
//				frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame1.setVisible(true);
			}
		}
	}
	
	private void createPanel() {
		this.setLayout(new BorderLayout());
		btnPanel = new JPanel();
		teamPanel = new JPanel(new GridLayout(1,2));		
		northTeamPanel = new JPanel(new GridLayout(3,1));		
		textPanel = new JPanel();
		
		textPanel.add(listText);
		listArea = new JScrollPane(textPanel);
		
		btnPanel.add(regButton);
		btnPanel.add(contButton);
		teamPanel.add(teamLabel);
		northTeamPanel.add(listLabel);
		northTeamPanel.add(teamName);
		northTeamPanel.add(teamPanel);
		
		this.add(northTeamPanel, BorderLayout.NORTH);
		this.add(listArea, BorderLayout.CENTER);
		this.add(btnPanel, BorderLayout.SOUTH);
	}
}
