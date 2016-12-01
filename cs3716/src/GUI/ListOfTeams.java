package GUI;

import SkeletonCode.Tournament;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class ListOfTeams extends JPanel implements PanelAccess {
	private JTextArea listText;
	private JScrollPane listArea;
	private JLabel listLabel;
	private JLabel teamLabel;
	private JLabel teamName;
	private JPanel borderLayout;
	private JPanel btnPanel;
	private JPanel teamPanel;
	private JPanel northTeamPanel;
	private JPanel textPanel;
	private JButton contButton;
	private JButton regButton;
	private Tournament tour;
	private String tName;

	private boolean newMenu = false;
	private String nextMenuName = "";

	public ListOfTeams() {
		createItems();
		// createText(); Implement later
		createButton();
		createPanel();
		setSize(500, 500);
	}

	private void createItems() {
		listLabel = new JLabel("List Of Teams for Tournament: ", SwingConstants.CENTER);
		listLabel.setFont(new Font("Arial", Font.BOLD, 24));

		teamName = new JLabel(tName, SwingConstants.CENTER);
		teamName.setFont(new Font("Arial", Font.BOLD, 24));

		teamLabel = new JLabel("Team Name");
		teamLabel.setFont(new Font("Arial", Font.PLAIN, 16));

		listText = new JTextArea(19, 35);
		listText.setFont(new Font("Arial", Font.PLAIN, 16));
		listText.setEditable(false);
	}

	private void createText() {
		for (int i = 0; i < tour.getTeamList().size(); i++) {
			listText.append(tour.getTeamList().get(i).getTeamName() + "\n");
		}
	}

	private void createButton() {

		contButton = new JButton("Home");
		contButton.setFont(new Font("Arial", Font.PLAIN, 16));
		contButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setNextMenu(true, "back");

			}
		});

		regButton = new JButton("Register Another Team");
		regButton.setFont(new Font("Arial", Font.PLAIN, 16));
		regButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// setNextMenu(true,"managermenu");

			}
		});
	}

	private void createPanel() {
		this.setLayout(new BorderLayout());
		btnPanel = new JPanel();
		teamPanel = new JPanel(new GridLayout(1, 2));
		northTeamPanel = new JPanel(new GridLayout(3, 1));
		textPanel = new JPanel();

		textPanel.add(listText);
		listArea = new JScrollPane(textPanel);

		btnPanel.add(regButton);
		btnPanel.add(contButton);
		teamPanel.add(teamLabel);
		northTeamPanel.add(listLabel);
		northTeamPanel.add(teamName);
		northTeamPanel.add(teamPanel);

		this.add(northTeamPanel, BorderLayout.NORTH);
		this.add(listArea, BorderLayout.CENTER);
		this.add(btnPanel, BorderLayout.SOUTH);
	}

	private void setNextMenu(boolean state, String next) {
		newMenu = state;
		nextMenuName = next;
	}

	public boolean newMenu() {
		return newMenu;
	}

	public String getNextMenu() {
		return nextMenuName;
	}

	public void setNewMenu() {
		newMenu = false;
	}

	public void clearNextMenu() {
		nextMenuName = "";
	}
}
