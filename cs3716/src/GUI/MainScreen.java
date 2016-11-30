package GUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

import SkeletonCode.Tournament;

public class MainScreen extends JFrame {
	private JPanel panel;
	private JButton bracButton;
	private JButton organButton;
	private JButton coachButton;
	private ArrayList<Tournament> listOfTourns = new ArrayList<Tournament>();
	
	public MainScreen(){
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
		MainScreen mn = this;
		class choiceListener implements ActionListener{
			public void actionPerformed(ActionEvent event){
				if(event.getSource() == organButton){
					JPanel japan = new ManageTournament();
					mn.panel.setVisible(false);
					mn.add(japan);
					japan.setVisible(true);
					//frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					//frame1.setVisible(true);
					//dispose();
				}
				else if(event.getSource() == bracButton){
//					 japan.setVisible(true);
					//frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					//frame1.setVisible(true);
					//dispose();
				}
				else{//event.getSource() == CoachButton
					//Register reg = new Register(listOfTourns);
					//reg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					//reg.setVisible(true);
					//dispose();
					//The below solution works, but it gets rid of this panel too. Might be able to combine panels.
					/*
					mn.panel.setVisible(false);
					mn.panel = reg.finalPanel;
					mn.add(mn.panel);
					mn.panel.setVisible(true);
					*/
				}
			}
		}
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

	

	private void createPanel(){
		panel = new JPanel();
		panel.add(organButton);
		panel.add(coachButton);
		panel.add(bracButton);
		add(panel);
	}

}
