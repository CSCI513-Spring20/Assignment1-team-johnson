import java.util.Random;


public class StrategicSearchStrategy implements SearchStrategy 
{
	public boolean[][] search(boolean[][] gameGrid) 
	{
		Random rand = new Random();
		boolean[][] result = new boolean[gameGrid.length][gameGrid.length];			// Stores the results of the search	
		boolean[][] searchGrid = new boolean[gameGrid.length][gameGrid.length];		// Stores the visited cells 
		// Initialize boolean arrays
		for (int k = 0; k < gameGrid.length; k++) 
		{
			for (int l = 0; l < gameGrid.length; l++) 
			{
				result[k][l] = false;
				searchGrid[k][l] = false;	
			}
		}
		int searchCount = 0;		// Stores the number of cells searched
		int foundCount = 0;			// Stores the number of cells found to contain a battleship
		// While the number of cells found is less than the total number of cells containing battleships...
		while (foundCount < TOTAL_ITEMS)
		{
			searchCount++;
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
			
			searchGrid[i][j] = true;				// Set this cell to 'searched'

			if (gameGrid[i][j] == true && result[i][j] != true)		// If the cell contains a battleship and we haven't already accounted for it...
			{
				foundCount++;
				result[i][j] = true;		// Account for the found cell in our return variable
				// Set up condition variables for upcoming loop
				boolean valid = true, top = true, bottom = true, left = true, right = true;
				int counter = 1;
				
				while (valid)		// While valid, search each direction from the current cell while we continue to discover the battleship in the adjacent cells
				{
					if (bottom == true)
					{
						searchCount++;
						if (i < gameGrid.length-counter && gameGrid[i+counter][j] == true && result[i+counter][j] != true)
						{
							foundCount++;
							result[i+counter][j] = true;
							searchGrid[i+counter][j] = true;
							bottom = true;
						}
						else bottom = false;
					}
					if (top == true)
					{
						searchCount++;
						if (i > counter-1 && gameGrid[i-counter][j] == true && result[i-counter][j] != true)
						{
							foundCount++;
							result[i-counter][j] = true;
							searchGrid[i-counter][j] = true;
							top = true;
						}
						else top = false;
					}
					if (left == true)
					{
						searchCount++;
						if (j > counter-1 && gameGrid[i][j-counter] == true && result[i][j-counter] != true)
						{
							foundCount++;
							result[i][j-counter] = true;
							searchGrid[i][j-counter] = true;
							left = true;
						}
						else left = false;
					}
					if (right == true)
					{
						searchCount++;
						if (j < gameGrid.length-counter && gameGrid[i][j+counter] == true && result[i][j+counter] != true)
						{
							foundCount++;
							result[i][j+counter] = true;
							searchGrid[i][j+counter] = true;
							right = true;
						}
						else right = false;
					}
					if (!top && !bottom && !right && !left) valid = false;
					counter++;
				}
			}
		}
		System.out.println("Number of cells searched: " + searchCount);
		return result;
	}
	
	public String getName() {
		return "Strategy: Strategic Search";
	}
}
