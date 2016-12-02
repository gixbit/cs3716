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
 * This class is for creating Divisions within the GUI
 * <br>
 * Uses {@link SingleElim} JPanels in it.
 * 
 * @author John Hollett
 * @author Keir Strickland Murphy
 * @author Rory Campbell
 * @author Jaimee Bessey
 * @author Kristan James Hart
 * @author Karl Chiasson
 */
public class Division extends JFrame {
	private JPanel southPanel;
	private JPanel centerPanel;
	private JPanel finalPanel;
	private JLabel northPanel;
	private JLabel divLabel;
	private JButton submitButton;
	private JScrollPane area;
	private int nColumns;
	private int nDivisions;
	private int nTeams;
	private int nSpaces;
	private int nTeamsPerDivision;
	private ArrayList<JPanel> bracketPanel = new ArrayList<JPanel>();

	public Division(Tournament tourn, int divs) {
		nTeamsPerDivision = (int) (tourn.getTeamList().size() / divs + 1);
		for (int i = 0; nTeamsPerDivision > Math.pow(2, i); i++) {
			nSpaces = i + 1;
		}
		nTeams = (int) Math.pow(2, nSpaces);
		nColumns = (int) (Math.log(nTeams) / Math.log(2));
		nDivisions = divs;
		createButton();
		createPanels();
		setSize(550, 725);
		setTitle("");
	}

	private void createButton() {
		northPanel = new JLabel("Bracket", SwingConstants.CENTER);
		northPanel.setFont(new Font("Arial", Font.BOLD, 24));

		divLabel = new JLabel("Division", SwingConstants.CENTER);
		divLabel.setFont(new Font("Arial", Font.BOLD, 24));

		ActionListener listener = new choiceListener();
		submitButton = new JButton("Submit");
		submitButton.addActionListener(listener);
		submitButton.setFont(new Font("Arial", Font.PLAIN, 16));
	}

	class choiceListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			JFrame frame1 = new popUp();
			frame1.setVisible(true);
		}
	}

	private JPanel createBracPanel() {
		JPanel bracketPanel = new JPanel(new GridLayout(1, nColumns, 0, 0));
		for (int i = 0; i < nColumns + 1; i++) {
			// TODO: FIX THIS
			bracketPanel.add(new SingleElim(nTeams, i, nColumns));
		}
		MatteBorder line = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black);
		bracketPanel.setBorder(line);

		return bracketPanel;
	}

	private void createPanels() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		centerPanel = new JPanel(new GridLayout(nDivisions, 1));
		southPanel = new JPanel();
		finalPanel = new JPanel(new BorderLayout());

		for (int j = 0; j < nDivisions; j++) {
			centerPanel.add(new JLabel("Division " + (j + 1), SwingConstants.CENTER));
			centerPanel.add(createBracPanel());
		}
		southPanel.add(submitButton);
		finalPanel.add(northPanel, BorderLayout.NORTH);
		finalPanel.add(centerPanel, BorderLayout.CENTER);
		finalPanel.add(southPanel, BorderLayout.SOUTH);
		area = new JScrollPane(finalPanel);
		add(area);
	}
}