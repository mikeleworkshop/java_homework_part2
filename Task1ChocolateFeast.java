package part5;

public class Task1ChocolateFeast {
	
	public static int solution1 (int money, int cost, int wrappersNeed) {
		int numBars = money / cost;
		int numWrappers = numBars;
		
		while (numWrappers >= wrappersNeed) {
			int newBars = numWrappers / wrappersNeed;
			numBars += newBars;
			
			int remaining = numWrappers % wrappersNeed;
			remaining += newBars;
			numWrappers = remaining;
		}
		
		return numBars;
		
	}
	
	public static int solution2 (int money, int cost, int wrappersNeed) {
		int numBars = money / cost;
		int numWrappers = numBars;
		
		if (numWrappers > 1 && numWrappers >= wrappersNeed) {
			numBars += (numBars - 1) / (wrappersNeed -1);
		}
		
		return numBars;
	}
	
	public static void main(String[] args) {
		        System.out.println(solution1(126, 2, 4));
		      
	}
}

