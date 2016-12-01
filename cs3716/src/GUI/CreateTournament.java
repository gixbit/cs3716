package GUI;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.*;

import SkeletonCode.Tournament;

public class CreateTournament extends JFrame{
	private JPanel panel;
	private JPanel panel1;
	private JPanel panel2;
	private JPanel panel3;
	private JPanel panel4;
	private JPanel panel5;
	private JPanel panel6;
	private JPanel panel7;
	private JPanel panel8;
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
			
	public CreateTournament(){
		createLabels();
		createFields();
		createButton();
		createPanel();
		setSize(550,725);
		setTitle("Create Tournament");
	}
	
	public CreateTournament(String a, String b, String c, String d){
		//get current date(month, day, year)
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
				JFrame frame1 = new MainScreen();
				frame1.setVisible(true);
				dispose();
			}
			else{	//event.getSource() == createButton
				String startDate = (String)dates[0].getMonth() + " " + (String)dates[0].getDay() + ", " + (String)dates[0].getYear();
				String startTime = (String)dates[0].getHour() + ":" + (String)dates[0].getMin() + " " + (String)dates[0].getAmPm();
				String endDate = (String)dates[1].getMonth() + " " + (String)dates[1].getDay() + ", " + (String)dates[1].getYear();
				String endTime = (String)dates[1].getHour() + ":" + (String)dates[1].getMin() + " " + (String)dates[1].getAmPm();
				Viewer.Tournaments.add(new Tournament((String)tournField.getText(), startDate, endDate, (String)venueField.getText()));
				JFrame frame1 = new ManageTournament();
				frame1.setVisible(true);
				dispose();
			}
		}
	}
	
	private void createPanel(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		panel = new JPanel(new BorderLayout());
		panel1 = new JPanel(new GridLayout(4,1));
		panel2 = new JPanel(new GridLayout(4,1));
		panel3 = new JPanel();
		panel4 = new JPanel();
		panel5 = new JPanel();
		panel6 = new JPanel();
		panel7 = new JPanel();
		panel8 = new JPanel();
		
		panel3.add(tournLabel);
		panel3.add(tournField);
		panel4.add(venueLabel);
		panel4.add(venueField);
		panel5.add(organizerNameLabel);
		panel5.add(organizerNameField);
		panel6.add(organizerInfoLabel);
		panel6.add(organizerInfoField);

		dates[0] = new DatePanel();
		dates[1] = new DatePanel();
		
		panel8.add(cancelButton);
		panel8.add(createButton);

		panel1.add(panel3);
		panel1.add(panel4);
		panel1.add(panel5);
		panel1.add(panel6);

		panel2.add(dateLabel);
		panel2.add(dates[0]);
		panel2.add(regDateLabel);
		panel2.add(dates[1]);

		panel7.add(panel1);
		panel7.add(panel2);
		
		panel.add(greetingLabel, BorderLayout.NORTH);
		panel.add(panel7, BorderLayout.CENTER);
		panel.add(panel8, BorderLayout.SOUTH);
		add(panel);
	}
}