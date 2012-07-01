import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JMenuItem;


public class StartGameItem extends JMenuItem
{
	GameLogik gameLogik;
	RestartGameItem restartGameItem;
	QuitGameItem quitGameItem;
	UndoItem undoItem;
	VoteDrawItem voteDrawItem;
	List<ControlButton> buttons;
	
	public StartGameItem(final GameLogik gameLogik)
	{
		this.gameLogik = gameLogik;
		setText("start");
		setEnabled(true);
		addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				quitGameItem.setEnabled(true);
				restartGameItem.setEnabled(true);
				voteDrawItem.setEnabled(true);
				setEnabled(false);
				undoItem.setEnabled(true);
				new StartGameFrame(gameLogik, buttons);
			}
		});
	}
}
