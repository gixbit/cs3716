package GUI;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;


public class Menu extends JPanel implements PanelAccess{
	
	private boolean newMenu = false;
	private String nextMenuName = "";

	public Menu(){

		setLayout(null);

		JPanel inner = new JPanel();
		inner.setLayout(new GridLayout(4,1));

		JButton manageBtn = new JButton("Manage Tournaments");
		manageBtn.addActionListener(new ActionListener(){
			  public void actionPerformed(ActionEvent e)
			  {
			  	setNextMenu(true,"managermenu");

			  }
		});

		JButton regBtn = new JButton("Register Teams");
		regBtn.addActionListener(new ActionListener(){
			  public void actionPerformed(ActionEvent e)
			  {
			  	setNextMenu(true,"registermenu");
			  }
		});

		JButton btn3 = new JButton("Place Holder");
		/*
		btn3.addActionListener(new ActionListener()
			{
			  public void actionPerformed(ActionEvent e)
			  {
			   nextMenu = true;
			  }
		});
		*/
		
		JButton btn4 = new JButton("Place Holder");
		/*
		btn4.addActionListener(new ActionListener()
			{
			  public void actionPerformed(ActionEvent e)
			  {
			   nextMenu = true;
			  }
		});
		*/

		inner.add(manageBtn);
		inner.add(regBtn);
		inner.add(btn3);
		inner.add(btn4);
		
		inner.setBounds(200,300,400,200);
		
		add(inner);
	}

	private void setNextMenu(boolean state, String next){
		newMenu = state;
		nextMenuName = next;
	}

	public boolean newMenu(){
		return newMenu;
	}

	public String getNextMenu(){
		return nextMenuName;
	}

	public void setNewMenu(){
		newMenu = false;
	}

	public void clearNextMenu(){
		this.nextMenuName = "";
	}
}
