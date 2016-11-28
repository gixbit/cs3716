package skeletonCode;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class TournamentPanel extends JPanel{
	private JLabel tournLabel;
	private JLabel venueLabel;
	private JLabel startDateLabel;
	private JLabel regDateLabel;
	private JLabel structureLabel;
	private JLabel numTeamsLabel;
	private JButton teamsButton;
	private JButton editButton;
	private JButton deleteButton;
	private JButton generateButton;
	private JPanel panel;
	private JPanel panel1;
	private JPanel panel2;

	private String tournName;
	private String venueName;
	private String startDate;
	private String regDate;
	private String orgName;
	private String orgInfo;
	private int numOfTeams;
	private int index;
	private String tType;
	private Tournament thisTournament;
	private ArrayList<Tournament> tournaments = new ArrayList<Tournament>();
	
	public TournamentPanel(){
		getInfo();
		createItems();
		createButtons();
		createPanels();
	}

	public TournamentPanel(Tournament tourn, ArrayList<Tournament> tourns, int i){
		tournaments = tourns;
		thisTournament = tourn;
		index = i;
		getInfo();
		createItems();
		createButtons();
		createPanels();
	}

	private void getInfo(){
		numOfTeams = thisTournament.getTeamList().size();
 		tournName = thisTournament.getName();
 		venueName = thisTournament.getVenue();
 		startDate = thisTournament.getStartDate();
 		regDate = thisTournament.getEndDate();
 		tType = String.valueOf(thisTournament.getType());
	}

	private void createItems(){
		tournLabel = new JLabel("Name: " + tournName);
		tournLabel.setFont(new Font("Arial", Font.PLAIN, 16));

		venueLabel = new JLabel("Location: " + venueName);
		venueLabel.setFont(new Font("Arial", Font.PLAIN, 16));

		numTeamsLabel = new JLabel("Number of Teams: " + Integer.valueOf(numOfTeams));
		numTeamsLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		
		structureLabel = new JLabel("Structure: " + tType);
		structureLabel.setFont(new Font("Arial", Font.PLAIN, 16));

		startDateLabel = new JLabel("Tournament Start Date: " + startDate);
		startDateLabel.setFont(new Font("Arial", Font.PLAIN, 16));
			
		regDateLabel = new JLabel("Registration Closing Date: " + regDate);
		regDateLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		if(tType.equals("0")){		structureLabel.setText("Structure: Unspecified");	}
		else if(tType.equals("1")){		structureLabel.setText("Structure: Single Elimination");	}
		else if(tType.equals("2")){		structureLabel.setText("Structure: Double Elimination");	}
		else 					{		structureLabel.setText("Structure: Divisions");	}
	}
		
	private void createButtons(){
		ActionListener listener = new choiceListener();
		editButton = new JButton("Edit");
		editButton.addActionListener(listener);
		editButton.setFont(new Font("Arial", Font.PLAIN, 16));	

		generateButton = new JButton("Generate");
		generateButton.addActionListener(listener);
		generateButton.setFont(new Font("Arial", Font.PLAIN, 16));	

		teamsButton = new JButton("Teams List");
		teamsButton.addActionListener(listener);
		teamsButton.setFont(new Font("Arial", Font.PLAIN, 16));	

		deleteButton = new JButton("Delete");
		deleteButton.addActionListener(listener);
		deleteButton.setFont(new Font("Arial", Font.PLAIN, 16));	
	}

	class choiceListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			if(event.getSource() == generateButton){
				if(tType.equals("unspecified")){
					JFrame frame1 = new TournamentType(tournaments, index);
					frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					frame1.setVisible(true);
				}
				else{
					JFrame frame1 = new TournamentType(tournaments, index, tType);
					frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					frame1.setVisible(true);
				}
			}
			else if(event.getSource() == teamsButton){
				JFrame frame1 = new ListOfTeams(thisTournament, tournaments);
				frame1.setVisible(true);
			}
			else if(event.getSource() == deleteButton){
				tournaments.remove(index);
				JFrame frame1 = new ManageTournament(tournaments);
				frame1.setVisible(true);
			}
			else{	//event.getSource() == editButton
				tournaments.remove(index);
				JFrame frame1 = new CreateTournament(tournName, venueName, orgName, orgInfo, tournaments);
				frame1.setVisible(true);
			}
		}
	}
		
	private void createPanels(){
		panel = new JPanel(new BorderLayout());
		panel1 = new JPanel(new GridLayout(4,2));
		panel2 = new JPanel();

		panel1.add(tournLabel);
		panel1.add(structureLabel);
		panel1.add(venueLabel);
		panel1.add(regDateLabel);
		panel1.add(numTeamsLabel);
		panel1.add(startDateLabel);

		panel2.add(editButton);
		panel2.add(deleteButton);
		panel2.add(generateButton);
		panel2.add(teamsButton);

		panel.add(panel1, BorderLayout.CENTER);
		panel.add(panel2, BorderLayout.SOUTH);
		panel.setBorder(BorderFactory.createRaisedBevelBorder());

		add(panel);
	}
}