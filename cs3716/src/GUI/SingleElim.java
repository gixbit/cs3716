package GUI;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.text.JTextComponent;

import SkeletonCode.Team;

/**
 * SingleElimination represented as a JPanel.
 * 
 * @author John Hollett
 * @author Keir Strickland Murphy
 * @author Rory Campbell
 * @author Jaimee Bessey
 * @author Kristan James Hart
 * @author Karl Chiasson *
 */
public class SingleElim extends JPanel{
	private JPanel panel;
	private JComboBox teamMenu;
	private int numOfTeams;
	private int numOfColns;
	private int colnNum;
	private int spacers;
<<<<<<< HEAD
	private int side = 5;
	private int top = 1;
	private int bottom = 1;
	private String teamName;
	private ArrayList<JComponent> panList = new ArrayList<JComponent>();
	private ArrayList<Team> teamArray = new ArrayList<Team>();
=======
	private int side;
	private int top;
	private int bottom;
	private String teamName;
	private ArrayList<JTextArea> panList = new ArrayList<JTextArea>();
>>>>>>> refs/remotes/origin/master

<<<<<<< HEAD
//	numT needs to be replaced with an arrayList of teams and numOf divisions also need to be an input
	public SingleElim(int numT, int coln, int numC){
=======
	/**
	 * Constructor for SingleElimination.
	 * <br>
	 * Takes three integer parameters.
	 * 
	 * @param n - Integer
	 * @param i - Integer
	 * @param c - Integer
	 */
	public SingleElim(int n, int i, int c){
>>>>>>> refs/remotes/origin/master
		super();
		this.setBackground(Color.WHITE);
<<<<<<< HEAD
//		numOfTeams = numT.size();
		colnNum = coln;
		numOfColns = numC;
		numOfTeams = numT;
		spacers = (int) Math.pow(2, colnNum);
		createBorders();
		createComboBoxes();
=======
//		this.setSize(450, 610);
		colnNum = i;
		numOfColns = c;
		numOfTeams = n;
		spacers = (int) Math.pow(2, colnNum)-1;
>>>>>>> refs/remotes/origin/master
		createPanel();
	}
	
<<<<<<< HEAD
	private void createBorders(){
=======
	/**
	 * Creates panels for this SingleElimination object.
	 */
	private void createPanel(){
>>>>>>> refs/remotes/origin/master
		MatteBorder line;
		Border empty = BorderFactory.createEmptyBorder();
<<<<<<< HEAD
=======
		title = BorderFactory.createTitledBorder(empty, teamName);
		title.setTitlePosition(TitledBorder.RIGHT);
>>>>>>> refs/remotes/origin/master

		panel = new JPanel(new GridLayout(2*numOfTeams, 1,0,0));
		//creates each column
		int height = (int)Math.pow(2, colnNum+1);
		for(int j = 0; j<2*numOfTeams; j++){
			panList.add(new JTextArea(2,8));
			//Removes line in between a match 
/*			if((j-spacers)%height == 0){
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
*/				top = 0;
				bottom = 0;
				side = 5;
//			}
			line = BorderFactory.createMatteBorder(top, 0, bottom, side, Color.black);
			panList.get(j).setBorder(line);
			//removes side bar from blocks in spacing area
			if(j < spacers || j > 2*numOfTeams-spacers){
				line = BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black);
				panList.get(j).setBorder(line);
			}
			((JTextComponent) panList.get(j)).setEditable(false);
		}
		//Removes blocks that are not suppose to connect teams
		for(int i = 0; i < (Math.pow(2,numOfColns-colnNum)-1); i++){
			for(int j = 0; j < height; j++){
				if(i%2 == 1){
					line = BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black);
					panList.get(spacers + i*height + j).setBorder(line);
				}
			}
		}
/*		if(numOfColns == colnNum){
			line = BorderFactory.createMatteBorder(1, 0, 0, 0, Color.black);
			panList.get(2*numOfTeams-spacers).setBorder(line);
		}
		else{
*/			line = BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black);
			panList.get(2*numOfTeams-spacers).setBorder(line);
//		}
	}
	
	private void createComboBoxes(){
//		teamMenu = new JComboBox(teamArray);
		for(int i = 0; i <= numOfTeams/Math.pow(2,colnNum)-1; i++){
			int index = (int) (Math.pow(2, colnNum+1)*i + Math.pow(2, colnNum) - 1);
			panList.set(index, new JComboBox());
		}
	}
	
	private void createPanel(){
		for(int j = 0; j<2*numOfTeams; j++){
			panel.add(panList.get(j));
		}
<<<<<<< HEAD
=======
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
>>>>>>> refs/remotes/origin/master
		add(panel);
	}
}

	