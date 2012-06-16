import javax.swing.JMenuBar;


public class MenuBar extends JMenuBar
{
	AboutMenuItem aboutMenuItem;
	GameLogik gameLogik;
	GameMenu gameMenu;
	PlayerMenu playerMenu;
	SettingsMenuItem settingsMenuItem;
	
	public MenuBar(GameLogik gameLogik)
	{
		this.gameLogik = gameLogik;
		this.settingsMenuItem = new SettingsMenuItem();
		this.aboutMenuItem = new AboutMenuItem();
		this.gameMenu = new GameMenu(this.gameLogik);
		this.playerMenu = new PlayerMenu();

		add(this.gameMenu);
		add(this.playerMenu);
		add(this.settingsMenuItem);
		add(this.aboutMenuItem);
	}
}
