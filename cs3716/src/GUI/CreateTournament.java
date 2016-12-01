package GUI;

import SkeletonCode.Tournament;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.*;



public class CreateTournament extends JPanel implements PanelAccess {
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
	
	private boolean newMenu = false;
	private String nextMenuName = "";
	private Tournament tournament;
	
	public CreateTournament(){
		createLabels();
		createFields();
		createButton();
		createPanel();
	}
	
	public CreateTournament(Tournament t){
		//get current date(month, day, year)
		this.tournament = t;
		createLabels();
		//TODO: ORGANIZER NAME AND INFO IS MISSING
		createFields(t.getName(),t.getVenue(),"","");
		createButton();
		//createPanel(month, day, year)
		//input into datePanel
		//monthBox.setSelectedItem(m);
		//dayBox.setSelectedItem(d);
		//yearBox.setSelectedItem(y);
		createPanel();
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
		createFields("","","","");
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
		//ActionListener listener = new choiceListener();
		String edit = "Create";
		if(tournament != null) {
			edit = "Edit";
		}
		createButton = new JButton(edit);
		createButton.setFont(new Font("Arial", Font.PLAIN, 16));	
		createButton.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e)  {
					String startDate = (String)dates[0].getMonth() + " " + (String)dates[0].getDay() + ", " + (String)dates[0].getYear();
					String startTime = (String)dates[0].getHour() + ":" + (String)dates[0].getMin() + " " + (String)dates[0].getAmPm();
					String endDate = (String)dates[1].getMonth() + " " + (String)dates[1].getDay() + ", " + (String)dates[1].getYear();
					String endTime = (String)dates[1].getHour() + ":" + (String)dates[1].getMin() + " " + (String)dates[1].getAmPm();
					if(tournament == null) {
						windowManager.Tournaments.add(new Tournament((String)tournField.getText(), startDate, endDate, (String)venueField.getText(), 0));
					} else {
						tournament.setName((String)tournField.getText());
						tournament.setStartDate(startDate);
						tournament.setEndDate(endDate);
						tournament.setVenue((String)venueField.getText());
					}
					setNextMenu(true,"back");
					}
				}
			);

		cancelButton = new JButton("Cancel");
		cancelButton.setFont(new Font("Arial", Font.PLAIN, 16));
		cancelButton.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setNextMenu(true,"back");
				}
			
			});
	}
	
	/*
	class choiceListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			if(event.getSource() == cancelButton){
				setNextMenu(true, "back");
			}
			else{	//event.getSource() == createButton
				String startDate = (String)dates[0].getMonth() + " " + (String)dates[0].getDay() + ", " + (String)dates[0].getYear();
				String startTime = (String)dates[0].getHour() + ":" + (String)dates[0].getMin() + " " + (String)dates[0].getAmPm();
				String endDate = (String)dates[1].getMonth() + " " + (String)dates[1].getDay() + ", " + (String)dates[1].getYear();
				String endTime = (String)dates[1].getHour() + ":" + (String)dates[1].getMin() + " " + (String)dates[1].getAmPm();
				tournaments.add(new Tournament((String)tournField.getText(), startDate, endDate, (String)venueField.getText(), 0));
				//JFrame frame1 = new ManageTournament(tournaments);
				//frame1.setVisible(true);
				//dispose();
			}
		}
	}*/
	
	private void createPanel() {
		this.setLayout(new BorderLayout());
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
		
		
		this.add(greetingLabel, BorderLayout.NORTH);
		this.add(centerPanel, BorderLayout.CENTER);
		this.add(btnPanel, BorderLayout.SOUTH);
		//add(borderPanel);
	}
	
	private void setNextMenu(boolean state, String next){
		newMenu = state;
		nextMenuName = next;
	}
	
	@Override
	public boolean newMenu() {
		return newMenu;
	}
	
	@Override
	public String getNextMenu() {
		return nextMenuName;
	}
	
	@Override
	public void setNewMenu() {
		this.newMenu = true;
	}

	@Override
	public void clearNextMenu(){
		this.nextMenuName = "";
	}
	
}
