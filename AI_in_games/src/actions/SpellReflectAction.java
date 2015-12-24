package actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;

import gui.MainFrame;
import helpers.SpellHelper;
import model.Game;

/**
 * Akcija koja predstavlja magiju 'Spell Reflect'.
 * @author Milos Maric
 *
 */
public class SpellReflectAction extends AbstractAction{

	private static final long serialVersionUID = -6095231766149072874L;

	public SpellReflectAction() 
	{
		super("Spell Reflect");
		putValue(SMALL_ICON, new ImageIcon("resources/images/spell_reflect_icon.png"));
		putValue(SHORT_DESCRIPTION, "Spell Reflect - reflects a Magic Attack dealing " + 
									Game.reflectDamage + " damage back to the attacker.");
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		MainFrame.getInstance().playNewRound(SpellHelper.SPELL_REFLECT);
	}
}
