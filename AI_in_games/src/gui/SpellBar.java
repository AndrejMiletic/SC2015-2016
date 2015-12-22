package gui;

import java.awt.GridLayout;

import javax.swing.JToolBar;
import javax.swing.SwingConstants;

import actions.ActionManager;

@SuppressWarnings("serial")
public class SpellBar extends JToolBar
{
	public SpellBar() 
	{
		super(SwingConstants.HORIZONTAL);
		setLayout(new GridLayout(1, 6));
		ActionManager actionManager = MainFrame.getInstance().getActionManager();
		setFloatable(false);
		
		add(actionManager.getPhysicalAttackAction());
		add(actionManager.getBlockAction());
		add(actionManager.getMagicAttackAction());
		add(actionManager.getSpellReflectAction());
		add(actionManager.getHealAction());
		add(actionManager.getSilenceAction());
	}
}
