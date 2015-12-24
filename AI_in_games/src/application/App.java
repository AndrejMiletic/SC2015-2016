package application;

import javax.swing.UIManager;

import gui.MainFrame;

public class App {
	
	public static void main(String[] args)
	{
		// LookAndFeel
		try {
			UIManager.setLookAndFeel("de.javasoft.plaf.synthetica.SyntheticaAluOxideLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		MainFrame mainFrame = MainFrame.getInstance();
		mainFrame.setVisible(true);
	}
}
