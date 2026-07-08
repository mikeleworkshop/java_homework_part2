import java.util.Arrays;

public class ChangeCoins {
    static int[] coins = {1, 5, 10, 20};

    public static int changeCoins(int money) {
        int[] dp = new int[money + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int amount = 1; amount <= money; amount++) {
            for (int coin : coins) {
                if (coin <= amount && dp[amount - coin] != Integer.MAX_VALUE) {
                    dp[amount] = Math.min(dp[amount], dp[amount - coin] + 1);
                }
            }
        }
        return dp[money];
    }

    public static void main(String[] args) {
        System.out.println(changeCoins(31));
    }
}