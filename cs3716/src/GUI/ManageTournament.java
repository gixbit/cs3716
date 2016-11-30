package GUI;

import SkeletonCode.Tournament;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;


public class ManageTournament extends JPanel implements PanelAccess{
	private JLabel greetingLabel;
	private JButton newButton;
	private JButton homeButton;
	private JPanel panel;
	private JPanel panel1;
	private JPanel panel2;
	private JPanel panel3;
	private JScrollPane scrollFrame;
	private ArrayList<TournamentPanel> listOfTourns = new ArrayList<TournamentPanel>();
	private ArrayList<Tournament> tournaments = new ArrayList<Tournament>();
	private int numOfTourns;
	private boolean newMenu = false;
	private String nextMenuName = "";
	
	public ManageTournament() {
		numOfTourns = 10;
		createItems();
		createButtons();
		createPanels();
	}

	public ManageTournament(ArrayList<Tournament> tourns){
		numOfTourns = tourns.size();
		tournaments = tourns;
		createItems();
		createButtons();
		createPanels();

	}

	private void createItems(){
		greetingLabel = new JLabel("Manage Tournaments", SwingConstants.CENTER);
		greetingLabel.setFont(new Font("Arial", Font.BOLD, 24));
	}
	
	private void createButtons(){
		
		homeButton = new JButton("Home");
		homeButton.setFont(new Font("Arial", Font.PLAIN, 16));
		homeButton.addActionListener(new ActionListener()
			{
			  public void actionPerformed(ActionEvent e)
			  {
			  	setNextMenu(true, "back");

			  }
		});

		newButton = new JButton("Create New Tournament");
		newButton.setFont(new Font("Arial", Font.PLAIN, 16));
		newButton.addActionListener(new ActionListener()
			{
			  public void actionPerformed(ActionEvent e)
			  {
			  	setNextMenu(true, "createtournament");

			  }
		});
	}

	private void createPanels(){
		//panel = new JPanel(new BorderLayout());
		this.setLayout(new BorderLayout());
		panel1 = new JPanel(new GridLayout(2,1));
		panel2 = new JPanel(new GridLayout(numOfTourns,1));
		panel3 = new JPanel();

		panel1.add(greetingLabel);
		panel3.add(homeButton);
		panel3.add(newButton);
		panel1.add(panel3);
		

		listOfTourns.add(new TournamentPanel());
		panel2.add(listOfTourns.get(0));

		/*
		for(int i=0; i < tournaments.size(); i++){
			listOfTourns.add(new TournamentPanel(tournaments.get(i), tournaments, i));
			panel2.add(listOfTourns.get(i));
		}
		*/

		scrollFrame = new JScrollPane(panel2);

		this.add(panel1, BorderLayout.NORTH);
		this.add(scrollFrame, BorderLayout.CENTER);
	}

	private void setNextMenu(boolean state, String next){
		newMenu = state;
		nextMenuName = next;
	}

	@Override
	public boolean newMenu() {

		return newMenu;
	}

	@Override
	public String getNextMenu() {

		return nextMenuName;
	}

	@Override
	public void setNewMenu() {
		
		this.newMenu = true;


	}
	@Override
	public void clearNextMenu(){

		this.nextMenuName = "";
	}

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
	private ArrayList<Tournament> tournaments = new ArrayList<Tournament>();
	
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
		public TournamentPanel(Tournament tourn, ArrayList<Tournament> tourns, int i){
			tournaments = tourns;
			thisTournament = tourn;
			index = i;
			getInfo();
			createItems();
			createButtons();
			createPanels();
		}
		/**
		 * This sets information for this object. This is a housekeeping method.
		 */
		private void getInfo(){
			numOfTeams = 0;//thisTournament.getTeamList().size();
	 		tournName = "Test";//thisTournament.getName();
	 		venueName = "TestVenue";//thisTournament.getVenue();
	 		startDate = "Date";//thisTournament.getStartDate();
	 		regDate = "Date";//thisTournament.getEndDate();
	 		tType = "Banana";//String.valueOf(thisTournament.getType());
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
			if(tType.equals("0")){		    structureLabel.setText("Structure: Unspecified");	}
			else if(tType.equals("1")){		structureLabel.setText("Structure: Single Elimination");	}
			else if(tType.equals("2")){		structureLabel.setText("Structure: Double Elimination");	}
			else 					{		structureLabel.setText("Structure: Divisions");	}
		}
		/**
		 * This creates buttons for this object. This is a housekeeping method.
		 */
		private void createButtons(){

			editButton = new JButton("Edit");
			editButton.setFont(new Font("Arial", Font.PLAIN, 16));
			editButton.addActionListener(new ActionListener()
				{
				  public void actionPerformed(ActionEvent e)
				  {
				  	//setNextMenu(true,"managermenu");

				  }
			});

			generateButton = new JButton("Generate");
			generateButton.setFont(new Font("Arial", Font.PLAIN, 16));
			generateButton.addActionListener(new ActionListener()
				{
				  public void actionPerformed(ActionEvent e)
				  {
				  	//setNextMenu(true,"managermenu");

				  }
			});

			teamsButton = new JButton("Teams List");
			teamsButton.setFont(new Font("Arial", Font.PLAIN, 16));
			teamsButton.addActionListener(new ActionListener()
				{
				  public void actionPerformed(ActionEvent e)
				  {
				  	setNextMenu(true,"teamlist");
				  }
			});

			deleteButton = new JButton("Delete");
			deleteButton.setFont(new Font("Arial", Font.PLAIN, 16));					
			deleteButton.addActionListener(new ActionListener()
				{
				  public void actionPerformed(ActionEvent e)
				  {
				  	//setNextMenu(true,"managermenu");

				  }
			});	
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
		/*
		class choiceListener implements ActionListener{
			public void actionPerformed(ActionEvent event){
				if(event.getSource() == generateButton){
					if(tType.equals("unspecified")){
						//JPanel jpan1 = new TournamentType(tournaments, index);
						//frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						//frame1.setVisible(true);
					}
					else{
						//JPanel jpan1 = new TournamentType(tournaments, index, tType);
						//frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						//frame1.setVisible(true);
					}
				}
				else if(event.getSource() == teamsButton){
	//				JFrame frame1 = new ListOfTeams(thisTournament, tournaments);
	//				frame1.setVisible(true);
				}
				else if(event.getSource() == deleteButton){
					System.out.println(newMenu);
					//tournaments.remove(index);
	//				JFrame frame1 = new ManageTournament(tournaments);
	//				frame1.setVisible(true);
				}
				else{	//event.getSource() == editButton
					//tournaments.remove(index);
					//JFrame frame1 = new CreateTournament(tournName, venueName, orgName, orgInfo, tournaments);
					//frame1.setVisible(true);
				}
			}
		}*/
		/**
		 * Creates panels for this object.
		 */
		private void createPanels(){
			borderlayout = new JPanel(new BorderLayout());
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

			borderlayout.add(gridlayout, BorderLayout.CENTER);
			borderlayout.add(btnPanel, BorderLayout.SOUTH);
			borderlayout.setBorder(BorderFactory.createRaisedBevelBorder());

			this.add(borderlayout);
		}
	}
}
