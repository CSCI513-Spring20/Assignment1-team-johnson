import java.util.Random;

public class RandomSearchStrategy implements SearchStrategy {
	public boolean[][] search(boolean[][] gameGrid) {
		Random rand = new Random();
		boolean[][] result = new boolean[gameGrid.length][gameGrid.length];		// Stores the results of the search
		int searchCount = 0;		// Stores the number of cells searched
		int foundCount = 0;			// Stores the number of cells found to contain a battleship
		// While the number of cells found is less than the total number of cells containing battleships...
		while (foundCount < TOTAL_ITEMS)
		{
			searchCount++;
			// Select random cell coordinates
			int i = rand.nextInt(25);
			int j = rand.nextInt(25);
			if (gameGrid[i][j] == true && result[i][j] != true)		// If the cell contains a battleship and we haven't already accounted for it...
			{
				foundCount++;
				result[i][j] = true;		// Account for the found cell in our return variable
			}
		}
		System.out.println("Number of cells searched: " + searchCount);
		return result;
	}
	
	public String getName() {
		return "Strategy: Random Search";
	}
}
