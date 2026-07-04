public class Dominator {
	
    public static void main(String[] args) {
        int[] A = {3, 4, 3, 2, 3, -1, 3, 3};
        int[] result = solution(A);
        
        System.out.println("The dominator of array is ");
        for (int i = 0; i < result.length; i++) { 
	        System.out.print(result[i] + " ");
        }
    }

    public static int[] solution(int[] A) {
            int N = A.length;

			int[] result = new int[N - 1];
			
            if (N == 0) {
				return null;
            }

            int candidate = A[0];
            int votes = 0;
            int occurrences = 0;
            int index = 0;
            for (int i = 0; i < N; i++) {
                if (votes == 0) {
                    candidate = A[i];
                }
                if (A[i] == candidate) {
                    votes++;
                    occurrences++;
                    result[index] = i;
                    index++;
                } else {
                    votes--;
                }
            }
            
            if (occurrences > N / 2.0) {
            	return result;
            } else {
            	return null;
            }
        }
}
