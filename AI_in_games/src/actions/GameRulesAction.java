package actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import gui.MainFrame;
import model.Game;

public class GameRulesAction extends AbstractAction
{
	private static final long serialVersionUID = 6720058400774211828L;

	public GameRulesAction() 
	{
		super("Game rules");
		putValue(SMALL_ICON, new ImageIcon("resources/images/rules_icon.png"));
		putValue(SHORT_DESCRIPTION, "How to play?");
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{		
		JOptionPane.showMessageDialog(
									MainFrame.getInstance(), 
									Game.getGameRules(), 
									"Game rules!", 
									JOptionPane.OK_OPTION, 
									new ImageIcon("resources/images/dialog_icon.png"));
	}

}
