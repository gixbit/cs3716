package GUI;

import java.util.ArrayList;
import java.util.Stack;
import javax.swing.JPanel;

import SkeletonCode.Tournament;

import javax.swing.JFrame;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.awt.Dimension;
import java.util.concurrent.TimeUnit;



public class windowManager extends JFrame {
	public static ArrayList<Tournament> Tournaments = new ArrayList<Tournament>();
	private final int width = 800;
	private final int height = 600;
	private final String windowTitle = "vTournament";
	private PanelAccess mainMenu = null;

	private Stack<PanelAccess> displayStack = new Stack<PanelAccess>();
	
	public windowManager(){
		this.addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent e)
            {
        		try {
        			FileOutputStream fos = new FileOutputStream("Tournaments.txt");
        			ObjectOutputStream oos = new ObjectOutputStream(fos);
        			try {
        				oos.writeObject(Tournaments);
        	
        			} catch(IOException err) {
        				//could not write object
        			} finally {
        				oos.flush();
        				oos.close();
        				fos.flush();
        				fos.close();	
        			}

        		} catch (IOException err) {
        			//Could not find file or open file.
        		}
        		e.getWindow().dispose();
            }
            @Override
            public void windowOpened(WindowEvent e) {
        		FileInputStream fis;
        		try {
        			fis = new FileInputStream("Tournaments.txt");
        			ObjectInputStream ois = new ObjectInputStream(fis);
        			try {
        				Tournaments = (ArrayList<Tournament>)ois.readObject();			
        			} catch(IOException | ClassNotFoundException err) {
        				//Could not read or class not found
        			} finally {
        				ois.close();
        				fis.close();	
        			}
        		} catch (FileNotFoundException err) {
        			err.printStackTrace();
        		} catch (IOException err) {
        			//Could not close
        		}
            }
        });
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