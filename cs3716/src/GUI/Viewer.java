package GUI;

import javax.swing.JFrame;

public class Viewer{	
	public static void main(String[] args){
		JFrame frame = new MainScreen();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}