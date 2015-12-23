package actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;

import gui.MainFrame;
import helpers.SpellHelper;

public class BlockAction extends AbstractAction{

	private static final long serialVersionUID = 4933871410941594487L;

	public BlockAction() 
	{
		super("Block");
		putValue(SMALL_ICON, new ImageIcon("resources/images/block_icon.png"));
		putValue(SHORT_DESCRIPTION, "Block");
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		MainFrame.getInstance().playNewRound(SpellHelper.BLOCK);
	}
}
