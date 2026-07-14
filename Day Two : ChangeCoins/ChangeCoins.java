import java.util.Arrays;

public class ChangeCoins {
    static int[] coins = {10, 5, 20, 1};
    
    private static int[] memo;

    public static int changeCoins(int money) {
        memo = new int[money + 1];
        Arrays.fill(memo, -1);
        
        return minCoinsRecursive(money);
    }

    private static int minCoinsRecursive(int money) {
        // Base Case 1: If money is 0, we need 0 coins
        if (money == 0) {
            return 0;
        }
        
        // Base Case 2: If money is negative, this path is invalid
        if (money < 0) {
            return -1; 
        }

        // Check Memo: If already calculated, return the stored result
        if (memo[money] != -1) {
            return memo[money];
        }

        int minCoins = Integer.MAX_VALUE;

        // Try every coin option
        for (int coin : coins) {
            int subResult = minCoinsRecursive(money - coin);

            // If the sub-problem has a valid solution, check if it's the minimum
            if (subResult != -1) {
                minCoins = Math.min(minCoins, subResult + 1);
            }
        }

        // Save the final minimum to the memo array before returning
        if (minCoins == Integer.MAX_VALUE) {
            memo[money] = -1;
        } else {
            memo[money] = minCoins;
        }

        return memo[money];
    }

    public static void main(String[] args) {
        int amount = 14;
        System.out.println("Minimum coins for " + amount + ": " + changeCoins(amount));
    }
}
