
public class BattleshipTester 
{
	public static void main(String[] args) 
	{
		BattleshipSearch bs = new BattleshipSearch();
		bs.setGameNumber(0);
		bs.readCoordinates();
		bs.displayGame(0);
		bs.identifyShip(0, 0);
	}
}
