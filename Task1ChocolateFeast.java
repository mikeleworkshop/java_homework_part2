package part5;

public class Task1ChocolateFeast {
	
	public static int solution1(int initialMoney, int cost, int wrappersNeed) {
        int numBars = initialMoney / cost;
        int numEaten = numBars;
        int numWrappers = numBars;
        
        while (numWrappers >= wrappersNeed) {
            int newBars = numWrappers / wrappersNeed;
            System.out.println("numWrappers: " + numWrappers);
	        System.out.println("end");
	        
            numEaten = numEaten + newBars;
            
            int remaining = numWrappers % wrappersNeed;
            System.out.println("remaining: " + remaining);
	        System.out.println("end");
	        
            numWrappers = remaining + newBars;
            System.out.println("numWrappers: " + numWrappers);
	        System.out.println("end");
        }
        
        return numEaten;
    }
	
	public static int solution2(int initialMoney, int cost, int wrappersNeed) {
        int numBars = initialMoney / cost;
        
        if (wrappersNeed > 1 && numBars >= wrappersNeed) {
        	numBars += (numBars - 1) / (wrappersNeed - 1);
        }
        
        return numBars;
	}
	
	public static void main(String[] args) {
		        System.out.println(solution2(15, 3, 2)); // Expected: 6
		      
	}
}

