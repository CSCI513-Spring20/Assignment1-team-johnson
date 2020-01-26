
public class StrategicSearchStrategy implements SearchStrategy {
	public boolean[][] search(boolean[][] gameGrid) {
		boolean[][] result = new boolean[gameGrid.length][gameGrid.length];
		int searchCount = 0;
		int foundCount = 0;
		for (int i = 0; i < gameGrid.length; i++)
		{
			for (int j = 0; j < gameGrid.length; j++) 
			{
				if (foundCount < 8)
				{
					searchCount++;
					if (gameGrid[i][j] == true)
					{
						foundCount++;
						result[i][j] = true;
					}	
				}
				else {
					System.out.println("Number of cells searched: " + searchCount);
					return result;
				}
			}
		}
		System.out.println("Number of cells searched: " + searchCount);
		return result;
	}
}
