<<<<<<< HEAD
package GUI;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.*;

import SkeletonCode.Tournament;

public class TournamentType extends JFrame{
	private JLabel headerLabel;
	private JLabel divLabel;
	private JLabel label1;
	private JLabel label2;
	private JTextField divField;
	private JComboBox bracketBox;
	private JButton submitButton;
	private JPanel panel;
	private JPanel panel1;
	private JPanel panel2;
	private JPanel panel3;
	private JPanel divPanel;
	private String tournamentName;
	private String stringTeams;
	private String tType;
	private int intTeams;
	private int tournIndex;
	private int numType;
	private int numOfDivs;
	private Tournament tournament;
	
	public TournamentType(int i){
		tournament = Viewer.Tournaments.get(i);
		tournIndex = i;
		getInfo();
		createItems();
		createButton();
		createPanel();
		setSize(550,725);
		setTitle("Create Tournament");
	}

	public TournamentType(int i, String type){
		tournament = Viewer.Tournaments.get(i);
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
		
		String[] bracketTypes = {"Single Elimination", "Divisions"};
		bracketBox = new JComboBox(bracketTypes);
		
		headerLabel = new JLabel("Create Tournament", SwingConstants.CENTER);
		headerLabel.setFont(new Font("Arial", Font.BOLD, 24));
		
		divLabel = new JLabel("How many divisions are needed? ", SwingConstants.CENTER);
		divLabel.setFont(new Font("Arial", Font.PLAIN, 16));

		label1 = new JLabel("There are " + stringTeams + " teams registered in " + tournamentName + ".", SwingConstants.CENTER);
		label1.setFont(new Font("Arial", Font.PLAIN, 16));
		
		label2 = new JLabel("Select a tournament type:");
		label2.setFont(new Font("Arial", Font.PLAIN, 16));
		
		divField = new JTextField(2);
		divField.setFont(new Font("Arial", Font.PLAIN, 16));

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
			JFrame frame1;
			int numOfDivs = Integer.valueOf(divField.getText());
			if(bracketBox.getSelectedItem().equals("Single Elimination")){tournament.createSingleElim();}
			else  {tournament.createDivisions(numOfDivs);}
			//TODO: FIX THIS
//			tournament.setType(numType);
			Viewer.Tournaments.set(tournIndex, tournament);
			if(tournament.getStructure().getStructureType() == 1){
				frame1 = new Division(Viewer.Tournaments.size(), numOfDivs);
			}
			else{
				frame1 = new CreateBracket(Viewer.Tournaments.size());
			}
			Viewer.Tournaments.set(tournIndex, tournament);
			listOfTourns.set(tournIndex, tournament);
			if(tournament.getStructure().getStructureType() == 1){
				frame1 = new Division(listOfTourns.size(), numOfDivs);
			}
			else{
				frame1 = new CreateBracket(listOfTourns.size());
			}
			frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			frame1.setVisible(true);
		}
	}

	private void createPanel(){
		panel = new JPanel(new BorderLayout());
		panel1 = new JPanel();
		panel2 = new JPanel(new GridLayout(3,1));
		panel3 = new JPanel();
		divPanel = new JPanel();
		
		divPanel.add(divLabel);
		divPanel.add(divField);
		
		panel1.add(label2);
		panel1.add(bracketBox);

		panel2.add(headerLabel);
		panel2.add(label1);
		panel2.add(panel1);
		
		panel3.add(submitButton);

		panel.add(panel2, BorderLayout.NORTH);
		panel.add(divPanel);
		panel.add(panel3, BorderLayout.SOUTH);
		
		add(panel);
	}
}
=======
package GUI;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.*;

import SkeletonCode.Tournament;

public class TournamentType extends JFrame{
	private JLabel headerLabel;
	private JLabel divLabel;
	private JLabel label1;
	private JLabel label2;
	private JTextField divField;
	private JComboBox bracketBox;
	private JButton submitButton;
	private JPanel panel;
	private JPanel panel1;
	private JPanel panel2;
	private JPanel panel3;
	private JPanel divPanel;
	private String tournamentName;
	private String stringTeams;
	private String tType;
	private int intTeams;
	private int tournIndex;
	private int numType;
	private int numOfDivs;
	private Tournament tournament;
	
	public TournamentType(int i){
		tournament = Viewer.Tournaments.get(i);
		tournIndex = i;
		getInfo();
		createItems();
		createButton();
		createPanel();
		setSize(550,725);
		setTitle("Create Tournament");
	}

	public TournamentType(int i, String type){
		tournament = Viewer.Tournaments.get(i);
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
		
		String[] bracketTypes = {"Single Elimination", "Divisions"};
		bracketBox = new JComboBox(bracketTypes);
		
		headerLabel = new JLabel("Create Tournament", SwingConstants.CENTER);
		headerLabel.setFont(new Font("Arial", Font.BOLD, 24));
		
		divLabel = new JLabel("How many divisions are needed? ", SwingConstants.CENTER);
		divLabel.setFont(new Font("Arial", Font.PLAIN, 16));

		label1 = new JLabel("There are " + stringTeams + " teams registered in " + tournamentName + ".", SwingConstants.CENTER);
		label1.setFont(new Font("Arial", Font.PLAIN, 16));
		
		label2 = new JLabel("Select a tournament type:");
		label2.setFont(new Font("Arial", Font.PLAIN, 16));
		
		divField = new JTextField(2);
		divField.setFont(new Font("Arial", Font.PLAIN, 16));

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
			JFrame frame1;
			int numOfDivs = Integer.valueOf(divField.getText());
			if(bracketBox.getSelectedItem().equals("Single Elimination")){tournament.createSingleElim();}
			else  {tournament.createDivisions(numOfDivs);}
			//TODO: FIX THIS
//			tournament.setType(numType);
			Viewer.Tournaments.set(tournIndex, tournament);
			if(tournament.getStructure().getStructureType() == 1){
				frame1 = new Division(Viewer.Tournaments.size(), numOfDivs);
			}
			else{
				frame1 = new CreateBracket(Viewer.Tournaments.size());
			}
			Viewer.Tournaments.set(tournIndex, tournament);
			frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			frame1.setVisible(true);
		}
	}

	private void createPanel(){
		panel = new JPanel(new BorderLayout());
		panel1 = new JPanel();
		panel2 = new JPanel(new GridLayout(3,1));
		panel3 = new JPanel();
		divPanel = new JPanel();
		
		divPanel.add(divLabel);
		divPanel.add(divField);
		
		panel1.add(label2);
		panel1.add(bracketBox);

		panel2.add(headerLabel);
		panel2.add(label1);
		panel2.add(panel1);
		
		panel3.add(submitButton);

		panel.add(panel2, BorderLayout.NORTH);
		panel.add(divPanel);
		panel.add(panel3, BorderLayout.SOUTH);
		
		add(panel);
	}
}
>>>>>>> branch 'master' of https://github.com/gixbit/cs3716.git
