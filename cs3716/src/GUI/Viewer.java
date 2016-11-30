package GUI;

import javax.swing.JFrame;

/**
 * This is the entry point for the Tournament GUI
 * 
 * @author John Hollett
 * @author Keir Strickland Murphy
 * @author Rory Campbell
 * @author Jaimee Bessey
 * @author Kristan James Hart
 * @author Karl Chiasson
 */
public class Viewer {	
	public static void main(String[] args){
		JFrame frame = new MainScreen();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}