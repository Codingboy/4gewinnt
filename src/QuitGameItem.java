import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JMenuItem;


public class QuitGameItem extends JMenuItem
{
	GameLogik gameLogik;
	RestartGameItem restartGameItem;
	StartGameItem startGameItem;
	UndoItem undoItem;
	VoteDrawItem voteDrawItem;
	List<ControlButton> buttons;
	
	public QuitGameItem(GameLogik gameLogik)
	{
		this.gameLogik = gameLogik;
		setText("quit");
		setEnabled(false);
		addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				for (int i=0; i<buttons.size(); i++)
				{
					buttons.get(i).setEnabled(false);
				}
				startGameItem.setEnabled(true);
				restartGameItem.setEnabled(false);
				setEnabled(false);
				undoItem.setEnabled(false);
				voteDrawItem.setEnabled(false);
				//TODO
			}
		});
	}
}
