package GUI;

import javax.swing.JFrame;

import SkeletonCode.Tournament;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

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

	public static ArrayList<Tournament> Tournaments;


	public static void main(String[] args){
		JFrame frame = new MainScreen();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.addWindowListener(new WindowAdapter(){
			public void windowOpened(WindowEvent e) {
        		try {
        			FileInputStream fis = new FileInputStream("Tournaments.txt");
        			ObjectInputStream ois = new ObjectInputStream(fis);
        			try {
        				Tournaments = (ArrayList<Tournament>)ois.readObject();
        				if(Tournaments == null) {
        					Tournaments = new ArrayList<Tournament>();
        				}
        			} catch(IOException | ClassNotFoundException err) {
        				Tournaments = new ArrayList<Tournament>();
        			} finally {
        				ois.close();
        				fis.close();	
        			}
        		} catch (FileNotFoundException err) {
    				Tournaments = new ArrayList<Tournament>();
        		} catch (IOException err) {
        			//Could not close
        		}
            }
        });

	}
}