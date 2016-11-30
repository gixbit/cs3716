package GUI;

import java.util.Stack;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Toolkit;
import java.awt.Dimension;
import java.util.concurrent.TimeUnit;



public class windowManager extends JFrame {

	private final int width = 800;
	private final int height = 600;
	private final String windowTitle = "vTournament";
	private PanelAccess mainMenu = null;

	private Stack<PanelAccess> displayStack = new Stack<PanelAccess>();
	
	public windowManager(){

		initUi();
		initMenu();

		//Testing loop
		while(true){
			
			test();
			
			try{
				TimeUnit.MILLISECONDS.sleep(200);
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
		repaint(0,0, width, height);
	}
  
	public void back(){
		pop();
	}

	private void initMenu(){
		setLayout(null);
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

	private void test(){

		if((displayStack.peek()).newMenu()){

			(displayStack.peek()).setNewMenu();

			PanelAccess newMenu = null;

			switch((displayStack.peek()).getNextMenu()){
				case "managermenu":
					newMenu = new ManageTournament();
					break;
				case "registermenu":
					//newMenu = new Register();
					break;
				case "createtournament":
					//newMenu = new CreateTournament();
					break;
				case "back":
					pop();
					break;
			}

			push(newMenu);
		}
	}
}