import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;


public class VoteDrawItem extends JMenuItem
{
	GameLogik gameLogik;
	
	public VoteDrawItem(GameLogik gameLogik)
	{
		this.gameLogik = gameLogik;
		setText("vote draw");
		setEnabled(false);
		addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				setEnabled(false);
				//TODO
			}
		});
	}
}
