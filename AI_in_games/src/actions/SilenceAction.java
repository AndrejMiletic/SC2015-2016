package actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;

public class SilenceAction extends AbstractAction{

	private static final long serialVersionUID = 8661293154583242652L;

	public SilenceAction() 
	{
		super("Silence");
		putValue(SMALL_ICON, new ImageIcon("resources/images/silence_icon.png"));
		putValue(SHORT_DESCRIPTION, "Silence");
	}
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
