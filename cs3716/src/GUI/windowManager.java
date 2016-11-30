package GUI;

import SkeletonCode.Tournament;

import java.util.Stack;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Toolkit;
import java.awt.Dimension;
import java.util.concurrent.TimeUnit;
import java.util.ArrayList;



public class windowManager extends JFrame{

	private final int width = 800;
	private final int height = 600;
	private final String windowTitle = "vTournament";
	private PanelAccess mainMenu = null;

	private Stack<PanelAccess> displayStack = new Stack<PanelAccess>();
	
	public windowManager(){

		initUi();
		initMenu();
		

		//Logic loop
		while(true){
			
			windowLogic();
			
			try{
				TimeUnit.MILLISECONDS.sleep(250);
			}
			catch(InterruptedException e){
				//msg to console for now
				System.out.println("Sleep error");
			}
		}
	}

	private void push(PanelAccess object){
		if(!(displayStack.empty())){remove((JPanel)displayStack.peek());}
		add((JPanel)(displayStack.push(object)));
		reDraw();
	}

	private void pop(){
		if(displayStack.size() > 1){remove((JPanel)displayStack.pop());}
		add((JPanel)(displayStack.peek()));
		reDraw();
	}

	public void reDraw(){
		revalidate();
		repaint();
	}
  
	public void back(){
		pop();
	}

	private void initMenu(){
		mainMenu = new Menu();
		((JPanel)mainMenu).setBounds(0,0,width,height);
 		push(mainMenu);
	}

	private void initUi(){

		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		
		int x = (screen.width-width)/2;
		int y = (screen.height-height)/2;

		setLocation(x,y);
		setResizable(false);
		setSize(width, height);
		setTitle(windowTitle);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
	}

	private void windowLogic(){

		if((displayStack.peek()).newMenu()){

			PanelAccess newMenu = null;

			switch((displayStack.peek()).getNextMenu()){
				case "managermenu":
					newMenu = new ManageTournament();
					break;
				case "registermenu":
					newMenu = new Register();
					break;
				case "createtournament":
					newMenu = new CreateTournament();
					break;
				case "teamlist":
					newMenu = new ListOfTeams();
					break;
				case "back":
					pop();
					break;
			}
			
			if(!(newMenu == null)){
				displayStack.peek().setNewMenu();
				displayStack.peek().clearNextMenu();
				((JPanel)newMenu).setBounds(0,0,width,height);
				push(newMenu);
			}
		}
	}
}
