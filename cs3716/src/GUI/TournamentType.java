package GUI;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.*;

import SkeletonCode.Tournament;
/**
 * This describes the JFrame used for a tournament type
 * 
 * @author John Hollett
 * @author Keir Strickland Murphy
 * @author Rory Campbell
 * @author Jaimee Bessey
 * @author Kristan James Hart
 * @author Karl Chiasson
 */
public class TournamentType extends JPanel {
	private JLabel headerLabel;
	private JLabel bracketLabel;
	private JLabel tournamentLabel;
	private JComboBox bracketBox;
	private JButton submitButton;
	private JPanel borderLayout;
	private JPanel tournamentPanel;
	private JPanel gridLayout;
	private JPanel btnPanel;
	private String tournamentName;
	private String stringTeams;
	private String tType;
	private int intTeams;
	private int numType;
	private Tournament tournament;
	
	/**
	 * Constructor for a TournamentType. Takes an ArrayList of Tournaments, also an integer that
	 * represents the index of the tournament
	 * @param t - ArrayList&ltTournament&gt
	 * @param i - Integer
	 */
	public TournamentType(Tournament t){
		tournament = t;
		getInfo();
		createItems();
		createButton();
		createPanel();
		setSize(500,500);
	}
	
	/**
	 * Constructor for a TournamentType. Takes an ArrayList of Tournaments and also takes the type as a string.
	 * @param t - Tournament
	 * @param type - String
	 */
	public TournamentType(Tournament t, String type){
		this(t);
		tType = type;
	}
	/**
	 * Does not return anything, modifies itself directly.
	 */
	public void getInfo(){
		tournamentName = "TOURNAMENT NAME";
		tournamentName = tournament.getName();
//		intTeams = teams.size();	
		intTeams = 0;
	}
	/**
	 * Creates labels and populates them with text and font-style.
	 */
	private void createItems(){
		stringTeams = Integer.toString(intTeams);
		
		String[] bracketTypes = {"Single Elimination", "Double Elimination", "Divisions"};
		bracketBox = new JComboBox(bracketTypes);
		
		headerLabel = new JLabel("Create Tournament", SwingConstants.CENTER);
		headerLabel.setFont(new Font("Arial", Font.BOLD, 24));

		bracketLabel = new JLabel("There are " + stringTeams + " teams registered in " + tournamentName + ".", SwingConstants.CENTER);
		bracketLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		
		tournamentLabel = new JLabel("Select a tournament type:");
		tournamentLabel.setFont(new Font("Arial", Font.PLAIN, 16));	
	}
	/**
	 * Creates a button for submission
	 */
	private void createButton(){
		ActionListener listener = new choiceListener();
		submitButton = new JButton("Submit");
		submitButton.addActionListener(listener);
		submitButton.setFont(new Font("Arial", Font.PLAIN, 16));
	}
	/**
	 * Inner-Class that implements ActionListener
	 * When actionPerformed, sets the type of the tournament as well as listing them.
	 * Finally, Opens a ManageTournament frame. 
	 *
	 */
	class choiceListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			//set type of tournament
			if(bracketBox.getSelectedItem().equals("Single Elimination")){numType = 1;}
			else if(bracketBox.getSelectedItem().equals("Double Elimination")){numType = 2;}
			else  {numType = 3;}
			tournament.setType(numType);
//			listOfTourns.set(tournIndex, tournament);
//			JFrame frame1 = new ManageTournament(listOfTourns);
//			frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//			frame1.setVisible(true);
//			dispose();
		}
	}
	/**
	 * Creates JPanels for this class.
	 */
	private void createPanel(){
		borderLayout = new JPanel(new BorderLayout());
		tournamentPanel = new JPanel();
		gridLayout = new JPanel(new GridLayout(3,1));
		btnPanel = new JPanel();

		tournamentPanel.add(tournamentLabel);
		tournamentPanel.add(bracketBox);

		gridLayout.add(headerLabel);
		gridLayout.add(bracketLabel);
		gridLayout.add(tournamentPanel);
		
		btnPanel.add(submitButton);

		borderLayout.add(gridLayout, BorderLayout.NORTH);
		borderLayout.add(btnPanel, BorderLayout.SOUTH);
		
		add(borderLayout);
	}
}
