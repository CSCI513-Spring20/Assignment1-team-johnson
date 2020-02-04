/* BattleshipSearch.java
 * 
 * Created by: Donald Johnson
 * 
 * Purpose: BattleshipSearch.java defines a BattleshipSearch class which utilizes the Battleship and SearchStrategy classes in conjunction
 * 			to search for battleships on a game grid by using a specified search strategy.
 */

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
	
	public void createGame(int num, boolean[][] gameGrid)		// Populates the game hashmap
	{
		game.put(num, gameGrid);
	}
	
	public void setGameNumber(int n)							// Sets the game number for testing
	{
		gameNumber = n;
	}
	
	public void readCoordinates() 								// Reads the coordinates in from the input.txt file and calls the function to populate the game hashmap
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
					createGame(i, b);	
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
	
	public void identifyShip(int x, int y) {					// Identifies what kind of ship is found at a given coordinate
		if (game.get(gameNumber)[x][y] == true)
		{
			if (carrier.getPosition(x, y)) {
				System.out.println("Carrier found at " + x  + "," + y);
			}
			else System.out.println("Submarine found at " + x  + "," + y);
		}
	}

	public void performSearch()									// Calls the search function from the search strategy and calls the identifyShip function
	{
		System.out.println("------------------------------");
		System.out.println("Game Number: " + (gameNumber+1));
		System.out.println(searchStrategy.getName());
		boolean[][] searchGrid = searchStrategy.search(game.get(gameNumber));
		for (int i = 0; i < searchGrid.length; i++)
		{
			for (int j = 0; j < searchGrid.length; j++)
			{
				if (searchGrid[i][j] == true)
				{
					identifyShip(i, j);
				}
			}
		}
	}
}
