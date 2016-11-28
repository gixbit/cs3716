package GUI;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.*;

public class CreateBracket extends JFrame{
	private JPanel panel;
	private JScrollPane area;
	private int numOfColns;
	private int numOfTeams;
	
	public CreateBracket(int teams){
		numOfTeams = teams;
		numOfColns = (int)(Math.log(numOfTeams)/Math.log(2));
		createPanels();
		setSize(451,676);
		setTitle("");
	}
	
	private void createPanels(){
		panel = new JPanel(new GridLayout(1,numOfColns,0,0));

		for(int i = 0; i < numOfColns+1; i++){
			panel.add(new SingleElim(numOfTeams, i));
		}		
		area = new JScrollPane(panel);
		add(area);
	}
}