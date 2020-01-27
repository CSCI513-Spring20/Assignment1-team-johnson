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
