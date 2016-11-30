package GUI;

import SkeletonCode.Tournament;

import javax.swing.JFrame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;




public class runner{

	public static ArrayList<Tournament> Tournaments = new ArrayList<Tournament>();

	public static void main(String[] args){

		windowManager frame = new windowManager();

		frame.addWindowListener(new WindowAdapter()
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
	}
}
