package actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;

import gui.MainFrame;
import helpers.SpellHelper;

/**
 * Akcija koja predstavlja magiju 'Magic Attack'.
 * @author Milos Maric
 *
 */
public class MagicAttackAction extends AbstractAction{

	private static final long serialVersionUID = -3626176594107510375L;

	public MagicAttackAction() 
	{
		super("Magic Attack");
		putValue(SMALL_ICON, new ImageIcon("resources/images/magic_attack_icon.png"));
		putValue(SHORT_DESCRIPTION, "Magic Attack");
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		MainFrame.getInstance().playNewRound(SpellHelper.MAGICAL_ATTACK);
	}
}
