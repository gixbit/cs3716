package GUI;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.*;

import SkeletonCode.Tournament;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

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
	private Tournament tournament;
	
	public TournamentPanel(){
		getInfo();
		createItems();
		createButtons();
		createPanels();
		addSaveCloser();
	}

	public TournamentPanel(Tournament tourn, int i){
		tournament = tourn;
		index = i;
		getInfo();
		createItems();
		createButtons();
		createPanels();
		addSaveCloser();
	}

	private void getInfo(){
		numOfTeams = tournament.getTeamList().size();
 		tournName = tournament.getName();
 		venueName = tournament.getVenue();
 		startDate = tournament.getStartDate();
 		regDate = tournament.getEndDate();
 		//TODO: FIX THIS
 		tType = String.valueOf("0");
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
					JFrame frame1 = new TournamentType(index);
					frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					frame1.setVisible(true);
				}
				else{
					JFrame frame1 = new TournamentType(index, tType);
					frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					frame1.setVisible(true);
				}
			}
			else if(event.getSource() == teamsButton){
				JFrame frame1 = new ListOfTeams(tournament);
				frame1.setVisible(true);
			}
			else if(event.getSource() == deleteButton){
				Viewer.Tournaments.remove(index);
				JFrame frame1 = new ManageTournament();
				frame1.setVisible(true);
			}
			else{	//event.getSource() == editButton
				Viewer.Tournaments.remove(index);
				JFrame frame1 = new CreateTournament(tournName, venueName, orgName, orgInfo);
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
	public void addSaveCloser(){
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				try {
					FileOutputStream fos = new FileOutputStream("Tournaments.txt");
					ObjectOutputStream oos = new ObjectOutputStream(fos);
					try {
						oos.writeObject(Viewer.Tournaments);

					} catch (IOException err) {

					} finally {
						oos.flush();
						oos.close();
						fos.flush();
						fos.close();
					}

				} catch (IOException err) {
					// Could not find file or open file.
				}
				e.getWindow().dispose();
			}
		});
	}
}