package part4;

import java.util.Arrays;
public class Task2Triplet {
	
	public static int solution(int[] A) {
		int size = A.length;
		
//		for (int P=0; P < size-2; P++) {
//			
//			if (A[P] <= 0) continue;
//			for (int Q=P+1; Q<size-1; Q++) {
//				
//				if (A[Q] <= 0) continue;
//				for (int R=Q+1; R<size; R++) {
//					
//					if (A[R] <= 0) continue;
//					
//					long arrayP = (long) A[P];
//					long arrayQ = (long) A[Q];
//					long arrayR = (long) A[R];
//					
//					if (arrayP + arrayQ > arrayR &&
//						arrayQ + arrayR > arrayP &&
//						arrayR + arrayP > arrayQ) {
//						return 1;
//					}
//				}
//			}
//		}
		
		if (size<3) return 0;
		
		int[] sortedA = Arrays.copyOf(A,size);
		Arrays.sort(sortedA);
		
//		for (int i=0; i<size-2; i++) {
//			for (int j=i+1; j<size-1; j++) {
//				for (int k=j+1; k<size; k++) {
//					
//					if ((long) sortedA[i] + (long) sortedA[j] > (long) sortedA[k]) {
//						return 1;
//					}
//				}
//			}
//		}
		
		for (int i = 0; i<size-2; i++) {
			if ((long) sortedA[i] + (long) sortedA[i+1] > (long) sortedA[i+2]) {
				return 1;
			}
		}
		
		
		return 0;
	}
	public static void main(String[] args) {
		int[] A = {10, 2, 5, 1, 8, 20};
//		int[] A = {10, 50, 5, 1};
//		int[] A = {5, -3, -1, 8, 20};
//		int[] A = {Integer.MAX_VALUE,Integer.MAX_VALUE, 
//				Integer.MAX_VALUE, Integer.MAX_VALUE};
		
		int result = solution(A);
		System.out.println(result);
		
	}
}