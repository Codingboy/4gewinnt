import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;


public class UndoItem extends JMenuItem
{
	GameLogik gameLogik;
	
	public UndoItem(GameLogik gameLogik)
	{
		this.gameLogik = gameLogik;
		setText("undo");
		setEnabled(false);
		addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				//TODO
			}
		});
	}
}
