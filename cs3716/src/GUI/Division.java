package GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.*;


public class Division extends JPanel {
	private JPanel buttonPanel;
	private JPanel areaPanel;
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
	
	public Division(int teams, int divs){
		teamsPerDiv = (int)(teams/divs + 1);
		for(int i = 0; teamsPerDiv > Math.pow(2,i); i++){
			teamSpaces = i+1;
		}
		teamsNum = (int) Math.pow(2,teamSpaces);
		numOfColns = (int)(Math.log(teamsNum)/Math.log(2));
		numOfDivs = divs;
		createButton();
		createPanels();
		setSize(451,676);
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
			//panel.add(new SingleElim(teamsNum, i, numOfColns));
		}
		MatteBorder line = BorderFactory.createMatteBorder(1,1,1,1, Color.black);
		panel.setBorder(line);
		
		return panel;
	}
	
	private void createPanels(){
		areaPanel = new JPanel(new GridLayout(numOfDivs,1));
		buttonPanel = new JPanel();
		this.setLayout(new BorderLayout());
		
		for(int j = 0; j < numOfDivs; j++){
			areaPanel.add(new JLabel("Division " + (j+1), SwingConstants.CENTER));
			areaPanel.add(createBracPanel());
		}
		buttonPanel.add(submitButton);
		this.add(greetingLabel, BorderLayout.NORTH);
		this.add(areaPanel, BorderLayout.CENTER);
		this.add(buttonPanel, BorderLayout.SOUTH);
		area = new JScrollPane(this);
		this.add(area);
	}
}