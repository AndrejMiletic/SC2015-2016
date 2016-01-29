package actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import dataProviders.FileDataProvider;

public class EmptyFileAction extends AbstractAction{

	private static final long serialVersionUID = 1913596378603775020L;

	public EmptyFileAction() 
	{
		super("Empty file");
		putValue(SMALL_ICON, new ImageIcon("resources/images/delete_previous_games_icon.png"));
		putValue(SHORT_DESCRIPTION, "Delete all previous games");
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		FileDataProvider.emptyFile();
	}
}
