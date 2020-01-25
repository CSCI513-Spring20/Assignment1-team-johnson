public class BattleshipSearch {
	SearchStrategy searchStrategy;
	boolean[][] grid = new boolean[25][25];
		
	public BattleshipSearch() 
	{
		
	}
	
	public void initGrid() {
		for (int i = 0; i < grid.length; i++) 
		{
			for (int j = 0; j < grid.length; j++)
			{
				setGridLocation(i,j,false);
			}
		}
	}
	
	public boolean[][] getGrid()
	{
		return grid;
	}
	
	public void setGridLocation(int i, int j, boolean b) 
	{
		grid[i][j] = b;
	}
	
	public void displayGrid() {
		for (int i = 0; i < grid.length; i++) 
		{
			for (int j = 0; j < grid.length; j++)
			{
				int b = grid[i][j] ? 1 : 0;
				System.out.print("|" + b);
			}
		
			System.out.print("|"+'\n');
			for (int k = 0; k <= grid.length * 2; k++)
			{
				System.out.print("-");
			}
			System.out.print('\n');
		}
	}
}
