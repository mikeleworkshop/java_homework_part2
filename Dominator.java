public class Dominator {
	
    public static void main(String[] args) {
        int[] A = {3, 4, 3, 2, 3, -1, 3, 3};
        int result = solution(A);
        System.out.println("The dominator of array is " + A[result]); 
    }

    public static int solution(int[] A) {
            int N = A.length;
            if (N == 0) {
                return -1;
            }

            int target = A[0];
            int count = 0;
            int occurrences = 0;
            int index = 0;
            for (int i = 0; i < N; i++) {
                if (count == 0) {
                    target = A[i];
                }
                if (A[i] == target) {
                    count++;
                    occurrences++;
                    index = i;
                } else {
                    count--;
                }
            }
            
            if (occurrences > N / 2.0) {
            	return index;
            } else {
            	return -1;
            }   
        }
}