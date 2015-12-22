package actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;

public class PhysicalAttackAction extends AbstractAction{

	private static final long serialVersionUID = 6678095206674465787L;

	public PhysicalAttackAction() 
	{
		super("Physical Attack");
		putValue(SMALL_ICON, new ImageIcon("resources/images/physical_attack_icon.png"));
		putValue(SHORT_DESCRIPTION, "Physical Attack");
	}
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
