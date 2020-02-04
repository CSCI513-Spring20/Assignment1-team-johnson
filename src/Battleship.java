/* Battleship.java
 * 
 * Created by: Donald Johnson
 * 
 * Purpose: Battleship.java defines an abstract battleship class, the attributes and functions of which can specified by concrete battleship subclasses.
 */
public abstract class Battleship 
{
	final int GRID_SIZE = 25;
	int size;
	String name;
	boolean[][] position = new boolean[GRID_SIZE][GRID_SIZE];
	
	public Battleship(int s, String n) 
	{
		size = s;
		name = n;
		for (int i = 0; i < position.length; i++)
		{
			for (int j = 0; j < position.length; j++)
			{
				position[i][j] = false;
			}
		}
	}
	int getSize() 
	{
		return size;
	}
	String getName() 
	{
		return name;
	}
	boolean getPosition(int x, int y)
	{
		return position[x][y];
	}
	void setPosition(int x, int y) {
		position[x][y] = true;;
	}
}
