import javax.swing.JMenu;


public class PlayerMenu extends JMenu
{
	PlayerAddItem playerAddItem;
	PlayerDeleteItem playerDeleteItem;
	
	public PlayerMenu()
	{
		this.playerAddItem = new PlayerAddItem();
		this.playerDeleteItem = new PlayerDeleteItem();
		setText("Player");
		add(this.playerAddItem);
		add(this.playerDeleteItem);
	}
}
