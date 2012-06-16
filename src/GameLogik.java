import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.ImageIcon;


public class GameLogik
{
	Player[][] stones;
	Player winner;
	List<Integer> actualPlayer;
	int actualTeam;
	List<List<Player>> teams;
	int teamOperationsDone;
	int playerOperationsDone;
	
	/**
	 * Gets the the complete gamefield.
	 * @return complete gamefield
	 */
	public Player[][] getStones()
	{
		return this.stones;
	}

	//TODO
	void restart()
	{
		//TODO
	}

	//TODO
	void start(Map<Player, Integer> players, int width, int height)
	{
		Settings.GameBoardWidth = width;
		Settings.GameBoardHeight = height;
		this.stones = new Player[Settings.GameBoardWidth][Settings.GameBoardHeight];
		for (int i=0; i<Settings.GameBoardHeight; i++)
		{
			for (int j=0; j<Settings.GameBoardWidth; j++)
			{
				this.stones[j][i] = null;
			}
		}
		this.winner = null;
		this.actualPlayer = new ArrayList<Integer>();
		for (int i=0; i<Settings.PlayerNumber; i++)
		{
			this.actualPlayer.add(0);
		}
		this.actualTeam = 0;
		List<Integer> teamNumbers = new ArrayList<Integer>(players.values());
		Set<Player> playerSet = players.keySet();
		this.teams = new ArrayList<List<Player>>();
		for (int i=0; i<teamNumbers.size(); i++)
		{
			this.teams.add(new ArrayList<Player>());
			for (Player p : playerSet)
			{
				if (players.get(p).intValue() == teamNumbers.get(i))
				{
					switch (this.teams.size())
					{
						case 1://first team
							p.setImage(new ImageIcon(Settings.RedImagePath).getImage());
							break;
						case 2:
							p.setImage(new ImageIcon(Settings.YellowImagePath).getImage());
							break;
						default:
							System.err.println("too many teams to display");
					}
					this.teams.get(i).add(p);
				}
			}
		}
		Settings.TeamNumber = this.teams.size();
		Settings.PlayerNumber = playerSet.size();
		this.teamOperationsDone = 0;
	}
	
	public GameLogik()
	{
		this.stones = new Player[Settings.GameBoardWidth][Settings.GameBoardHeight];
		for (int i=0; i<Settings.GameBoardHeight; i++)
		{
			for (int j=0; j<Settings.GameBoardWidth; j++)
			{
				this.stones[j][i] = null;
			}
		}
		this.winner = null;
		this.actualPlayer = new ArrayList<Integer>();
		for (int i=0; i<Settings.PlayerNumber; i++)
		{
			this.actualPlayer.add(0);
		}
		this.actualTeam = 0;
		this.teams = new ArrayList<List<Player>>();
		for (int i=0; i<Settings.TeamNumber; i++)
		{
			this.teams.add(new ArrayList<Player>());
		}
		this.teamOperationsDone = 0;
	}
	
	/**
	 * Gets the actual player.
	 * @return actual player
	 */
	Player getActualPlayer()
	{
		return this.teams.get(getActualTeam()).get(this.actualPlayer.get(getActualTeam()));
	}
	
	/**
	 * Sets the actual player
	 * @pre actualPlayer exists
	 * @param actualPlayer number of actual player
	 */
	void setActualPlayer(int actualPlayer)
	{
		this.actualPlayer.set(getActualTeam(), actualPlayer);
	}
	
	/**
	 * Gets the number of the actual team.
	 * @pre teams exist
	 * @return number of actual team
	 */
	int getActualTeam()
	{
		return this.actualTeam;
	}
	
	/**
	 * Sets the number of the actual team.
	 * @pre team >= 0
	 * @pre team < number of all teams
	 * @param team number of actual team
	 */
	void setActualTeam(int team)
	{
		this.actualTeam = team;
	}
	
	/**
	 * Gets the number of operations done.
	 * @return number of operations done
	 */
	int getTeamOperationsDone()
	{
		return this.teamOperationsDone;
	}
	
	/**
	 * Sets the number of operations done.
	 * @pre operations >= 0
	 * @param operations operations done
	 */
	void setTeamOperationsDone(int operations)
	{
		this.teamOperationsDone = operations;
	}
	
	/**
	 * Gets the number of operations done.
	 * @return number of operations done
	 */
	int getPlayerOperationsDone()
	{
		return this.playerOperationsDone;
	}
	
	/**
	 * Sets the number of operations done.
	 * @pre operations >= 0
	 * @param operations operations done
	 */
	void setPlayerOperationsDone(int operations)
	{
		this.playerOperationsDone = operations;
	}
	
	/**
	 * Gets the owner of the field.
	 * @pre x < Settings.GameBoardWidth
	 * @pre x >= 0
	 * @pre y < Settings.GameBoardHeight
	 * @pre y >= 0
	 * @param x x-coordinate
	 * @param y y-coordinate
	 * @return owner of the field or null if no owner is set
	 */
	Player get(int x, int y)
	{
		return getStones()[x][y];
	}
	
	/**
	 * Sets the owner of a field.
	 * @pre player is a valid player or null
	 * @pre x < Settings.GameBoardWidth
	 * @pre x >= 0
	 * @pre y < Settings.GameBoardHeight
	 * @pre y >= 0
	 * @pre player is valid player or null
	 * @post owner of field xy = actualPlayer
	 * @param x x-coordinate
	 * @param y y-coordinate
	 * @param player player
	 * @modifies this
	 */
	void set(int x, int y, Player player)
	{
		this.stones[x][y] = player;
	}
	
	/**
	 * Tests if the game is finish.
	 * @return true if game is finish
	 */
	boolean isFinish()
	{
		for (int j=0; j<Settings.GameBoardHeight; j++)
		{
			Player last = null;
			int equalStones = 0;
			for (int i=0; i<Settings.GameBoardWidth; i++)
			{
				Player p = getStones()[i][j];
				if (p == null)
				{
					equalStones = 0;
					last = p;
					continue;
				}
				if (last == null)
				{
					equalStones = 1;
					last = p;
					continue;
				}
				else
				{
					if (p.equals(last))
					{
						equalStones++;
					}
					else
					{
						equalStones = 1;
					}
					last = p;
				}
				if (equalStones >= Settings.StonesToWin)
				{
					setWinner(p);
					return true;
				}
			}
		}
		for (int j=0; j<Settings.GameBoardWidth; j++)
		{
			Player last = null;
			int equalStones = 0;
			for (int i=0; i<Settings.GameBoardHeight; i++)
			{
				Player p = getStones()[j][i];
				if (p == null)
				{
					equalStones = 0;
					last = p;
					continue;
				}
				if (last == null)
				{
					equalStones = 1;
					last = p;
					continue;
				}
				else
				{
					if (p.equals(last))
					{
						equalStones++;
					}
					else
					{
						equalStones = 1;
					}
					last = p;
				}
				if (equalStones >= Settings.StonesToWin)
				{
					setWinner(p);
					return true;
				}
			}
		}
		//TODO
		return false;
	}
	
	/**
	 * Sets the winner.
	 * @param winner winner
	 */
	void setWinner(Player winner)
	{
		this.winner = winner;
	}
	
	/**
	 * Gets the winner.
	 * @return winner or null
	 */
	Player getWinner()
	{
		return this.winner;
	}
	
	/**
	 * Cleares all fields.
	 * @post all fields contain null
	 */
	void clear()
	{
		for (int i=0; i<Settings.GameBoardHeight; i++)
		{
			for (int j=0; j<Settings.GameBoardWidth; j++)
			{
				set(j, i, null);
			}
		}
	}
	
	//TODO
	void incrementGedöns()
	{
		setTeamOperationsDone(getTeamOperationsDone()+1);
		setPlayerOperationsDone(getPlayerOperationsDone()+1);
		if (getPlayerOperationsDone() >= Settings.OperationsPerPlayer)
		{
			int player = this.actualPlayer.get(getActualTeam());
			player++;
			int maxPlayer = this.teams.get(getActualTeam()).size()-1;
			if (player > maxPlayer)
			{
				player = 0;
			}
			setActualPlayer(player);
			setPlayerOperationsDone(0);
		}
		if (getTeamOperationsDone() >= Settings.OperationsPerTeam)
		{
			int team = getActualTeam();
			team++;
			int maxTeam = this.teams.size()-1;
			if (team > maxTeam)
			{
				team = 0;
			}
			this.actualTeam = team;
			setTeamOperationsDone(0);
		}
	}
	
	/**
	 * Inserts a stone from the top. The stones falls down until it touches another stone or is at the lowest position.
	 * @pre x < Settings.GameBoardWidth
	 * @pre x >= 0
	 * @post new stone is inserted
	 * @param x x-coordinate
	 * @return success: true
	 * @return error: false
	 */
	boolean pushTop(int x)
	{
		for (int i=0; i<Settings.GameBoardHeight; i++)
		{
			if (getStones()[x][i] != null)
			{
				continue;
			}
			set(x, i, getActualPlayer());
		
			incrementGedöns();
			return true;
		}
		return false;
	}
	
	/**
	 * Removes a stone from the bottom. All stones above this stone will fall down one field.
	 * @pre x < Settings.GameBoardWidth
	 * @pre x >= 0
	 * @post stone is removed
	 * @param x x-coordinate
	 * @return success: true
	 * @return error: false
	 */
	boolean popBottom(int x)
	{
		for (int i=0; i<Settings.GameBoardHeight; i++)
		{
			if (getStones()[x][i] == null)
			{
				if (i == 0)
				{
					return false;
				}
				incrementGedöns();
				return true;
			}
			if (i == Settings.GameBoardHeight)
			{
				set(x, i, null);
				incrementGedöns();
				return true;
			}
			else
			{
				set(x, i, getStones()[x][i+1]);
			}
		}
		return false;
	}
}
