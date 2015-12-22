package actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;

public class MagicAttackAction extends AbstractAction{

	private static final long serialVersionUID = -3626176594107510375L;

	public MagicAttackAction() 
	{
		super("Magic Attack");
		putValue(SMALL_ICON, new ImageIcon("resources/images/magic_attack_icon.png"));
		putValue(SHORT_DESCRIPTION, "Magic Attack");
	}
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
