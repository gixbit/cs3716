package GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.*;

import GUI.ListOfTeams.choiceListener;

public class CreateBracket extends JFrame{
	private JPanel panel;
	private JPanel finalPanel;
	private JPanel areaPanel;
	private JLabel greetingLabel;
	private JButton submitButton;
	private JScrollPane area;
	private int numOfColns;
	private int teamsNum;
	private int teamSpaces;
	
	public CreateBracket(int teams){
		for(int i = 0; teams > Math.pow(2,i); i++){
			teamSpaces = i+1;
		}
		teamsNum = (int) Math.pow(2,teamSpaces);
		numOfColns = (int)(Math.log(teamsNum)/Math.log(2));
		createButton();
		createPanels();
		setSize(451,676);
		setTitle("");
	}
	
	private void createButton(){
		greetingLabel = new JLabel("Bracket");
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
		panel = new JPanel(new GridLayout(1,numOfColns,0,0));
		areaPanel = new JPanel();
		finalPanel = new JPanel();

		for(int i = 0; i < numOfColns+1; i++){
			panel.add(new SingleElim(teamsNum, i, numOfColns));
		}		
		area = new JScrollPane(panel);
		areaPanel.add(area);
		finalPanel.add(greetingLabel);
		finalPanel.add(areaPanel);
		finalPanel.add(submitButton);
		add(finalPanel);
	}
}
