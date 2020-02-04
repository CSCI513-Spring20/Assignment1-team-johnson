/* BattleshipTester.java
 * 
 * Created by: Donald Johnson
 * 
 * Purpose: BattleshipTester.java defines the BattleshipTester class which contains the main method of this package.
 * 			The main method iterates through each of the three different games and performs each of the three different search strategies
 * 			for each game.
 */
public class BattleshipTester 
{
	public static void main(String[] args) 
	{
		final int numOfGames = 3;
		BattleshipSearch bs = new BattleshipSearch();
		bs.readCoordinates();
		for (int i = 0; i < numOfGames; i++)
		{
			bs.setGameNumber(i);
			bs.searchStrategy = new HorizontalSweepStrategy();
			bs.performSearch();
			bs.searchStrategy = new RandomSearchStrategy();
			bs.performSearch();
			bs.searchStrategy = new StrategicSearchStrategy();
			bs.performSearch();
		}
	}
}
