package GUI;

import SkeletonCode.Team;
import SkeletonCode.Tournament;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class Register extends JPanel implements PanelAccess{
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
	//private ArrayList<PlayerPanel> listOfPlayers = new ArrayList<PlayerPanel>();
	private PlayerPanel[] listOfPlayers = new PlayerPanel[40];
	private ArrayList<String> tournNames = new ArrayList<String>();
	private ArrayList<Tournament> listOfTourns = new ArrayList<Tournament>();
	private int numOfTourns;
	private String time;
	private String date;
	private int n = 1;
	private boolean newMenu = false;
	private String nextMenuName = "";
	
	public Register(){
		getInfo();
		createLabels();
		createFields();
		createButton();
		createPanel();
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

		tournamentBox = new JComboBox(tournNames.toArray());
		tournamentBox.setFont(new Font("Arial", Font.PLAIN, 16));
		tournamentBox.addActionListener(new ActionListener()
			{
			  public void actionPerformed(ActionEvent e){
				String selected = tournamentBox.getSelectedItem().toString();
				for(int i = 0; i < numOfTourns; i++){
					if(selected.equals(listOfTourns.get(i).getName())){
						dateLabel.setText("Registration closes on " + listOfTourns.get(i).getEndDate());
						revalidate();
						break;
					}
                }
			}
		});
		

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

		registerButton = new JButton("Register");
		registerButton.setFont(new Font("Arial", Font.PLAIN, 14));
		registerButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
			  	
			}
		});
		
		addButton = new JButton("Add Player");
		addButton.setFont(new Font("Arial", Font.PLAIN, 14));
		addButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
		  		n++;
				listOfPlayers[n-1] = new PlayerPanel();
				playerPanel.add(listOfPlayers[n-1]);
				players.add(playerPanel);
				revalidate();
			}
		});
		
		cancelButton = new JButton("Cancel");
		cancelButton.setFont(new Font("Arial", Font.PLAIN, 14));
		cancelButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
			  	setNextMenu(true,"back");
			}
		});
		
		clearButton = new JButton("Clear");
		clearButton.setFont(new Font("Arial", Font.PLAIN, 14));		
		clearButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				removeAll();
				resetVar();
				createLabels();
				createFields();
				createButton();
				createPanel();
				revalidate();
				repaint();
			}
		});
	}
    /* Hold for reference

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
					//JFrame frame1 = new popUp("You Have Reached the Max Number of Players.");
					//frame1.setVisible(true);
					//dispose();
				}
				else{
					n++;
					listOfPlayers[n-1] = new PlayerPanel();
					playerPanel.add(listOfPlayers[n-1]);
					players.add(playerPanel);
					revalidate();
					repaint();
				}
			}
			else if(event.getSource() == cancelButton){
				//JFrame frame1 = new MainScreen(listOfTourns);
				//frame1.setVisible(true);
				//dispose();
			}
			else if(event.getSource() == clearButton){
				//JFrame frame1 = new Register(listOfTourns);
				//frame1.setVisible(true);
				//dispose();
			}
			else{	//event.getSource() == RegisterButton
				int index = 0;
				for(int i=0; i < tournNames.size(); i++){
					if(tournNames.get(i) == (String)tournamentBox.getSelectedItem()){
						//TODO: FIX ME JAIMEE
						listOfTourns.get(i).addTeam(new Team(teamNameField.getText(), coachField.getText()));
						index = i;
						break;
					}
				}
				//JFrame frame1 = new ListOfTeams(listOfTourns.get(index), listOfTourns);
				//frame1.setVisible(true);
				//dispose();
				System.out.println(organizNameField.getText());
				for(int i=0; i < n; i++){
					if(listOfPlayers[i].getPlayerName() != null && listOfPlayers[i].getPlayerAge() != null){
						System.out.println(listOfPlayers[i].getPlayerName());
						System.out.println(listOfPlayers[i].getPlayerAge());
					}
				}
			
			}
		}
	}*/
	
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
		this.setLayout(new BorderLayout());
		
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

		this.add(greetingLabel, BorderLayout.NORTH);
		this.add(scrollFrame, BorderLayout.CENTER);
		this.add(btns, BorderLayout.SOUTH);
	}

	private void resetVar(){
		grid = null;
		name = null;
		teamName= null;
		organizer= null;
		coach= null;
		addBtn= null;
		cancelBtn= null;
		players= null;
		btns= null;
		playerPanel= null;
		completePanel= null;
		finalPanel= null;
		greetingLabel= null;
		tournamentBox= null;
		registerButton= null;
		addButton= null;
		cancelButton= null;
		clearButton= null;
		teamNameLabel= null;
		tournLabel= null;
		organizNameLabel= null;
		playerLabel= null;
		coachLabel= null;
		dateLabel= null;
		teamNameField= null;
		organizNameField= null;
		playerNameField= null;
		playerAgeField= null;
		coachField= null;
		scrollFrame= null;
		//listOfPlayers = new ArrayList<PlayerPanel>();
		listOfPlayers = new PlayerPanel[40];
		tournNames = new ArrayList<String>();
		listOfTourns = new ArrayList<Tournament>();
		numOfTourns= 0;
		time= null;
		date= null;
		n = 1;
		newMenu = false;
		nextMenuName = "";
	}

	private void setNextMenu(boolean state, String next){
		newMenu = state;
		nextMenuName = next;
	}

	public boolean newMenu(){
		return newMenu;
	}

	public String getNextMenu(){
		return nextMenuName;
	}

	public void setNewMenu(){
		newMenu = false;
	}

	public void clearNextMenu(){
		nextMenuName = "";
	}

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
}
