package GUI;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.*;

import SkeletonCode.Tournament;

/**
 * This class is for creating a Tournament
 * 
 * @author John Hollett
 * @author Keir Strickland Murphy
 * @author Rory Campbell
 * @author Jaimee Bessey
 * @author Kristan James Hart
 * @author Karl Chiasson
 */
public class CreateTournament extends JFrame {
	private JPanel finalPanel;
	private JPanel upperCentralPanel;
	private JPanel lowerCentralPanel;
	private JPanel trnNamePanel;
	private JPanel venuePanel;
	private JPanel oNamePanel;
	private JPanel oInfoPanel;
	private JPanel centerPanel;
	private JPanel southPanel;
	private JLabel trnNameLabel;
	private JLabel venueLabel;
	private JLabel regStartLabel;
	private JLabel regEndLabel;
	private JLabel organizerNameLabel;
	private JLabel organizerInfoLabel;
	private JLabel northPanel;
	private JTextField trnField;
	private JTextField venueField;
	private JTextField organizerNameField;
	private JTextField organizerInfoField;
	private JButton createButton;
	private JButton cancelButton;
	private DatePanel[] dates = new DatePanel[2];

	public CreateTournament() {
		createLabels();
		createFields();
		createButton();
		createPanel();
		setSize(550, 725);
		setTitle("Create Tournament");
	}

	public CreateTournament(String a, String b, String c, String d) {
		// get current date(month, day, year)
		createLabels();
		createFields(a, b, c, d);
		createButton();
		// createPanel(month, day, year)
		// input into datePanel
		// monthBox.setSelectedItem(m);
		// dayBox.setSelectedItem(d);
		// yearBox.setSelectedItem(y);
		createPanel();
		setSize(500, 600);
		setTitle("Create Tournament");
	}

	private void createLabels() {
		northPanel = new JLabel("Create Your Tournament", SwingConstants.CENTER);
		northPanel.setFont(new Font("Arial", Font.BOLD, 24));

		trnNameLabel = new JLabel("Tournament Name: ");
		trnNameLabel.setFont(new Font("Arial", Font.PLAIN, 16));

		venueLabel = new JLabel("Location: ");
		venueLabel.setFont(new Font("Arial", Font.PLAIN, 16));

		organizerNameLabel = new JLabel("Organizer Name: ");
		organizerNameLabel.setFont(new Font("Arial", Font.PLAIN, 16));

		organizerInfoLabel = new JLabel("Organizer Contact Info: ");
		organizerInfoLabel.setFont(new Font("Arial", Font.PLAIN, 16));

		regStartLabel = new JLabel("Tournament Start Date", SwingConstants.CENTER);
		regStartLabel.setFont(new Font("Arial", Font.PLAIN, 18));

		regEndLabel = new JLabel("Registration Closing Date", SwingConstants.CENTER);
		regEndLabel.setFont(new Font("Arial", Font.PLAIN, 18));
	}

	private void createFields() {
		trnField = new JTextField(26);
		trnField.setText("");

		venueField = new JTextField(32);
		venueField.setText("");

		organizerNameField = new JTextField(27);
		organizerNameField.setText("");

		organizerInfoField = new JTextField(23);
		organizerInfoField.setText("");
	}

	private void createFields(String t, String ven, String oName, String oInfo) {
		trnField = new JTextField(26);
		trnField.setText(t);

		venueField = new JTextField(32);
		venueField.setText(ven);

		organizerNameField = new JTextField(27);
		organizerNameField.setText(oName);

		organizerInfoField = new JTextField(23);
		organizerInfoField.setText(oInfo);
	}

	private void createButton() {
		ActionListener listener = new choiceListener();
		createButton = new JButton("Create");
		createButton.addActionListener(listener);
		createButton.setFont(new Font("Arial", Font.PLAIN, 16));

		cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(listener);
		cancelButton.setFont(new Font("Arial", Font.PLAIN, 16));
	}

	class choiceListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if (event.getSource() == cancelButton) {
				JFrame mainScrn = new MainScreen();
				mainScrn.setVisible(true);
				dispose();
			} else {
				// Checks for empty fields
				if (venueField.getText().isEmpty() || trnField.getText().isEmpty()) {
					String message = "Please fill all fields";
					JOptionPane.showMessageDialog(new JFrame(), message, "Dialog", JOptionPane.ERROR_MESSAGE);
				} // event.getSource() == createButton
				else {
					String startDate = (String) dates[0].getMonth() + " " + (String) dates[0].getDay() + ", " + (String) dates[0].getYear();
					String startTime = (String) dates[0].getHour() + ":" + (String) dates[0].getMin() + " " + (String) dates[0].getAmPm();
					String endDate = (String) dates[1].getMonth() + " " + (String) dates[1].getDay() + ", " + (String) dates[1].getYear();
					String endTime = (String) dates[1].getHour() + ":" + (String) dates[1].getMin() + " " + (String) dates[1].getAmPm();
					Viewer.Tournaments.add(new Tournament((String) trnField.getText(), startDate, endDate, (String) venueField.getText()));
					JFrame frame1 = new ManageTournament();
					frame1.setVisible(true);
					dispose();
				}
			}
		}
	}

	private void createPanel() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		finalPanel = new JPanel(new BorderLayout());
		upperCentralPanel = new JPanel(new GridLayout(4, 1));
		lowerCentralPanel = new JPanel(new GridLayout(4, 1));
		trnNamePanel = new JPanel();
		venuePanel = new JPanel();
		oNamePanel = new JPanel();
		oInfoPanel = new JPanel();
		centerPanel = new JPanel();
		southPanel = new JPanel();

		trnNamePanel.add(trnNameLabel);
		trnNamePanel.add(trnField);
		venuePanel.add(venueLabel);
		venuePanel.add(venueField);
		oNamePanel.add(organizerNameLabel);
		oNamePanel.add(organizerNameField);
		oInfoPanel.add(organizerInfoLabel);
		oInfoPanel.add(organizerInfoField);

		dates[0] = new DatePanel();
		dates[1] = new DatePanel();

		southPanel.add(cancelButton);
		southPanel.add(createButton);

		upperCentralPanel.add(trnNamePanel);
		upperCentralPanel.add(venuePanel);
		upperCentralPanel.add(oNamePanel);
		upperCentralPanel.add(oInfoPanel);

		lowerCentralPanel.add(regStartLabel);
		lowerCentralPanel.add(dates[0]);
		lowerCentralPanel.add(regEndLabel);
		lowerCentralPanel.add(dates[1]);

		centerPanel.add(upperCentralPanel);
		centerPanel.add(lowerCentralPanel);

		finalPanel.add(northPanel, BorderLayout.NORTH);
		finalPanel.add(centerPanel, BorderLayout.CENTER);
		finalPanel.add(southPanel, BorderLayout.SOUTH);
		add(finalPanel);
	}
}