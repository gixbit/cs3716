package GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.*;

import GUI.ListOfTeams.choiceListener;
import SkeletonCode.Tournament;

public class Division extends JFrame{
	private JPanel buttonPanel;
	private JPanel areaPanel;
	private JPanel finalPanel;
	private JLabel greetingLabel;
	private JLabel divLabel;
	private JButton submitButton;
	private JScrollPane area;
	private int numOfColns;
	private int numOfDivs;
	private int teamsNum;
	private int teamSpaces;
	private int teamsPerDiv;
	private ArrayList<JPanel> bracketPanel = new ArrayList<JPanel>();
	
	public Division(Tournament tourn, int divs){
		ArrayList<Tournament> listOfTourns = Viewer.Tournaments;
		teamsPerDiv = (int)(tourn.getTeamList().size()/divs + 1);
		for(int i = 0; teamsPerDiv > Math.pow(2,i); i++){
			teamSpaces = i+1;
		}
		teamsNum = (int) Math.pow(2,teamSpaces);
		numOfColns = (int)(Math.log(teamsNum)/Math.log(2));
		numOfDivs = divs;
		createButton();
		createPanels();
		setSize(550,725);
		setTitle("");
	}
	
	private void createButton(){
		greetingLabel = new JLabel("Bracket", SwingConstants.CENTER);
		greetingLabel.setFont(new Font("Arial", Font.BOLD, 24));

		divLabel = new JLabel("Division", SwingConstants.CENTER);
		divLabel.setFont(new Font("Arial", Font.BOLD, 24));

		ActionListener listener = new choiceListener();
		submitButton = new JButton("Submit");
		submitButton.addActionListener(listener);
		submitButton.setFont(new Font("Arial", Font.PLAIN, 16));
	}

	class choiceListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			JFrame frame1 = new popUp();
			frame1.setVisible(true);
		}
	}
	
	private JPanel createBracPanel(){
		JPanel panel = new JPanel(new GridLayout(1,numOfColns,0,0));
		for(int i = 0; i < numOfColns+1; i++){
			//TODO: FIX THIS
			panel.add(new SingleElim(teamsNum, i, numOfColns));
		}
		MatteBorder line = BorderFactory.createMatteBorder(1,1,1,1, Color.black);
		panel.setBorder(line);
		
		return panel;
	}
	
	private void createPanels(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		areaPanel = new JPanel(new GridLayout(numOfDivs,1));
		buttonPanel = new JPanel();
		finalPanel = new JPanel(new BorderLayout());
		
		for(int j = 0; j < numOfDivs; j++){
			areaPanel.add(new JLabel("Division " + (j+1), SwingConstants.CENTER));
			areaPanel.add(createBracPanel());
		}
		buttonPanel.add(submitButton);
		finalPanel.add(greetingLabel, BorderLayout.NORTH);
		finalPanel.add(areaPanel, BorderLayout.CENTER);
		finalPanel.add(buttonPanel, BorderLayout.SOUTH);
		area = new JScrollPane(finalPanel);
		add(area);
	}
}