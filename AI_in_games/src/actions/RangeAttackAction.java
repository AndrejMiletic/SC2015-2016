package actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;

import gui.MainFrame;
import helpers.SpellHelper;

/**
 * Akcija koja predstavlja magiju 'Range Attack'.
 * @author Milos Maric
 *
 */
public class RangeAttackAction extends AbstractAction{

	private static final long serialVersionUID = -5273642380892034983L;

	public RangeAttackAction() 
	{
		super("Range Attack");
		putValue(SMALL_ICON, new ImageIcon("resources/images/range_attack_icon.png"));
		putValue(SHORT_DESCRIPTION, "Range Attack");
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		MainFrame.getInstance().playNewRound(SpellHelper.RANGE_ATTACK);
	}
}
