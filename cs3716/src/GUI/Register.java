package GUI;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.*;

import SkeletonCode.Team;
import SkeletonCode.Tournament;

public class Register extends JPanel {
	private JPanel grid;
	private JPanel name;
	private JPanel teamName;
	private JPanel organizer;
	private JPanel coach;
	private JPanel addBtn;
	private JPanel cancelBtn;
	private JPanel players;
	private JPanel btns;
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
	private String time;
	private String date;
	private int n = 1;
	private int dimA = 500;
	private int dimB = 700;

	public Register(){
		createLabels();
		createFields();
		createButton();
		createPanel();
	}

	private ArrayList<String> getNames(){
		ArrayList<String> tournNames = new ArrayList<String>();

		for(int i = 0; i < windowManager.Tournaments.size(); i++){
			tournNames.add(windowManager.Tournaments.get(i).getName());
		}
		time = "1:00AM";
		date = "January 1, 2016";
		if (windowManager.Tournaments.size() != 0){
			date = windowManager.Tournaments.get(0).getEndDate();
//			time = listOfTourns.get(0).getStartDate();
		}
		return tournNames;
	}

	private void createLabels(){
		greetingLabel = new JLabel("Register For Tournament", SwingConstants.CENTER);
		greetingLabel.setFont(new Font("Arial", Font.BOLD, 24));

		tournLabel = new JLabel("Select a Tournament: ");
		tournLabel.setFont(new Font("Arial", Font.PLAIN, 16));		

		ActionListener listener = new choiceListener();
		tournamentBox = new JComboBox(getNames().toArray());
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
				for(int i = 0; i < windowManager.Tournaments.size(); i++){
					if(selected.equals(windowManager.Tournaments.get(i).getName())){
						dateLabel.setText("Registration closes on " + windowManager.Tournaments.get(i).getEndDate());
						revalidate();
						break;
					}
                }
			}
			else if(event.getSource() == addButton){
				if(n >= 40){
					JFrame frame1 = new popUp("You Have Reached the Max Number of Players.");
					frame1.setVisible(true);
				}
				else{
					n++;
					listOfPlayers[n-1] = new PlayerPanel();
					playerPanel.add(listOfPlayers[n-1]);
					players.add(playerPanel);
					revalidate();
				}
			}
			else if(event.getSource() == cancelButton){
				JFrame frame1 = new MainScreen(windowManager.Tournaments);
				frame1.setVisible(true);
			}
			else if(event.getSource() == clearButton){
				//JFrame frame1 = new Register(listOfTourns);
				//frame1.setVisible(true);
			}
			else{	//event.getSource() == RegisterButton
				int index = 0;
				for(int i=0; i < windowManager.Tournaments.size(); i++){
					if(windowManager.Tournaments.get(i).getName() == (String)tournamentBox.getSelectedItem()){
						windowManager.Tournaments.get(i).addTeam(new Team(teamNameField.getText(), coachField.getText()));
						index = i;
						break;
					}
				}
				//JFrame frame1 = new ListOfTeams(listOfTourns.get(index), listOfTourns);
				//frame1.setVisible(true);
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
		grid = new JPanel(new GridLayout(6,1));
		name = new JPanel();
		teamName = new JPanel();
		organizer = new JPanel();
		coach = new JPanel();
		addBtn = new JPanel();
		cancelBtn = new JPanel();
		players = new JPanel();
		btns = new JPanel(new BorderLayout());
		completePanel = new JPanel(new BorderLayout());
		finalPanel = new JPanel(new BorderLayout());
		
		name.add(tournLabel);
		name.add(tournamentBox);
		teamName.add(teamNameLabel);
		teamName.add(teamNameField);
		organizer.add(organizNameLabel);
		organizer.add(organizNameField);
		coach.add(coachLabel);
		coach.add(coachField);

		addBtn.add(addButton);
		cancelBtn.add(cancelButton);
		cancelBtn.add(clearButton);
		cancelBtn.add(registerButton);

		listOfPlayers[0] = new PlayerPanel();
		playerPanel = new JPanel(new GridLayout(n-1,1));
		playerPanel.add(listOfPlayers[0]);
		players.add(playerPanel);

		grid.add(name);
		grid.add(dateLabel);
		grid.add(teamName);
		grid.add(organizer);
		grid.add(coach);
		grid.add(playerLabel);

		btns.add(addBtn, BorderLayout.NORTH);
		btns.add(cancelBtn, BorderLayout.CENTER);
		
		completePanel.add(grid, BorderLayout.NORTH);
		completePanel.add(players, BorderLayout.CENTER);

		scrollFrame = new JScrollPane(completePanel);

		finalPanel.add(greetingLabel, BorderLayout.NORTH);
		finalPanel.add(scrollFrame, BorderLayout.CENTER);
		finalPanel.add(btns, BorderLayout.SOUTH);
		add(finalPanel);
	}
}