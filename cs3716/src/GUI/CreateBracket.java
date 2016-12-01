package GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import SkeletonCode.Tournament;

public class CreateBracket extends JPanel {
	private JPanel panel;
	private JPanel areaPanel;
	private JLabel greetingLabel;
	private JButton submitButton;
	private JScrollPane area;
	private int numOfColns; // Do not fix
	private int teamsNum; // Do not fix
	private int teamSpaces; // Do not fix
	private Tournament tournament;

	public CreateBracket(Tournament t) {
		this.tournament = t;
		for (int i = 0; t.getTeamList().size() > Math.pow(2, i); i++) {
			teamSpaces = i + 1;
		}
		teamsNum = (int) Math.pow(2, teamSpaces);
		numOfColns = (int) (Math.log(teamsNum) / Math.log(2));
		createButton();
		createPanels();
		setSize(451, 676);
	}

	private void createButton() {
		greetingLabel = new JLabel("Bracket");
		greetingLabel.setFont(new Font("Arial", Font.BOLD, 24));

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

	private void createPanels() {
		panel = new JPanel(new GridLayout(1, numOfColns, 0, 0));
		areaPanel = new JPanel();
		// finalPanel = new JPanel();

		for (int i = 0; i < numOfColns + 1; i++) {
			panel.add(new SingleElim(this.tournament, teamsNum, i, numOfColns));
		}
		area = new JScrollPane(panel);
		areaPanel.add(area);
		this.add(greetingLabel);
		this.add(areaPanel);
		this.add(submitButton);
		// add(finalPanel);
	}
}
