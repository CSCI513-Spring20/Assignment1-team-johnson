import java.util.Random;


public class StrategicSearchStrategy implements SearchStrategy 
{
	public boolean[][] search(boolean[][] gameGrid) 
	{
		Random rand = new Random();
		boolean[][] result = new boolean[gameGrid.length][gameGrid.length];
		boolean[][] searchGrid = new boolean[gameGrid.length][gameGrid.length];
		for (int k = 0; k < gameGrid.length; k++) 
		{
			for (int l = 0; l < gameGrid.length; l++) 
			{
				result[k][l] = false;
				searchGrid[k][l] = false;	
			}
		}
		int searchCount = 0;
		int foundCount = 0;
		while (foundCount < 8)
		{
			searchCount++;
			int i = rand.nextInt(25);
			int j = rand.nextInt(25);
			if (searchGrid[i][j] == true)
			{
				while (searchGrid[i][j] == true)
				{
					i = rand.nextInt(25);
					j = rand.nextInt(25);
				}
			}
			
			searchGrid[i][j] = true;

			if (gameGrid[i][j] == true && result[i][j] != true)
			{
				foundCount++;
				result[i][j] = true;
				System.out.println("i: " + i + ", j: " + j);
				boolean valid = true;
				boolean top = true, bottom = true, left = true, right = true;
				int counter = 1;
				while (valid)
				{
					if (bottom == true)
					{
						if (i < gameGrid.length - counter && gameGrid[i+counter][j] == true && result[i+counter][j] != true)
						{
							searchCount++;
							foundCount++;
							result[i+counter][j] = true;
							searchGrid[i+counter][j] = true;
							bottom = true;
							System.out.println("**i: " + (i+counter) + ", j: " + j);
						}
						else bottom = false;
					}
					if (top == true)
					{
						if (i > counter-1 && gameGrid[i-counter][j] == true && result[i-counter][j] != true)
						{
							searchCount++;
							foundCount++;
							result[i-counter][j] = true;
							searchGrid[i-counter][j] = true;
							top = true;
							System.out.println("**i: " + (i-counter) + ", j: " + j);
						}
						else top = false;
					}
					if (left == true)
					{
						if (j > counter-1 && gameGrid[i][j-counter] == true && result[i][j-counter] != true)
						{
							searchCount++;
							foundCount++;
							result[i][j-counter] = true;
							searchGrid[i][j-counter] = true;
							left = true;
							System.out.println("**i: " + i + ", j: " + (j-counter));
						}
						else left = false;
					}
					if (right == true)
					{
						if (j < gameGrid.length - counter && gameGrid[i][j+counter] == true && result[i][j+counter] != true)
						{
							searchCount++;
							foundCount++;
							result[i][j+counter] = true;
							searchGrid[i][j+counter] = true;
							right = true;
							System.out.println("**i: " + i + ", j: " + (j+counter));
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
}
