package GUI;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.*;

import skeletonCode.Team;
import skeletonCode.Tournament;

public class Register extends JFrame{
	private JPanel panel;
	private JPanel panel1;
	private JPanel panel2;
	private JPanel panel3;
	private JPanel panel4;
	private JPanel panel5;
	private JPanel panel6;
	private JPanel panel7;
	private JPanel panel8;
	private JPanel playerPanel;
	private JPanel completePanel;
	private JPanel finalPanel;
	private JLabel greetingLabel;
	private JComboBox tournamentBox;
	private JButton registerButton;
	private JButton addButton;
	private JButton cancelButton;
	private JButton clearButton;
	private JLabel teamNameLabel;
	private JLabel tournLabel;
	private JLabel organizNameLabel;
	private JLabel playerLabel;
	private JLabel coachLabel;
	private JLabel dateLabel;
	private JTextField teamNameField;
	private JTextField organizNameField;
	private JTextField playerNameField;
	private JTextField playerAgeField;
	private JTextField coachField;
	private JScrollPane scrollFrame;
	private PlayerPanel[] listOfPlayers = new PlayerPanel[40];
	private ArrayList<String> tournNames = new ArrayList<String>();
	private ArrayList<Tournament> listOfTourns = new ArrayList<Tournament>();
	private int numOfTourns;
	private String time;
	private String date;
	private int n = 1;
	private Tournament t;
	private Tournament t1;
	private Tournament t2;
	
	public Register(ArrayList<Tournament> list){
		listOfTourns = list;
		getInfo();
		createLabels();
		createFields();
		createButton();
		createPanel();
		setSize(550,725);
		setTitle("Register for Tournament");
	}

	public Register(ArrayList<Team> lt, ArrayList<Tournament> listT, Tournament t){
		listOfTourns = listT;
		getInfo();
		createLabels();
		createFields();
		createButton();
		createPanel();
		setSize(550,725);
		setTitle("Register for Tournament");
	}

	private void getInfo(){
		numOfTourns = listOfTourns.size();
		for(int i = 0; i < numOfTourns; i++){
			tournNames.add(listOfTourns.get(i).getName());
		}
		time = "1:00AM";
		date = "January 1, 2016";
		if (listOfTourns.size() != 0){
			date = listOfTourns.get(0).getEndDate();
//			time = listOfTourns.get(0).getStartDate();
		}
	}

	private void createLabels(){
		greetingLabel = new JLabel("Register For Tournament", SwingConstants.CENTER);
		greetingLabel.setFont(new Font("Arial", Font.BOLD, 24));

		tournLabel = new JLabel("Select a Tournament: ");
		tournLabel.setFont(new Font("Arial", Font.PLAIN, 16));		

		ActionListener listener = new choiceListener();
		tournamentBox = new JComboBox(tournNames.toArray());
		tournamentBox.addActionListener(listener);
		tournamentBox.setFont(new Font("Arial", Font.PLAIN, 16));

		dateLabel = new JLabel("Registration closes on " + date + " at " + time + ".", SwingConstants.CENTER);
		dateLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		
		teamNameLabel = new JLabel("Team Name:");
		teamNameLabel.setFont(new Font("Arial", Font.PLAIN, 16));

		coachLabel = new JLabel("Coach Name:");
		coachLabel.setFont(new Font("Arial", Font.PLAIN, 16));

		organizNameLabel = new JLabel("Organization:");
		organizNameLabel.setFont(new Font("Arial", Font.PLAIN, 16));

		playerLabel = new JLabel("              Player's Name                    Age", SwingConstants.CENTER);
		playerLabel.setFont(new Font("Arial", Font.PLAIN, 18));
	}

	private void createFields(){
		teamNameField = new JTextField(30);
		teamNameField.setText("");

		organizNameField = new JTextField(30);
		organizNameField.setText("");
		
		coachField = new JTextField(30);
		coachField.setText("");

		playerNameField = new JTextField(25);
		playerNameField.setText("");

		playerAgeField = new JTextField(5);
		playerAgeField.setText("");
	}
	
	private void createButton(){
		ActionListener listener = new choiceListener();
		registerButton = new JButton("Register");
		registerButton.addActionListener(listener);
		registerButton.setFont(new Font("Arial", Font.PLAIN, 14));
		
		addButton = new JButton("Add Player");
		addButton.addActionListener(listener);
		addButton.setFont(new Font("Arial", Font.PLAIN, 14));
		
		cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(listener);
		cancelButton.setFont(new Font("Arial", Font.PLAIN, 14));
		
		clearButton = new JButton("Clear");
		clearButton.addActionListener(listener);
		clearButton.setFont(new Font("Arial", Font.PLAIN, 14));
	}

	class choiceListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			if(event.getSource() == tournamentBox){
				String selected = tournamentBox.getSelectedItem().toString();
				for(int i = 0; i < numOfTourns; i++){
					if(selected.equals(listOfTourns.get(i).getName())){
						dateLabel.setText("Registration closes on " + listOfTourns.get(i).getEndDate());
						revalidate();
						break;
					}
                }
			}
			else if(event.getSource() == addButton){
				if(n >= 40){
					JFrame frame1 = new popUp("You Have Reached the Max Number of Players.");
					frame1.setVisible(true);
					dispose();
				}
				else{
					n++;
					listOfPlayers[n-1] = new PlayerPanel();
					playerPanel.add(listOfPlayers[n-1]);
					panel7.add(playerPanel);
					revalidate();
				}
			}
			else if(event.getSource() == cancelButton){
				JFrame frame1 = new MainScreen(listOfTourns);
				frame1.setVisible(true);
				dispose();
			}
			else if(event.getSource() == clearButton){
				JFrame frame1 = new Register(listOfTourns);
				frame1.setVisible(true);
				dispose();
			}
			else{	//event.getSource() == RegisterButton
				int index = 0;
				for(int i=0; i < tournNames.size(); i++){
					if(tournNames.get(i) == (String)tournamentBox.getSelectedItem()){
						listOfTourns.get(i).addTeam(new Team(teamNameField.getText(), coachField.getText()));
						index = i;
						break;
					}
				}
				JFrame frame1 = new ListOfTeams(listOfTourns.get(index), listOfTourns);
				frame1.setVisible(true);
				dispose();
				System.out.println(organizNameField.getText());
				for(int i=0; i < n; i++){
					if(listOfPlayers[i].getPlayerName() != null && listOfPlayers[i].getPlayerAge() != null){
						System.out.println(listOfPlayers[i].getPlayerName());
						System.out.println(listOfPlayers[i].getPlayerAge());
					}
				}
			
			}
		}
	}
	
	private void createPanel(){
		panel = new JPanel(new GridLayout(6,1));
		panel1 = new JPanel();
		panel2 = new JPanel();
		panel3 = new JPanel();
		panel4 = new JPanel();
		panel5 = new JPanel();
		panel6 = new JPanel();
		panel7 = new JPanel();
		panel8 = new JPanel(new BorderLayout());
		completePanel = new JPanel(new BorderLayout());
		finalPanel = new JPanel(new BorderLayout());
		
		panel1.add(tournLabel);
		panel1.add(tournamentBox);
		panel2.add(teamNameLabel);
		panel2.add(teamNameField);
		panel3.add(organizNameLabel);
		panel3.add(organizNameField);
		panel4.add(coachLabel);
		panel4.add(coachField);

		panel5.add(addButton);
		panel6.add(cancelButton);
		panel6.add(clearButton);
		panel6.add(registerButton);

		listOfPlayers[0] = new PlayerPanel();
		playerPanel = new JPanel(new GridLayout(n-1,1));
		playerPanel.add(listOfPlayers[0]);
		panel7.add(playerPanel);

		panel.add(panel1);
		panel.add(dateLabel);
		panel.add(panel2);
		panel.add(panel3);
		panel.add(panel4);
		panel.add(playerLabel);

		panel8.add(panel5, BorderLayout.NORTH);
		panel8.add(panel6, BorderLayout.CENTER);
		
		completePanel.add(panel, BorderLayout.NORTH);
		completePanel.add(panel7, BorderLayout.CENTER);

		scrollFrame = new JScrollPane(completePanel);

		finalPanel.add(greetingLabel, BorderLayout.NORTH);
		finalPanel.add(scrollFrame, BorderLayout.CENTER);
		finalPanel.add(panel8, BorderLayout.SOUTH);
		add(finalPanel);
	}
}