public class BattleshipTester 
{
	public static void main(String[] args) 
	{
		BattleshipSearch bs = new BattleshipSearch();
		bs.searchStrategy = new StrategicSearchStrategy();
		bs.setGameNumber(2);
		bs.readCoordinates();
		bs.search();
	}
}
