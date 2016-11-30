package GUI;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import SkeletonCode.Tournament;


public class runner{
	public static ArrayList<Tournament> Tournaments = new ArrayList<Tournament>();
	public static void main(String[] args) throws IOException, ClassNotFoundException{

		windowManager frame = new windowManager();
//		Tournaments.add(new Tournament("a", "b", "c", "d", 0));
//		Tournaments.add(new Tournament("e", "f", "g", "h", 1));
//		Tournaments.add(new Tournament("i", "j", "k", "l", 0));
//
//		FileOutputStream fos = new FileOutputStream("Tournaments.txt");
//		ObjectOutputStream oos = new ObjectOutputStream(fos);
////		for(Tournament t : Tournaments) {
////			oos.writeObject(t);
////		}
//		oos.writeObject(Tournaments);
//		oos.flush();
//		oos.close();
//		fos.flush();
//		fos.close();
		
//		FileInputStream fis = new FileInputStream("Tournaments.txt");
//		System.out.println(fis.available());
//		ObjectInputStream ois = new ObjectInputStream(fis);
//		System.out.println(ois.available());
//		try {
//			Tournaments = (ArrayList<Tournament>)ois.readObject();			
//		} catch(Exception e) {
//			System.out.println("Fuck");
//		}
//		ois.close();
//		fis.close();
//		System.out.println(Tournaments.size());
	}
}