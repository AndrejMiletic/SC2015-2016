package actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;

import gui.MainFrame;
import helpers.SpellHelper;

/**
 * Akcija koja predstavlja magiju 'Armor'.
 * @author Milos Maric
 *
 */
public class ArmorAction extends AbstractAction{

	private static final long serialVersionUID = 8661293154583242652L;

	public ArmorAction() 
	{
		super("Armor");
		putValue(SMALL_ICON, new ImageIcon("resources/images/armor_icon.png"));
		putValue(SHORT_DESCRIPTION, "Armor");
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		MainFrame.getInstance().playNewRound(SpellHelper.ARMOR);
	}
}
