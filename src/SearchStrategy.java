public interface SearchStrategy {
	final int TOTAL_ITEMS = 8;
	public boolean[][] search(boolean[][] gameGrid);
	public String getName();
}
