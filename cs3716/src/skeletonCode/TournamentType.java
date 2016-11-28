package skeletonCode;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class TournamentType extends JFrame{
	private JLabel headerLabel;
	private JLabel label1;
	private JLabel label2;
	private JComboBox bracketBox;
	private JButton submitButton;
	private JPanel panel;
	private JPanel panel1;
	private JPanel panel2;
	private JPanel panel3;
	private String tournamentName;
	private String stringTeams;
	private String tType;
	private int intTeams;
	private int tournIndex;
	private int numType;
	private Tournament tournament;
	private ArrayList<Tournament> listOfTourns = new ArrayList<Tournament>();
	
	public TournamentType(ArrayList<Tournament> t, int i){
		listOfTourns = t;
		tournament = t.get(i);
		tournIndex = i;
		getInfo();
		createItems();
		createButton();
		createPanel();
		setSize(500,500);
		setTitle("Create Tournament");
	}

	public TournamentType(ArrayList<Tournament> t, int i, String type){
		listOfTourns = t;
		tournament = t.get(i);
		tournIndex = i;
		tType = type;
		getInfo();
		createItems();
		createButton();
		createPanel();
		setSize(500,500);
		setTitle("Create Tournament");
	}
	
	public void getInfo(){
		tournamentName = "TOURNAMENT NAME";
		tournamentName = tournament.getName();
//		intTeams = teams.size();	
		intTeams = 0;
	}
	
	private void createItems(){
		stringTeams = Integer.toString(intTeams);
		
		String[] bracketTypes = {"Single Elimination", "Double Elimination", "Divisions"};
		bracketBox = new JComboBox(bracketTypes);
		
		headerLabel = new JLabel("Create Tournament", SwingConstants.CENTER);
		headerLabel.setFont(new Font("Arial", Font.BOLD, 24));

		label1 = new JLabel("There are " + stringTeams + " teams registered in " + tournamentName + ".", SwingConstants.CENTER);
		label1.setFont(new Font("Arial", Font.PLAIN, 16));
		
		label2 = new JLabel("Select a tournament type:");
		label2.setFont(new Font("Arial", Font.PLAIN, 16));	
	}
	
	private void createButton(){
		ActionListener listener = new choiceListener();
		submitButton = new JButton("Submit");
		submitButton.addActionListener(listener);
		submitButton.setFont(new Font("Arial", Font.PLAIN, 16));
	}
	
	class choiceListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			//set type of tournament
			if(bracketBox.getSelectedItem().equals("Single Elimination")){numType = 1;}
			else if(bracketBox.getSelectedItem().equals("Double Elimination")){numType = 2;}
			else  {numType = 3;}
			tournament.setType(numType);
			listOfTourns.set(tournIndex, tournament);
			JFrame frame1 = new ManageTournament(listOfTourns);
			frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame1.setVisible(true);
		}
	}

	private void createPanel(){
		panel = new JPanel(new BorderLayout());
		panel1 = new JPanel();
		panel2 = new JPanel(new GridLayout(3,1));
		panel3 = new JPanel();

		panel1.add(label2);
		panel1.add(bracketBox);

		panel2.add(headerLabel);
		panel2.add(label1);
		panel2.add(panel1);
		
		panel3.add(submitButton);

		panel.add(panel2, BorderLayout.NORTH);
		panel.add(panel3, BorderLayout.SOUTH);
		
		add(panel);
	}
}
