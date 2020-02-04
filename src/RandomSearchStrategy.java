/* RandomSearchStrategy.java
 * 
 * Created by: Donald Johnson
 * 
 * Purpose: RandomSearchStrategy.java defines a class which implements the SearchStrategy interface.
 * 			This specific strategy searches the game grid by randomly iterating through each cell
 * 			until all battleships are found. 
 */
import java.util.Random;

public class RandomSearchStrategy implements SearchStrategy {
	public boolean[][] search(boolean[][] gameGrid) {
		Random rand = new Random();
		boolean[][] result = new boolean[gameGrid.length][gameGrid.length];		// Stores the results of the search
		boolean[][] searchGrid = new boolean[gameGrid.length][gameGrid.length];		// Stores the visited cells 
		int searchCount = 0;		// Stores the number of cells searched
		int foundCount = 0;			// Stores the number of cells found to contain a battleship
		// While the number of cells found is less than the total number of cells containing battleships...
		for (int k = 0; k < gameGrid.length; k++) 
		{
			for (int l = 0; l < gameGrid.length; l++) 
			{
				result[k][l] = false;
				searchGrid[k][l] = false;	
			}
		}
		while (foundCount < TOTAL_ITEMS)
		{
			// Select random cell coordinates
			int i = rand.nextInt(25);
			int j = rand.nextInt(25);
			if (searchGrid[i][j] == true)			// If cell has already been searched...
			{
				while (searchGrid[i][j] == true)	// While we continue to choose a random cell that has already been searched...
				{
					// Select a new random cell
					i = rand.nextInt(25);	
					j = rand.nextInt(25);
				}
			}
			searchCount++;
			searchGrid[i][j] = true;				// Set this cell to 'searched'
			if (gameGrid[i][j] == true && result[i][j] != true)		// If the cell contains a battleship and we haven't already accounted for it...
			{
				foundCount++;
				result[i][j] = true;		// Account for the found cell in our return variable
				searchGrid[i][j] = true;
			}
		}
		System.out.println("Number of cells searched: " + searchCount);
		return result;
	}
	
	public String getName() {
		return "Strategy: Random Search";
	}
}
