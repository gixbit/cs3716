package GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import SkeletonCode.Tournament;

public class ManageTournament extends JPanel implements PanelAccess{
	private JLabel headerLabel;
	private JButton newTournBtn;
	private JButton homeButton;
	private JPanel northPanel;
	private JPanel centerPanel;
	private JPanel btnPanel;
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
		headerLabel = new JLabel("Manage Tournaments", SwingConstants.CENTER);
		headerLabel.setFont(new Font("Arial", Font.BOLD, 24));
	}
	
	private void createButtons(){
//		ActionListener listener = new choiceListener();
		newTournBtn = new JButton("Create New Tournament");
//		newTournBtn.addActionListener(listener);
//		newTournBtn.setFont(new Font("Arial", Font.PLAIN, 16));	

		homeButton = new JButton("Home");
//		homeButton.addActionListener(listener);
//		homeButton.setFont(new Font("Arial", Font.PLAIN, 16));	
}

//	class choiceListener implements ActionListener{
//		public void actionPerformed(ActionEvent event){
//			if(event.getSource() == homeButton){
//				JFrame frame1 = new MainScreen(tournaments);
//				frame1.setVisible(true);
//			}
//			else{//event.getSource() == newButton
//				JFrame frame1 = new CreateTournament(tournaments);
//				frame1.setVisible(true);
//			}
//		}
//	}

	private void createPanels() {
		this.setLayout( new BorderLayout() );
		northPanel = new JPanel( new GridLayout(2, 1) );
		centerPanel = new JPanel( new GridLayout(numOfTourns, 1) );
		btnPanel = new JPanel();

		northPanel.add(headerLabel);
		btnPanel.add(homeButton);
		btnPanel.add(newTournBtn);
		northPanel.add(btnPanel);
		
		for(int i=0; i < tournaments.size(); i++){
			listOfTourns.add(new TournamentPanel(tournaments.get(i)));
			centerPanel.add(listOfTourns.get(i));
		}
		scrollFrame = new JScrollPane(centerPanel);

		this.add(northPanel, BorderLayout.NORTH);
		this.add(scrollFrame, BorderLayout.CENTER);
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
