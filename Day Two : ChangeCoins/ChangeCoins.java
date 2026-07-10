public class ChangeCoins {
    static int[] coins = {1, 5, 10, 20};

    public static int changeCoins(int money) {
    	int[] array = new int[money + 1];
    	
    	int index = 1;
    	int changeTimes = 0;
    	
//    	if (coins[coins.length] < money) {
//    		changeTimes = 1;
//    		amount = coins[coins.length];
//    	}
    	
//    	for (amount; amount <= money; amount++)
    	
    	for (int amount = 1; amount <= money; amount++) {
            for (int coin : coins) {
            	
            	System.out.println("index = " + index);
            	System.out.println("coin = " + coin);
            	
            	if (index == coin) {
            		array[index] = 1;
            		System.out.println("array[" + index + "] = " + array[index]);
            		
            		if (amount + coin > money) {
                		changeTimes++;
                		index = 0;
                		System.out.println("changeTimes = "  + changeTimes);
                	}
            	}
            	
            }
            index++;
        }
        return changeTimes;
    }

    public static void main(String[] args) {
        System.out.println(changeCoins(31));
    }
}