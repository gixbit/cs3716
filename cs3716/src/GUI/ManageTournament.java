package GUI;

import SkeletonCode.Tournament;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

public class ManageTournament extends JPanel implements PanelAccess {
	private JLabel headerLabel;
	private JButton newButton;
	private JButton homeButton;
	private JPanel northPanel;
	private JPanel tournamentsPanel;
	private JPanel btnPanel;
	private JScrollPane scrollFrame;
	private ArrayList<TournamentPanel> listOfTourns = new ArrayList<TournamentPanel>();
	private boolean newMenu = false;
	private String nextMenuName = "";

	public ManageTournament() {
		createItems();
		createButtons();
		createPanels();

	}

	private void createItems() {
		headerLabel = new JLabel("Manage Tournaments", SwingConstants.CENTER);
		headerLabel.setFont(new Font("Arial", Font.BOLD, 24));
	}

	private void createButtons() {

		homeButton = new JButton("Home");
		homeButton.setFont(new Font("Arial", Font.PLAIN, 16));
		homeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setNextMenu(true, "back");

			}
		});

		newButton = new JButton("Create New Tournament");
		newButton.setFont(new Font("Arial", Font.PLAIN, 16));
		newButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setNextMenu(true, "createtournament");
			}
		});
	}

	private void createPanels() {
		// panel = new JPanel(new BorderLayout());
		this.setLayout(new BorderLayout());
		northPanel = new JPanel(new GridLayout(2, 1));
		tournamentsPanel = new JPanel(new GridLayout(windowManager.Tournaments.size()+4, 1));
		btnPanel = new JPanel();

		northPanel.add(headerLabel);
		btnPanel.add(homeButton);
		btnPanel.add(newButton);
		northPanel.add(btnPanel);

		for (int i = 0; i < windowManager.Tournaments.size(); i++) {
			listOfTourns.add(new TournamentPanel(windowManager.Tournaments.get(i)));
			tournamentsPanel.add(listOfTourns.get(i));
		}

		scrollFrame = new JScrollPane(tournamentsPanel);

		this.add(northPanel, BorderLayout.NORTH);
		this.add(scrollFrame, BorderLayout.CENTER);
	}

	private void setNextMenu(boolean state, String next) {
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
	public void clearNextMenu() {

		this.nextMenuName = "";
	}

	public class TournamentPanel extends JPanel {
		private JLabel tournLabel;
		private JLabel venueLabel;
		private JLabel startDateLabel;
		private JLabel regDateLabel;
		private JLabel structureLabel;
		private JLabel numTeamsLabel;
		private JButton teamsButton;
		private JButton editButton;
		private JButton deleteButton;
		private JButton tTypeButton;
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
		private Tournament tournament;

		/**
		 * Constructor for a TournamentPanel, uses {@link #getInfo()},
		 * {@link #createItems()}, {@link #createButtons()} and
		 * {@link #createPanels()}, to create a TournamentPanel
		 * 
		 * <br>
		 * <br>
		 * Also takes a Tournament Object, ArrayList&ltTournament&gt, and an
		 * integer
		 * 
		 * @param tourn
		 *            - Tournament
		 * @param tourns
		 *            - ArrayList&ltTournament&gt
		 * @param i
		 *            - Integer
		 */
		public TournamentPanel(Tournament tourn) {
			tournament = tourn;
			getInfo();
			createItems();
			createButtons();
			createPanels();
		}

		/**
		 * This sets information for this object. This is a housekeeping method.
		 */
		private void getInfo() {
			numOfTeams = tournament.getTeamList().size();
			tournName = tournament.getName();
			venueName = tournament.getVenue();
			startDate = tournament.getStartDate();
			regDate = tournament.getEndDate();
			tType = String.valueOf(tournament.getType());
		}

		/**
		 * This creates JLabels for this object. This is a housekeeping method.
		 */
		private void createItems() {
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
			if (tType.equals("0")) {
				structureLabel.setText("Structure: Unspecified");
			} else if (tType.equals("1")) {
				structureLabel.setText("Structure: Single Elimination");
			} else if (tType.equals("2")) {
				structureLabel.setText("Structure: Double Elimination");
			} else {
				structureLabel.setText("Structure: Divisions");
			}
		}

		/**
		 * This creates buttons for this object. This is a housekeeping method.
		 */
		private void createButtons() {

			editButton = new JButton("Edit");
			editButton.setFont(new Font("Arial", Font.PLAIN, 16));
			editButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// setNextMenu(true,"managermenu");
					// TODO: KARL IS THINKING
					TournamentPanel p = (TournamentPanel) (((((JButton) e.getSource()).getParent()).getParent()).getParent());
				}
			});

			tTypeButton = new JButton("Generate");
			tTypeButton.setFont(new Font("Arial", Font.PLAIN, 16));
			tTypeButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// setNextMenu(true,"tTypeMenu");
					// TODO: KARL IS STILL THINKING
					TournamentPanel p = (TournamentPanel) (((((JButton) e.getSource()).getParent()).getParent()).getParent());
				}
			});

			teamsButton = new JButton("Teams List");
			teamsButton.setFont(new Font("Arial", Font.PLAIN, 16));
			teamsButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setNextMenu(true, "teamlist");
					//TODO: KARL IS BRAINDEAD
					TournamentPanel p = (TournamentPanel) (((((JButton) e.getSource()).getParent()).getParent()).getParent());
				}
			});

			deleteButton = new JButton("Delete");
			deleteButton.setFont(new Font("Arial", Font.PLAIN, 16));
			deleteButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// setNextMenu(true,"managermenu");
					TournamentPanel p = (TournamentPanel) (((((JButton) e.getSource()).getParent()).getParent()).getParent());
					windowManager.Tournaments.remove(p.tournament);
					listOfTourns.remove(p);
					revalidate();
					repaint();
				}
			});
		}

		/**
		 * Creates panels for this object.
		 */
		private void createPanels() {
			borderlayout = new JPanel(new BorderLayout());
			gridlayout = new JPanel(new GridLayout(4, 2));
			btnPanel = new JPanel();

			gridlayout.add(tournLabel);
			gridlayout.add(structureLabel);
			gridlayout.add(venueLabel);
			gridlayout.add(regDateLabel);
			gridlayout.add(numTeamsLabel);
			gridlayout.add(startDateLabel);

			btnPanel.add(editButton);
			btnPanel.add(deleteButton);
			btnPanel.add(tTypeButton);
			btnPanel.add(teamsButton);

			borderlayout.add(gridlayout, BorderLayout.CENTER);
			borderlayout.add(btnPanel, BorderLayout.SOUTH);
			borderlayout.setBorder(BorderFactory.createRaisedBevelBorder());

			this.add(borderlayout);
		}
	}
}
