package part4;

public class Task2Triplet {
	
	public static int solution1(int[] A) {
		int N = A.length;
		 
        for (int P = 0; P < N - 2; P++) {
            for (int Q = P + 1; Q < N - 1; Q++) {
                for (int R = Q + 1; R < N; R++) {
 
                    long ap = (long) A[P];
                    long aq = (long) A[Q];
                    long ar = (long) A[R];
                  
                    if (ap + aq > ar &&
                        aq + ar > ap &&
                        ar + ap > aq) {
                        return 1;
                    }
                }
            }
        }
 
        return 0;
	}
	
	public static int solution2(int[] A) {
		int N = A.length;
        if (N < 3) {
        	return 0;
        }
 
        int[] newA = new int[N];
        for (int i = 0; i < N; i++) {
            newA[i] = A[i];
        }
        
        for (int i = 0; i < N - 1; i++) {
        	for (int j = 0; j < N - 1 - i; j++) {
        		if (newA[j] > newA[j + 1]) {
        			int temp = newA[j];
        			newA[j] = newA[j + 1];
        			newA[j + 1] = temp;
        		}
        	}
        }
        
        for (int i = 0; i < N - 2; i++) {
            if ((long) newA[i] + (long) newA[i + 1] > (long) newA[i + 2]) {
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
//				Integer.MAX_VALUE};
		
		int result = solution1(A);
		System.out.println(result);
		
	}
}