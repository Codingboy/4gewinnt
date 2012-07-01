import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

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
		List<ControlButton> allButtons = new ArrayList<ControlButton>(Settings.GameBoardWidth*2);//TODO size
		for (int i=0; i<Settings.GameBoardWidth; i++)
		{
			this.topControlButtons[i] = new ControlButton(this.gameLogik, i, this.activeTeam, this.activePlayer, ControlButtonType.pushTop, this.gamePanel, this.menuBar.gameMenu.voteDrawItem, this.menuBar.gameMenu.undoItem, this.menuBar.gameMenu.startGameItem);
			allButtons.add(this.topControlButtons[i]);
		}
		this.bottomControlButtons = new ControlButton[Settings.GameBoardWidth];
		for (int i=0; i<Settings.GameBoardWidth; i++)
		{
			this.bottomControlButtons[i] = new ControlButton(this.gameLogik, i, this.activeTeam, this.activePlayer, ControlButtonType.popBottom, this.gamePanel, this.menuBar.gameMenu.voteDrawItem, this.menuBar.gameMenu.undoItem, this.menuBar.gameMenu.startGameItem);
			allButtons.add(this.bottomControlButtons[i]);
		}
		for (int i=0; i<Settings.GameBoardWidth; i++)
		{
			this.topControlButtons[i].buttons = allButtons;
			this.bottomControlButtons[i].buttons = allButtons;
		}
		this.menuBar.gameMenu.startGameItem.buttons = allButtons;
		this.menuBar.gameMenu.quitGameItem.buttons = allButtons;

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
		JPanel labels = new JPanel(new BorderLayout());
		labels.add(this.activePlayer, BorderLayout.NORTH);
		labels.add(this.activeTeam, BorderLayout.SOUTH);
		JPanel panel = new JPanel(new BorderLayout());
		panel.add(labels, BorderLayout.NORTH);
		panel.add(rootPanel, BorderLayout.CENTER);
		add(panel);
		//add(rootPanel);

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
