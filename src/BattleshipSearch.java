import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BattleshipSearch 
{
	final int GRID_SIZE = 25;
	SearchStrategy searchStrategy;
	Battleship carrier = new CarrierBattleship();
	Battleship sub = new SubmarineBattleship();
	Map<Integer, boolean[][]> game = new HashMap<Integer, boolean[][]>();
	int gameNumber = 0;
		
	public BattleshipSearch() 
	{
		
	}
	
	public void setGame(int num, boolean[][] gameGrid) 
	{
		game.put(num, gameGrid);
	}
	
	public void displayGame(int gameNumber)
	{
		boolean[][] b = game.get(gameNumber);
		for (int i = 0; i < GRID_SIZE; i++) 
		{
			for (int j = 0; j < GRID_SIZE; j++)
			{
				int g = b[i][j] ? 1 : 0;
				System.out.print(" | " + g);
			}
		
			System.out.print(" |"+'\n');
			for (int k = 0; k <= GRID_SIZE * 4; k++)
			{
				System.out.print("-");
			}
			System.out.print('\n');
		}
	}
	
	public void setGameNumber(int n)
	{
		gameNumber = n;
	}
	
	public void readCoordinates() 
	{
		try
		{
			FileReader inputFile = new FileReader("../CSCI_513_Assignment1_Team-Johnson/Assignment1/input.txt");
			BufferedReader reader = new BufferedReader(inputFile);
			String line;
			int i = 0;
			while ((line = reader.readLine()) != null)
			{
				Scanner scanner = new Scanner(line);
				while(scanner.hasNextLine()) 
				{
					String record = scanner.nextLine();
					String regex = "\\(([0-9]+),([0-9]+)\\)";
					Pattern p = Pattern.compile(regex);
					Matcher matcher = p.matcher(record);
					boolean[][] b = new boolean[GRID_SIZE][GRID_SIZE];
					int count = 0;
					while (matcher.find())
					{
						int x = Integer.parseInt(matcher.group(1));
						int y = Integer.parseInt(matcher.group(2));
						b[x][y] = true;
						if (count < 5)
						{
							carrier.setPosition(x, y);
						}
						else
						{
							sub.setPosition(x, y);
						}
						count++;
					}
					setGame(i, b);	
				}
				scanner.close();
				i++;
			}
			reader.close();
			
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void identifyShip(int x, int y) {
		boolean[][] position = new boolean[GRID_SIZE][GRID_SIZE];
		position = game.get(gameNumber);
		for (int i = 0; i < position.length; i++) {
			for (int j = 0; j < position.length; j++) {
				System.out.print(position[i][j]);
			}
			System.out.print('\n');
		}
		if (position[x][y] == true)
		{
			System.out.println("Battleship hit");
			if (carrier.getPosition(x, y)) {
				System.out.println("Carrier found at " + x  + "," + y);
			}
			else System.out.println("Submarine found at " + x  + "," + y);
		}
	}
}
