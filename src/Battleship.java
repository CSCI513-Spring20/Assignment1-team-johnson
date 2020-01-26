public abstract class Battleship 
{
	int size;
	String name;
	boolean[][] position = new boolean[25][25];
	
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
	boolean[][] getPosition()
	{
		return position;
	}
	void setPosition(boolean[][] p) {
		position = p;
	}
}
