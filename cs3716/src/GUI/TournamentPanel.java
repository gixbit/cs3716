package GUI;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.*;

import SkeletonCode.Tournament;

/**
 * This TournmentPanel extended from a JPanel, is used to create panels for a tournament.
 * 
 * @author John Hollett
 * @author Keir Strickland Murphy
 * @author Rory Campbell
 * @author Jaimee Bessey
 * @author Kristan James Hart
 * @author Karl Chiasson
 */
public class TournamentPanel extends JPanel implements PanelAccess{
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
	private JPanel borderlayout;
	private JPanel gridlayout;
	private JPanel btnPanel;

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

	private boolean newMenu = false;
	private String nextMenuName = "";
	/**
	 * Constructor for a TournamentPanel, uses {@link #getInfo()},{@link #createItems()}, {@link #createButtons()}
	 * and {@link #createPanels()}, to create a TournamentPanel
	 */
	public TournamentPanel(){
		getInfo();
		createItems();
		createButtons();
		createPanels();
	}

	/**
	 * Constructor for a TournamentPanel, uses {@link #getInfo()}, {@link #createItems()}, {@link #createButtons()}
	 * and {@link #createPanels()}, to create a TournamentPanel
	 * 
	 * <br><br>
	 * Also takes a Tournament Object, ArrayList&ltTournament&gt, and an integer
	 * 
	 * @param tourn - Tournament
	 * @param tourns - ArrayList&ltTournament&gt
	 * @param i - Integer
	 */
	public TournamentPanel(Tournament tourn){
		thisTournament = tourn;
		getInfo();
		createItems();
		createButtons();
		createPanels();
	}
	/**
	 * This sets information for this object. This is a housekeeping method.
	 */
	private void getInfo(){
		numOfTeams = thisTournament.getTeamList().size();
 		tournName = thisTournament.getName();
 		venueName = thisTournament.getVenue();
 		startDate = thisTournament.getStartDate();
 		regDate = thisTournament.getEndDate();
 		tType = String.valueOf(thisTournament.getType());
	}

	/**
	 * This creates JLabels for this object. This is a housekeeping method.
	 */
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
	/**
	 * This creates buttons for this object. This is a housekeeping method.
	 */
	private void createButtons(){
//		ActionListener listener = new choiceListener();
//		editButton = new JButton("Edit");
//		editButton.addActionListener(listener);
//		editButton.setFont(new Font("Arial", Font.PLAIN, 16));	
//
//		generateButton = new JButton("Generate");
//		generateButton.addActionListener(listener);
//		generateButton.setFont(new Font("Arial", Font.PLAIN, 16));	
//
//		teamsButton = new JButton("Teams List");
//		teamsButton.addActionListener(listener);
//		teamsButton.setFont(new Font("Arial", Font.PLAIN, 16));	
//
//		deleteButton = new JButton("Delete");
//		deleteButton.addActionListener(listener);
//		deleteButton.setFont(new Font("Arial", Font.PLAIN, 16));	
	}
	/**
	 * Inner-Class implementing an ActionListener.
	 * 
	 * <br>
	 * If source is generateButton, creates a frame for tournament.
	 * <br>
	 * If source is teamsButton, creates a teams frame for this tournament
	 * <br>
	 * If source is deleteButton, deletes the index of this object from the tournaments list
	 * <br>
	 * Else Opens a CreateTournament Frame, also removes the index of this object from the tournaments list
	 */
//	class choiceListener implements ActionListener{
//		public void actionPerformed(ActionEvent event){
//			if(event.getSource() == generateButton){
//				if(tType.equals("unspecified")){
//					JPanel frame1 = new TournamentType(tournaments, index);
//					frame1.setVisible(true);
//				}
//				else{
//					JPanel frame1 = new TournamentType(tournaments, index, tType);
//					frame1.setVisible(true);
//				}
//			}
//			
//			else if(event.getSource() == teamsButton){
//				JPanel frame1 = new ListOfTeams(thisTournament, tournaments);
//				frame1.setVisible(true);
//			}
//			else if(event.getSource() == deleteButton){
//				tournaments.remove(index);
//				JPanel frame1 = new ManageTournament(tournaments);
//				frame1.setVisible(true);
//			}
//			
//			//Changed the frame to a panel
//			else{	//event.getSource() == editButton
//				tournaments.remove(index);
//				CreateTournament frame1 = new CreateTournament(tournName, venueName, orgName, orgInfo, tournaments);
//				frame1.setVisible(true);
//			
//			}
//			
//		}
//	} FIX THIS FOR THE FRAME
	
	/**
	 * Creates panels for this object.
	 */
	
	private void createPanels(){
		this.setLayout(new BorderLayout());
		gridlayout = new JPanel(new GridLayout(4,2));
		btnPanel = new JPanel();

		gridlayout.add(tournLabel);
		gridlayout.add(structureLabel);
		gridlayout.add(venueLabel);
		gridlayout.add(regDateLabel);
		gridlayout.add(numTeamsLabel);
		gridlayout.add(startDateLabel);

		btnPanel.add(editButton);
		btnPanel.add(deleteButton);
		btnPanel.add(generateButton);
		btnPanel.add(teamsButton);

		this.add(gridlayout, BorderLayout.CENTER);
		this.add(btnPanel, BorderLayout.SOUTH);
		//panel.setBorder(BorderFactory.createRaisedBevelBorder());

		//add(panel);
	}
	//Added empty methods
	
	@Override
	public boolean newMenu() {
		return newMenu;
	}
	
	@Override
	public String getNextMenu() {
		return "";
	}
	
	@Override
	public void setNewMenu() {
		this.newMenu = true;
		
	}
}