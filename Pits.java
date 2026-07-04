public class Pits {
	
    public static void main(String[] args) {

        // Example from the exercise
        int[] example = {0, 1, 3, -2, 0, 1, 0, -3, 2, 3};
        System.out.println(solution(example));
    }
    
    public static int solution(int[] A) {
            int N = A.length;
            if (N < 3) {
                return -1;
            }

            int[] left = new int[N];
            int[] right = new int[N];

            left[0] = 0;
            for (int i = 1; i < N; i++) {
                if (A[i - 1] > A[i]) {
                    left[i] = left[i - 1];
                } else {
                    left[i] = i;
                }
            }

            right[N - 1] = N - 1;
            for (int i = N - 2; i >= 0; i--) {
                if (A[i] < A[i + 1]) {
                    right[i] = right[i + 1];
                } else {
                    right[i] = i;
                }
            }

            int best = -1;
            boolean found = false;
            
            for (int Q = 1; Q < N - 1; Q++) {
                int P = left[Q];
                int R = right[Q];
                if (P < Q && R > Q) {
                    found = true;
                    int depth = Math.min(A[P] - A[Q], A[R] - A[Q]);
                    if (depth > best) {
                        best = depth;
                    }
                }
            }

            if (found) {
                return best;
            } else {
                return -1;
            }
    }
    
}