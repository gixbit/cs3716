package GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.*;

import GUI.ListOfTeams.choiceListener;
import SkeletonCode.Tournament;

public class CreateBracket extends JFrame{
	private JPanel panel;
	private JPanel buttonPanel;
	private JPanel areaPanel;
	private JPanel finalPanel;
	private JLabel greetingLabel;
	private JButton submitButton;
	private JScrollPane area;
	private int numOfColns;
	private int teamsNum;
	private int teamSpaces;
	private Tournament tournament;
	private int columnNum = 0;
	
	public CreateBracket(Tournament tourn){
		for(int i = 0; tourn.getTeamList().size() > Math.pow(2,i); i++){
			teamSpaces = i+1;
		}
		tournament = tourn;
		teamsNum = (int) Math.pow(2,teamSpaces);
		numOfColns = (int)(Math.log(teamsNum)/Math.log(2));
		createButton();
		createPanels();
		setSize(550,725);
		setTitle("");
	}
	
	private JPanel createColumn(int col){
		JPanel cPanel = new JPanel();
		columnNum = col;
		cPanel.add(new SingleElim(tournament, columnNum, numOfColns));
		columnNum++;
		return cPanel;
	}
	
	private void createButton(){
		greetingLabel = new JLabel("Bracket", SwingConstants.CENTER);
		greetingLabel.setFont(new Font("Arial", Font.BOLD, 24));
		
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

	private void createPanels(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		panel = new JPanel(new GridLayout(1,numOfColns,0,0));
		areaPanel = new JPanel();
		buttonPanel = new JPanel();
		finalPanel = new JPanel(new BorderLayout());

		panel = createColumn(columnNum);
/*		for(int i = 0; i < numOfColns+1; i++){
			panel.add(new SingleElim(tournament, i, numOfColns));
			//
		}
*/		areaPanel.add(panel);
		buttonPanel.add(submitButton);
		finalPanel.add(greetingLabel, BorderLayout.NORTH);
		finalPanel.add(areaPanel, BorderLayout.CENTER);
		finalPanel.add(buttonPanel, BorderLayout.SOUTH);
		area = new JScrollPane(finalPanel);
		add(area);
	}
}
