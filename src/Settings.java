import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class Settings
{
	public static int OperationsPerPlayer = 1;
	public static int TeamNumber = 2;
	public static String EmptyFieldPath = "/home/bla/workspace/4gewinnt/leer.gif";
	public static String DefaultImagePath = "/home/bla/workspace/4gewinnt/rot.gif";
	public static String RedImagePath = "/home/bla/workspace/4gewinnt/rot.gif";
	public static String YellowImagePath = "/home/bla/workspace/4gewinnt/gelb.gif";
	public static int PlayerNumber = 2;
	public static int GameBoardWidth = 7;
	public static int GameBoardHeight = 6;
	public static int IconWidth = 48;
	public static int IconHeight = 48;
	public static int LineSize = 1;
	public static int OperationsPerTeam = 1;
	public static List<Player> players = new ArrayList<Player>();
	public static int StonesToWin = 4;
	
	static void load()
	{
		
	}
	
	static void save()
	{
		
	}
}
