import javax.swing.JMenu;


public class GameMenu extends JMenu
{
	GameLogik gameLogik;
	StartGameItem startGameItem;
	QuitGameItem quitGameItem;
	RestartGameItem restartGameItem;
	UndoItem undoItem;
	VoteDrawItem voteDrawItem;

	public GameMenu(GameLogik gameLogik)
	{
		this.gameLogik = gameLogik;
		setText("Game");
		this.startGameItem = new StartGameItem(this.gameLogik);
		this.quitGameItem = new QuitGameItem(this.gameLogik);
		this.restartGameItem = new RestartGameItem(this.gameLogik);
		this.undoItem = new UndoItem(this.gameLogik);
		this.voteDrawItem = new VoteDrawItem(this.gameLogik);
		this.startGameItem.quitGameItem = this.quitGameItem;
		this.startGameItem.restartGameItem = this.restartGameItem;
		this.startGameItem.undoItem = this.undoItem;
		this.startGameItem.voteDrawItem = this.voteDrawItem;
		this.quitGameItem.startGameItem = this.startGameItem;
		this.quitGameItem.restartGameItem = this.restartGameItem;
		this.quitGameItem.undoItem = this.undoItem;
		this.quitGameItem.voteDrawItem = this.voteDrawItem;
		this.restartGameItem.voteDrawItem = this.voteDrawItem;
		add(this.startGameItem);
		add(this.restartGameItem);
		add(this.quitGameItem);
		add(this.undoItem);
		add(this.voteDrawItem);
	}
}
