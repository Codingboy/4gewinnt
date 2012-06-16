import java.awt.Image;

import javax.swing.ImageIcon;


public class Player
{
	String name;
	int wins;
	int loses;
	int draws;
	boolean votedDraw;
	boolean bot;
	Image image;

	public Player(String name)
	{
		this.name = name;
		this.wins = 0;
		this.loses = 0;
		this.draws = 0;
		this.votedDraw = false;
		this.bot = false;
		this.image = new ImageIcon(Settings.DefaultImagePath).getImage();
	}

	String getName()
	{
		return name;
	}

	void setName(String name)
	{
		this.name = name;
	}

	int getWins()
	{
		return wins;
	}

	void setWins(int wins)
	{
		this.wins = wins;
	}

	int getLoses()
	{
		return loses;
	}

	void setLoses(int loses)
	{
		this.loses = loses;
	}

	int getDraws()
	{
		return draws;
	}

	void setDraws(int draws)
	{
		this.draws = draws;
	}

	boolean isVotedDraw()
	{
		return votedDraw;
	}

	void setVotedDraw(boolean votedDraw)
	{
		this.votedDraw = votedDraw;
	}

	boolean isBot()
	{
		return bot;
	}

	void setBot(boolean bot)
	{
		this.bot = bot;
	}

	Image getImage()
	{
		return image;
	}

	void setImage(Image image)
	{
		this.image = image;
	}
	
	@Override
	public String toString()
	{
		return getName();
	}
}
