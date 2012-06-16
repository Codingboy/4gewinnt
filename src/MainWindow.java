import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class MainWindow extends JFrame
{
	MenuBar menuBar;
	GameLogik gameLogik;
	ControlButton[] topControlButtons;
	ControlButton[] bottomControlButtons;
	JLabel activePlayer;
	JLabel activeTeam;
	GamePanel gamePanel;
	
	public MainWindow()
	{
		this.gameLogik = new GameLogik();
		this.gamePanel = new GamePanel(this.gameLogik);
		this.menuBar = new MenuBar(this.gameLogik);
		this.activePlayer = new JLabel();
		this.activeTeam = new JLabel();
		this.topControlButtons = new ControlButton[Settings.GameBoardWidth];
		for (int i=0; i<Settings.GameBoardWidth; i++)
		{
			topControlButtons[i] = new ControlButton(this.gameLogik, i, this.activeTeam, this.activePlayer, ControlButtonType.pushTop, this.gamePanel);
		}
		this.bottomControlButtons = new ControlButton[Settings.GameBoardWidth];
		for (int i=0; i<Settings.GameBoardWidth; i++)
		{
			bottomControlButtons[i] = new ControlButton(this.gameLogik, i, this.activeTeam, this.activePlayer, ControlButtonType.popBottom, this.gamePanel);
		}

		setJMenuBar(this.menuBar);
		JPanel rootPanel = new JPanel(new BorderLayout());
		JPanel topPanel = new JPanel(new FlowLayout());
		JPanel bottomPanel = new JPanel(new FlowLayout());
		for (int i=0; i<Settings.GameBoardWidth; i++)
		{
			topPanel.add(this.topControlButtons[i]);
			bottomPanel.add(this.bottomControlButtons[i]);
		}
		gamePanel.setPreferredSize(new Dimension(Settings.GameBoardWidth*topControlButtons[0].getPreferredSize().width, Settings.GameBoardHeight*topControlButtons[0].getPreferredSize().height));
		rootPanel.add(topPanel, BorderLayout.NORTH);
		rootPanel.add(gamePanel, BorderLayout.CENTER);
		rootPanel.add(bottomPanel, BorderLayout.SOUTH);
		add(rootPanel);

		setTitle("4 Gewinnt!");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}
	
	public static void main(String[] args)
	{
		Settings.load();
		MainWindow mw = new MainWindow();
	}
}
