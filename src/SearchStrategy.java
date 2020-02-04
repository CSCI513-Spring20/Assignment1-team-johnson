/* SearchStrategy.java
 * 
 * Created by: Donald Johnson
 * 
 * Purpose: SearchStrategy.java defines an interface which concrete search strategies will implement.
 * 			It contains a variable indicating how many battleship hits will win the game, and two functions:
 * 			the search function which will be uniquely implemented by each concrete search strategy, and a getName function 
 * 			which simply returns the name of each particular strategy.
 */
public interface SearchStrategy {
	final int TOTAL_ITEMS = 8;
	public boolean[][] search(boolean[][] gameGrid);
	public String getName();
}
