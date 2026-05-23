class Solution {
	
	public int solution(int[] A) {
		long result = solve(A,0,0);
		return (int) (result % 1_000_000_000L);
	}
	
	long solve(int[] A,int index, int sign) {
		
		// BASE CASE
		if (index == A.length) {
			return 0;
		}
		
		// make recursive calls
		long skip = solve(A, index + 1, sign);
		
		// long keep = A[index] + solve(A,index+1, 1-sign);
		long keep;
		if (sign == 0) { //if the current element has the sign of +
			keep = A[index] + solve(A, index+1, 1);
		} else { //if the current element has the sign of -
			keep = -A[index] + solve(A, index+1, 0);
		}
				
		return Math.max(skip, keep);
	}
	

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] A = {4,1,2,3};
        System.out.println(sol.solution(A));
//        int[] A = {1,2,3,3,2,1,5};
//        System.out.println(sol.solution(A));
//        int[] A = {1000000000,1,2,2,1000000000,1,1000000000};
//        System.out.println(sol.solution(A));
        
        
    }
}