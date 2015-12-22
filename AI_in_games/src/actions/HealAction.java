package actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;

public class HealAction extends AbstractAction{

	private static final long serialVersionUID = -5273642380892034983L;

	public HealAction() 
	{
		super("Heal");
		putValue(SMALL_ICON, new ImageIcon("resources/images/heal_icon.png"));
		putValue(SHORT_DESCRIPTION, "Heal");
	}
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
