import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BattleshipSearch 
{
	SearchStrategy searchStrategy;
	Battleship c = new CarrierBattleship();
	Battleship s = new SubmarineBattleship();
	Map<Integer, boolean[][]> game = new HashMap<Integer, boolean[][]>();
		
	public BattleshipSearch() 
	{
		
	}
	
	public void setGame(int gameNumber, boolean[][] gameGrid) 
	{
		game.put(gameNumber, gameGrid);
	}
	
	public void displayGame(int gameNumber)
	{
		boolean[][] b = game.get(gameNumber);
		for (int i = 0; i < b.length; i++) 
		{
			for (int j = 0; j < b.length; j++)
			{
				int g = b[i][j] ? 1 : 0;
				System.out.print(" | " + g);
			}
		
			System.out.print(" |"+'\n');
			for (int k = 0; k <= b.length * 4; k++)
			{
				System.out.print("-");
			}
			System.out.print('\n');
		}
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
					boolean[][] b = new boolean[25][25];
					int count = 0;
					while (matcher.find())
					{
						int x = Integer.parseInt(matcher.group(1));
						int y = Integer.parseInt(matcher.group(2));
						b[x][y] = true;
						if (count < 5)
						{
							c.setPosition(b);
						}
						else
						{
							s.setPosition(b);
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
}
