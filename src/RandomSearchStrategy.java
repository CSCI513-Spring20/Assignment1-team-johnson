import java.util.Random;

public class RandomSearchStrategy implements SearchStrategy {
	public boolean[][] search(boolean[][] gameGrid) {
		Random rand = new Random();
		boolean[][] result = new boolean[gameGrid.length][gameGrid.length];
		int searchCount = 0;
		int foundCount = 0;
		while (foundCount < 8)
		{
			searchCount++;
			int i = rand.nextInt(25);
			int j = rand.nextInt(25);
			if (gameGrid[i][j] == true && result[i][j] != true)
			{
				foundCount++;
				result[i][j] = true;
			}
		}
		System.out.println("Number of cells searched: " + searchCount);
		return result;
	}
}
