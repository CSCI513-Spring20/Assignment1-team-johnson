/* HorizontalSweepStrategy.java
 * 
 * Created by: Donald Johnson
 * 
 * Purpose: HorizontalSweepStrategy.java defines a class which implements the SearchStrategy interface.
 * 			This specific strategy searches the game grid by horizontally iterating through each cell
 * 			until all battleships are found. 
 */
public class HorizontalSweepStrategy implements SearchStrategy {
	public boolean[][] search(boolean[][] gameGrid) {
		boolean[][] result = new boolean[gameGrid.length][gameGrid.length];		// Stores the results of the search
		int searchCount = 0;		// Stores the number of cells searched
		int foundCount = 0;			// Stores the number of cells found to contain a battleship
		for (int i = 0; i < gameGrid.length; i++)
		{
			for (int j = 0; j < gameGrid.length; j++) 
			{
				if (foundCount < TOTAL_ITEMS)		// If the number of cells found is less than the total number of cells containing battleships...
				{
					searchCount++;
					if (gameGrid[i][j] == true)		// If the cell contains a battleship...
					{
						foundCount++;
						result[i][j] = true;		// Account for the found cell in our return variable
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
	
	public String getName() {
		return "Strategy: Horizontal Sweep";
	}
}
