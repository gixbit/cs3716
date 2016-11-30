package GUI;

import java.awt.*;
import javax.swing.*;

public class DatePanel extends JPanel {
	private JLabel monthLabel;
	private JLabel dayLabel;
	private JLabel yearLabel;
	private JLabel timeLabel;
	private JLabel sepLabel;
	private JComboBox hourBox;
	private JComboBox minBox;
	private JComboBox ampmBox;
	private JComboBox monthBox;
	private JComboBox dayBox;
	private JComboBox yearBox;
	private JPanel datePanelUpper;
	private JPanel datePanelLower;
	private String[] days = new String[31]; 
	private String[] year = new String[51];
	private String[] min = new String[60];
	private String[] hour = new String[12];
	
	public DatePanel() {
		createLabels();
		createBoxes();
		createPanels();
	}
	
	private void createLabels(){
		monthLabel = new JLabel("Month: ");
		monthLabel.setFont(new Font("Arial", Font.PLAIN, 16));

		dayLabel = new JLabel("Day: ");
		dayLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		
		timeLabel = new JLabel("Time: ");
		timeLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		
		yearLabel = new JLabel("Year: ");
		yearLabel.setFont(new Font("Arial", Font.PLAIN, 16));

		sepLabel = new JLabel(":");
		sepLabel.setFont(new Font("Arial", Font.PLAIN, 16));
	}
	
	private void createBoxes(){
		String[] ampm = {"AM", "PM"};
		String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "Novemeber", "December"};

		for(int i = 0; i<=30; i++){
			days[i] = Integer.toString(i+1);
		}
		for(int i = 0; i<=50; i++){
			year[i] = Integer.toString(2015+i);
		}
		for(int i = 0; i<60; i++){
			min[i] = Integer.toString(i);
			if(i<10){
				min[i] = "0" + min[i];
			}
		}
		for(int i = 0; i<12; i++){
			hour[i] = Integer.toString(i+1);
		}

		ampmBox = new JComboBox(ampm);
		hourBox = new JComboBox(hour);
		minBox = new JComboBox(min);
		monthBox = new JComboBox(months);
		dayBox = new JComboBox(days);
		yearBox = new JComboBox(year);
	}	
	
	private void createPanels() {
		datePanelUpper = new JPanel();
		datePanelLower = new JPanel();
		
		datePanelUpper.add(monthLabel);
		datePanelUpper.add(monthBox);
		datePanelUpper.add(dayLabel);
		datePanelUpper.add(dayBox);
		datePanelUpper.add(yearLabel);
		datePanelUpper.add(yearBox);
		datePanelLower.add(timeLabel);
		datePanelLower.add(hourBox);
		datePanelLower.add(sepLabel);
		datePanelLower.add(minBox);
		datePanelLower.add(ampmBox);

		this.setLayout(new GridLayout(2,1));
		this.add(datePanelUpper);
		this.add(datePanelLower);
	}
	
	public String getMonth(){
		return (String)monthBox.getSelectedItem();
	}
	public String getDay(){
		return (String)dayBox.getSelectedItem();
	}
	public String getYear(){
		return (String)yearBox.getSelectedItem();
	}
	public String getHour(){
		return (String)hourBox.getSelectedItem();
	}
	public String getMin(){
		return (String)minBox.getSelectedItem();
	}
	public String getAmPm(){
		return (String)ampmBox.getSelectedItem();
	}


}
