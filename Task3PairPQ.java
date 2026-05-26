package part4;

public class Task3PairPQ {
	
	public static long solution(int[] A) {
		int size = A.length;
		long count = 0;
		
		for (int P=0; P < size-1; P++) {
			for (int Q=P+1; Q <size; Q++) {
				long sum = A[P] + A[Q];
					
				if (sum % 2 ==0) {
					count++;
				}
			}
		}
		
		
		return count > 1_000_000_000L ? -1 : count;
	}
	
	public static void main(String[] args) {
//		int[] A = {2,1,5,-6,9};
		int[] A = {1_000_000_000, -1_000_000_000, 2};
		
		long result = solution(A);
		
		System.out.println(result);
	}
}
