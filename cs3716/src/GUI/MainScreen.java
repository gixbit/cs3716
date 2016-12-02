package GUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

import SkeletonCode.Tournament;

/**
 * This class describes the Main GUI menu that appears when the program is started
 * 
 * @author John Hollett
 * @author Keir Strickland Murphy
 * @author Rory Campbell
 * @author Jaimee Bessey
 * @author Kristan James Hart
 * @author Karl Chiasson
 */
public class MainScreen extends JFrame{
	private JPanel finalPannel;
	private JButton bracketsBtn;
	private JButton manageBtn;
	private JButton coachBtn;
	private int nTeams;
	private int nDivs = 3;
	private Tournament t;
	
	public MainScreen(){
		nTeams = 13;
//		t1 = new Tournament("name", "one", "two", "three");
//		t1.createSingleElim();
		
		createItems();
		createPanel();
		setSize(550,725);
		setTitle("");
	}

	public MainScreen(ArrayList<Tournament> lTourns){
		createItems();
		createPanel();
		setSize(500,500);
		setTitle("");
	}

	private void createItems(){
		ActionListener listener = new choiceListener();
		manageBtn = new JButton("Organizers");
		manageBtn.addActionListener(listener);
		manageBtn.setFont(new Font("Arial", Font.PLAIN, 16));
		
		coachBtn = new JButton("Coaches");
		coachBtn.addActionListener(listener);
		coachBtn.setFont(new Font("Arial", Font.PLAIN, 16));

		bracketsBtn = new JButton("Brackets");
		bracketsBtn.addActionListener(listener);
		bracketsBtn.setFont(new Font("Arial", Font.PLAIN, 16));
	}

	class choiceListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			if(event.getSource() == manageBtn){
				JFrame manage = new ManageTournament();
//				frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				manage.setVisible(true);
				dispose();
			}
			
			else if(event.getSource() == bracketsBtn){
				//Checks if a tournament exists and checks if there is a structure
				if (t == null){
					String message = "Please select a tournament";
					JOptionPane.showMessageDialog(new JFrame(), message, "Dialog", 
							JOptionPane.ERROR_MESSAGE); 
				}
				else if (t.getStructure()==null){
					String message = "No tournament structure selected";
					JOptionPane.showMessageDialog(new JFrame(), message, "Dialog", 
							JOptionPane.ERROR_MESSAGE); 
				}
				else{
				JFrame createBracket = new CreateBracket(t);
//				JFrame frame1 = new Division(t1, numOfDivs);
				createBracket.setVisible(true);
				dispose();
				}
			}
			
			else{//event.getSource() == CoachButton
				JFrame register = new Register();
				register.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				register.setVisible(true);
				dispose();
			}
		}
	}

	private void createPanel(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		finalPannel = new JPanel();
		
		finalPannel.add(manageBtn);
		finalPannel.add(coachBtn);
		finalPannel.add(bracketsBtn);
		add(finalPannel);
	}

}
