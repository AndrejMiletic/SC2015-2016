package actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;

import gui.MainFrame;

public class ActiveLearningAction extends AbstractAction{

	private static final long serialVersionUID = 6395951301542571993L;

	public ActiveLearningAction() 
	{
		super("Active learning");
		putValue(SMALL_ICON, new ImageIcon("resources/images/online_learning_icon.png"));
		putValue(SHORT_DESCRIPTION, "Activate 'Active learning' mode");
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		MainFrame mf = MainFrame.getInstance();
		
		mf.setActiveLearning(true);
		mf.getGameManager().activeLearningActivated();
	}
}
