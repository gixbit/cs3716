package GUI;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.*;

import SkeletonCode.Tournament;

public class CreateTournament extends JFrame{
	private JPanel borderPanel;
	private JPanel tournGridPanel;
	private JPanel dateGridPanel;
	private JPanel tournPanel;
	private JPanel venuePanel;
	private JPanel orgNamePanel;
	private JPanel orgInfoPanel;
	private JPanel centerPanel;
	private JPanel btnPanel;
	private JLabel tournLabel;
	private JLabel venueLabel;
	private JLabel dateLabel;
	private JLabel regDateLabel;
	private JLabel organizerNameLabel;
	private JLabel organizerInfoLabel;
	private JLabel greetingLabel;
	private JTextField tournField;
	private JTextField venueField;
	private JTextField organizerNameField;
	private JTextField organizerInfoField;
	private JButton createButton;
	private JButton cancelButton;
	private DatePanel[] dates = new DatePanel[2];
	private ArrayList<Tournament> tournaments = new ArrayList<Tournament>();
			
	public CreateTournament(){
		createLabels();
		createFields();
		createButton();
		createPanel();
		setSize(500,600);
		setTitle("Create Tournament");
	}

	public CreateTournament(ArrayList<Tournament> tourn){
		tournaments = tourn;
		createLabels();
		createFields();
		createButton();
		createPanel();
		setSize(500,600);
		setTitle("Create Tournament");
	}
	
	public CreateTournament(String a, String b, String c, String d, ArrayList<Tournament> tourn){
		//get current date(month, day, year)
		tournaments = tourn;
		createLabels();
		createFields(a,b,c,d);
		createButton();
		//createPanel(month, day, year)
		//input into datePanel
		//monthBox.setSelectedItem(m);
		//dayBox.setSelectedItem(d);
		//yearBox.setSelectedItem(y);
		createPanel();
		setSize(500,600);
		setTitle("Create Tournament");
	}
	
	private void createLabels(){
		greetingLabel = new JLabel("Create Your Tournament", SwingConstants.CENTER);
		greetingLabel.setFont(new Font("Arial", Font.BOLD, 24));
		
		tournLabel = new JLabel("Tournament Name: ");
		tournLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		
		venueLabel = new JLabel("Location: ");
		venueLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		
		organizerNameLabel = new JLabel("Organizer Name: ");
		organizerNameLabel.setFont(new Font("Arial", Font.PLAIN, 16));

		organizerInfoLabel = new JLabel("Organizer Contact Info: ");
		organizerInfoLabel.setFont(new Font("Arial", Font.PLAIN, 16));

		dateLabel = new JLabel("Tournament Start Date", SwingConstants.CENTER);
		dateLabel.setFont(new Font("Arial", Font.PLAIN, 18));
		
		regDateLabel = new JLabel("Registration Closing Date", SwingConstants.CENTER);
		regDateLabel.setFont(new Font("Arial", Font.PLAIN, 18));
	}
	
	private void createFields(){
		tournField = new JTextField(26);
		tournField.setText("");

		venueField = new JTextField(32);
		venueField.setText("");

		organizerNameField = new JTextField(27);
		organizerNameField.setText("");

		organizerInfoField = new JTextField(23);
		organizerInfoField.setText("");
	}

	private void createFields(String t, String ven, String oName, String oInfo){
		tournField = new JTextField(26);
		tournField.setText(t);

		venueField = new JTextField(32);
		venueField.setText(ven);

		organizerNameField = new JTextField(27);
		organizerNameField.setText(oName);

		organizerInfoField = new JTextField(23);
		organizerInfoField.setText(oInfo);
	}
	
	private void createButton(){
		ActionListener listener = new choiceListener();
		createButton = new JButton("Create");
		createButton.addActionListener(listener);
		createButton.setFont(new Font("Arial", Font.PLAIN, 16));	

		cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(listener);
		cancelButton.setFont(new Font("Arial", Font.PLAIN, 16));	
	}
	
	class choiceListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			if(event.getSource() == cancelButton){
				JFrame frame1 = new MainScreen(tournaments);
				frame1.setVisible(true);
				dispose();
			}
			else{	//event.getSource() == createButton
				String startDate = (String)dates[0].getMonth() + " " + (String)dates[0].getDay() + ", " + (String)dates[0].getYear();
				String startTime = (String)dates[0].getHour() + ":" + (String)dates[0].getMin() + " " + (String)dates[0].getAmPm();
				String endDate = (String)dates[1].getMonth() + " " + (String)dates[1].getDay() + ", " + (String)dates[1].getYear();
				String endTime = (String)dates[1].getHour() + ":" + (String)dates[1].getMin() + " " + (String)dates[1].getAmPm();
				tournaments.add(new Tournament((String)tournField.getText(), startDate, endDate, (String)venueField.getText(), 0));
				//JFrame frame1 = new ManageTournament(tournaments);
				//frame1.setVisible(true);
				dispose();
			}
		}
	}
	
	private void createPanel() {
		borderPanel = new JPanel(new BorderLayout());
		tournGridPanel = new JPanel(new GridLayout(4,1));
		dateGridPanel = new JPanel(new GridLayout(4,1));
		tournPanel = new JPanel();
		venuePanel = new JPanel();
		orgNamePanel = new JPanel();
		orgInfoPanel = new JPanel();
		centerPanel = new JPanel();
		btnPanel = new JPanel();
		
		tournPanel.add(tournLabel);
		tournPanel.add(tournField);
		venuePanel.add(venueLabel);
		venuePanel.add(venueField);
		orgNamePanel.add(organizerNameLabel);
		orgNamePanel.add(organizerNameField);
		orgInfoPanel.add(organizerInfoLabel);
		orgInfoPanel.add(organizerInfoField);

		dates[0] = new DatePanel();
		dates[1] = new DatePanel();
		
		btnPanel.add(cancelButton);
		btnPanel.add(createButton);

		tournGridPanel.add(tournPanel);
		tournGridPanel.add(venuePanel);
		tournGridPanel.add(orgNamePanel);
		tournGridPanel.add(orgInfoPanel);

		dateGridPanel.add(dateLabel);
		dateGridPanel.add(dates[0]);
		dateGridPanel.add(regDateLabel);
		dateGridPanel.add(dates[1]);

		centerPanel.add(tournGridPanel);
		centerPanel.add(dateGridPanel);
		
		borderPanel.add(greetingLabel, BorderLayout.NORTH);
		borderPanel.add(centerPanel, BorderLayout.CENTER);
		borderPanel.add(btnPanel, BorderLayout.SOUTH);
		add(borderPanel);
	}

	public ArrayList<Tournament> getTournaments(){
		return tournaments;
	}
}