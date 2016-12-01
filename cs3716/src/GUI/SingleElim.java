package GUI;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.text.JTextComponent;

import SkeletonCode.Bracket;
import SkeletonCode.Team;
import SkeletonCode.Tournament;

//import SkeletonCode.Team;

/**
 * SingleElimination represented as a JPanel.
 * 
 * @author John Hollett
 * @author Keir Strickland Murphy
 * @author Rory Campbell
 * @author Jaimee Bessey
 * @author Kristan James Hart
 * @author Karl Chiasson
 */
public class SingleElim extends JPanel{
	private JPanel panel;
	private int numOfTeams;
	private int numOfColns;
	private int colnNum;
	private int spacers;
	private int side = 5;
	private int top = 1;
	private int bottom = 1;
	private String teamName;
	private int teamSpaces;
	private Tournament tournament;
	private ArrayList<JComponent> panList = new ArrayList<JComponent>();
//	private ArrayList<Team> teamArray = new ArrayList<Team>();

//	numT needs to be replaced with an arrayList of teams and numOf divisions also need to be an input
	
	/**
	 * Constructor for SingleElimination.
	 * <br>
	 * Takes three integer parameters.
	 * 
	 * @param n - Integer
	 * @param i - Integer
	 * @param c - Integer
	 */
	public SingleElim(Tournament tourn, int coln, int numC){
		super();
		this.setBackground(Color.WHITE);
//		this.setSize(450, 610);
//		numOfTeams = numT.size();
		tournament = tourn;
		for(int i = 0; tournament.getTeamList().size() > Math.pow(2,i); i++){
			teamSpaces = i+1;
		}
		colnNum = coln;
		numOfColns = numC;
		numOfTeams = (int) Math.pow(2,teamSpaces);
		spacers = (int) Math.pow(2, colnNum);
		createBorders();
		createComboBoxes();
		createPanel();
	}
	
	/**
	 * Creates panels for this SingleElimination object.
	 */
	private void createBorders(){
		MatteBorder line;
		Border empty = BorderFactory.createEmptyBorder();

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
*/	//		else
			if((j-spacers)%height == height-1){
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
	
	private JPanel createBoxes(int i){
		JPanel menuPanel = new JPanel();
		ArrayList<String> array = new ArrayList<String>();
		Bracket b = tournament.getStructure().getBrackets().get(0);
		array.add(b.getGames().get(i).getTeamOne().getTeamName());
		array.add(b.getGames().get(i).getTeamTwo().getTeamName());
		JComboBox teamMenu = new JComboBox(array.toArray());
		JTextField scoreField = new JTextField(1);
		scoreField.setText("" + 0);
		
		menuPanel.add(teamMenu);
		menuPanel.add(scoreField);
		menuPanel.setBackground(Color.WHITE);
		return menuPanel;
	}
	private void createComboBoxes(){
		for(int i = 0; i <= numOfTeams/Math.pow(2,colnNum)-1; i++){
			int index = (int) (Math.pow(2, colnNum+1)*i + Math.pow(2, colnNum) - 1);
			panList.set(index, createBoxes(i));
		}
	}
	
	private void createPanel(){
		for(int j = 0; j < 2*numOfTeams; j++){
			panel.add(panList.get(j));
		}
		add(panel);
	}
}

	