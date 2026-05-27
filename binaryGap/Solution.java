class Solution {
    public static String toBinary(int num) {
        if (num == 0) return "0";

        String binary = "";

        while (num > 0) {
            int remainder = num % 2;
            binary = remainder + binary;
            num = num / 2;
        }
        
        return binary;
    }
    
    public int solution(int N) {

        String binary = toBinary(N);

        int maxGap = 0;
        int count = 0;
        boolean counting = false;
        
        for (int i = 0; i < binary.length(); i++) {

            if (binary.charAt(i) == '1') { // whenever a 1 is found
                if (counting) { // , stop counting
                    maxGap = Math.max(maxGap, count); // and save the max gap
                }
                count = 0; // reset
                counting = true; // begin to count for next gap

            } else { // Found a '0', start counting
                if (counting) {
                    count++;
                }
            }
        }

        return maxGap;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.solution(9)); 
        System.out.println(sol.solution(529)); 
        System.out.println(sol.solution(20)); 
        System.out.println(sol.solution(15));
        System.out.println(sol.solution(32)); 
        System.out.println(sol.solution(1041));
    }
}
