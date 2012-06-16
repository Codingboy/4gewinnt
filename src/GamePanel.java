import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class GamePanel extends JPanel
{
	GameLogik gameLogik;
	
	public GamePanel(GameLogik gameLogik)
	{
		this.gameLogik = gameLogik;
		setPreferredSize(new Dimension(Settings.GameBoardWidth*(Settings.IconWidth+Settings.LineSize), Settings.GameBoardHeight*(Settings.IconHeight+Settings.LineSize)));
	}
	
	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		int xOff = (getSize().width - getPreferredSize().width)/2;
		int yOff = (getSize().height - getPreferredSize().height)/2;
		for (int i=0; i<Settings.GameBoardHeight; i++)
		{
			for (int j=0; j<Settings.GameBoardWidth; j++)
			{
				Player p = gameLogik.getStones()[j][Settings.GameBoardHeight-1-i];
				if (p != null)
				{
					Image img = p.getImage();
					g.drawImage(img, xOff+j*Settings.IconWidth, yOff+i*Settings.IconHeight, this);
				}
				else
				{
					Image img = Toolkit.getDefaultToolkit().getImage(Settings.EmptyFieldPath);
					g.drawImage(img, xOff+j*Settings.IconWidth, yOff+i*Settings.IconHeight, this);
				}
			}
		}
	}
}
