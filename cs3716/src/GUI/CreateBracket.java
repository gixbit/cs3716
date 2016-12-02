package GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.*;

import GUI.ListOfTeams.choiceListener;
import SkeletonCode.Tournament;

/**
 * This class is for creating Tournament brackets. <br>
 * Uses {@link SingleElim} JPanels in it.
 * 
 * @author John Hollett
 * @author Keir Strickland Murphy
 * @author Rory Campbell
 * @author Jaimee Bessey
 * @author Kristan James Hart
 * @author Karl Chiasson
 */
public class CreateBracket extends JFrame {
	private JPanel bracketPanel;
	private JPanel southPanel;
	private JPanel centerPanel;
	private JPanel finalPanel;
	private JButton submitBtn;
	private JLabel headerLabel;
	private JButton homeButton;
	private JScrollPane area;
	private int nColumns;
	private int nTeams;
	private int nSpaces;
	private Tournament tournament;
	private int columnNum = 0;

	public CreateBracket(Tournament tourn) {
		for (int i = 0; tourn.getTeamList().size() > Math.pow(2, i); i++) {
			nSpaces = i + 1;
		}
		tournament = tourn;
		nTeams = (int) Math.pow(2, nSpaces);
		nColumns = (int) (Math.log(nTeams) / Math.log(2));
		createButton();
		createPanels();
		setSize(550, 725);
		setTitle("");
	}
	
	private JPanel createColumn(int col){
		JPanel cPanel = new JPanel();
		columnNum = col;
		cPanel.add(new SingleElim(tournament, columnNum, nColumns));
		columnNum++;
		return cPanel;
	}

	private void createButton() {
		headerLabel = new JLabel("Bracket", SwingConstants.CENTER);
		headerLabel.setFont(new Font("Arial", Font.BOLD, 24));

		ActionListener listener = new choiceListener();
		submitBtn = new JButton("Submit");
		submitBtn.addActionListener(listener);
		submitBtn.setFont(new Font("Arial", Font.PLAIN, 16));
		

		homeButton = new JButton("Home");
		homeButton.addActionListener(listener);
		homeButton.setFont(new Font("Arial", Font.PLAIN, 16));	}

	class choiceListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			if(event.getSource() == homeButton){
				JFrame frame1 = new MainScreen();
				frame1.setVisible(true);
			}
			else{	//event.getSource() == submitBtn
				
			}
		}
	}

	private void createPanels(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		bracketPanel = new JPanel(new GridLayout(1,nColumns,0,0));
		centerPanel = new JPanel();
		southPanel = new JPanel();
		finalPanel = new JPanel(new BorderLayout());

		bracketPanel = createColumn(columnNum);
		/*		
		for(int i = 0; i < numOfColns+1; i++){
			panel.add(new SingleElim(tournament, i, numOfColns));
		}
		*/
		centerPanel.add(bracketPanel);
		southPanel.add(submitBtn);
		finalPanel.add(headerLabel, BorderLayout.NORTH);
		finalPanel.add(centerPanel, BorderLayout.CENTER);
		finalPanel.add(southPanel, BorderLayout.SOUTH);

		area = new JScrollPane(finalPanel);
		add(area);
	}
}
