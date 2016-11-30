package GUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

import skeletonCode.Tournament;

public class MainScreen extends JFrame{
	private JPanel panel;
	private JButton bracButton;
	private JButton organButton;
	private JButton coachButton;
	private ArrayList<Tournament> listOfTourns = new ArrayList<Tournament>();
	private int numOfTeams;
	private int numOfDivs = 3;
	
	public MainScreen(){
		numOfTeams = 13;
		createItems();
		createPanel();
		setSize(500,500);
		setTitle("");
	}

	public MainScreen(ArrayList<Tournament> lTourns){
		listOfTourns = lTourns;
		createItems();
		createPanel();
		setSize(500,500);
		setTitle("");
	}

	private void createItems(){
		ActionListener listener = new choiceListener();
		organButton = new JButton("Organizers");
		organButton.addActionListener(listener);
		organButton.setFont(new Font("Arial", Font.PLAIN, 16));
		
		coachButton = new JButton("Coaches");
		coachButton.addActionListener(listener);
		coachButton.setFont(new Font("Arial", Font.PLAIN, 16));

		bracButton = new JButton("Brackets");
		bracButton.addActionListener(listener);
		bracButton.setFont(new Font("Arial", Font.PLAIN, 16));
	}

	class choiceListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			if(event.getSource() == organButton){
				JFrame frame1 = new ManageTournament(listOfTourns);
//				frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame1.setVisible(true);
				dispose();
			}
			else if(event.getSource() == bracButton){
				JFrame frame1 = new CreateBracket(numOfTeams);
//				JFrame frame1 = new Division(numOfTeams, numOfDivs);
				frame1.setVisible(true);
				dispose();
			}
			else{//event.getSource() == CoachButton
				JFrame frame1 = new Register(listOfTourns);
				frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame1.setVisible(true);
				dispose();
			}
		}
	}

	private void createPanel(){
		panel = new JPanel();
		
		panel.add(organButton);
		panel.add(coachButton);
		panel.add(bracButton);
		add(panel);
	}

}
