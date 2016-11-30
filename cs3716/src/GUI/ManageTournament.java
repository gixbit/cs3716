package GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import SkeletonCode.Tournament;

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
	private boolean menu;
	
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
		ActionListener listener = new choiceListener();
		newButton = new JButton("Create New Tournament");
		newButton.addActionListener(listener);
		newButton.setFont(new Font("Arial", Font.PLAIN, 16));	

		homeButton = new JButton("Home");
		homeButton.addActionListener(listener);
		homeButton.setFont(new Font("Arial", Font.PLAIN, 16));	
}

	class choiceListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			if(event.getSource() == homeButton){
				JFrame frame1 = new MainScreen(tournaments);
				frame1.setVisible(true);
			}
			else{//event.getSource() == newButton
				JFrame frame1 = new CreateTournament(tournaments);
				frame1.setVisible(true);
			}
		}
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
		
		for(int i=0; i < tournaments.size(); i++){
			listOfTourns.add(new TournamentPanel(tournaments.get(i), tournaments, i));
			panel2.add(listOfTourns.get(i));
		}
		scrollFrame = new JScrollPane(panel2);

		this.add(panel1, BorderLayout.NORTH);
		this.add(scrollFrame, BorderLayout.CENTER);
		
		//add(panel);
	}

	@Override
	public boolean newMenu() {
		return menu;
	}

	@Override
	public String getNextMenu() {
		return "";
	}

	@Override
	public void setNewMenu() {
		this.menu = true;
	}
}
