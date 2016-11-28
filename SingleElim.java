package skeletonCode;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.*;

public class SingleElim extends JPanel{
	private JPanel panel;
	private int numOfTeams;
	private int colnNum;
	private int spacers;
	private int side;
	private int top;
	private int bottom;
	private ArrayList<JTextArea> panList = new ArrayList<JTextArea>();

	public SingleElim(int n, int i){
		super();
		this.setBackground(Color.WHITE);
		colnNum = i;
		numOfTeams = n;
		spacers = (int) Math.pow(2, colnNum)-1;
		createPanel();
	}
	
	private void createPanel(){
		MatteBorder line;
		TitledBorder title;
		Border empty = BorderFactory.createEmptyBorder();
		title = BorderFactory.createTitledBorder(empty, "title");
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
/*		for(int k){
			for(int i = spacers; i < height+spacers; i++){
				line = BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black);
				panList.get(i).setBorder(line);
			}
*/		line = BorderFactory.createMatteBorder(1, 0, 0, 0, Color.black);
		panList.get(2*numOfTeams-spacers-2).setBorder(line);
		add(panel);
	}
}