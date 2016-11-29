package GUI;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.*;

public class SingleElim extends JPanel{
	private JPanel panel;
	private int numOfTeams;
	private int numOfColns;
	private int colnNum;
	private int spacers;
	private int side;
	private int top;
	private int bottom;
	private String teamName;
	private ArrayList<JTextArea> panList = new ArrayList<JTextArea>();

	public SingleElim(int n, int i, int c){
		super();
		this.setBackground(Color.WHITE);
//		this.setSize(450, 610);
		colnNum = i;
		numOfColns = c;
		numOfTeams = n;
		spacers = (int) Math.pow(2, colnNum)-1;
		createPanel();
	}
	
	private void createPanel(){
		MatteBorder line;
		TitledBorder title;
		Border empty = BorderFactory.createEmptyBorder();
		title = BorderFactory.createTitledBorder(empty, teamName);
		title.setTitlePosition(TitledBorder.RIGHT);

		panel = new JPanel(new GridLayout(2*numOfTeams-1, 1,0,0));
		//creates each column
		int height = (int)Math.pow(2, colnNum+1);
		for(int j = 0; j<2*numOfTeams-1; j++){
			panList.add(new JTextArea(2,8));
			if((j-spacers)%height == 0){
				top = 1;
				bottom = 0;
				side = 5;
			}
			else if((j-spacers)%height == height-1){
				top = 0;
				bottom = 1;
				side = 5;	
			}
			else{
				top = 0;
				bottom = 0;
				side = 5;
			}
			line = BorderFactory.createMatteBorder(top, 0, bottom, side, Color.black);
			panList.get(j).setBorder(line);
			if(j < spacers || j > 2*numOfTeams-spacers-2){
				line = BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black);
				panList.get(j).setBorder(line);
			}
			panList.get(j).setEditable(false);
			panel.add(panList.get(j));
		}
		for(int i = 0; i < (Math.pow(2,numOfColns-colnNum)-1); i++){
			for(int j = 0; j < height; j++){
				if(i%2 == 1){
					line = BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black);
					panList.get(spacers + i*height + j).setBorder(line);
				}
			}
		}
		line = BorderFactory.createMatteBorder(1, 0, 0, 0, Color.black);
		panList.get(2*numOfTeams-spacers-2).setBorder(line);
		add(panel);
	}
}