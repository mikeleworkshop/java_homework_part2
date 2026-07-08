import java.util.*;

public class FibFrog {	
	public static int solution(int[] A) {
        int N = A.length;

        ArrayList<Integer> fibonacci = new ArrayList<>();
        int f1 = 1, f2 = 2;
        fibonacci.add(f1);
        fibonacci.add(f2);
        while (true) {
            int nextFibonacci = f1 + f2;
            if (nextFibonacci > N + 1)
                break;
            fibonacci.add(nextFibonacci);
            f1 = f2;
            f2 = nextFibonacci;
        }

        ArrayList<int[]> list = new ArrayList<>();

        boolean[] visited = new boolean[N + 1];
        
        list.add(new int[] { -1, 0});
        
        while (!list.isEmpty()) {
            int[] current = list.get(0);
            System.out.println("Current array: " + current);
            list.remove(0);
            
            int currentPosition = current[0];
            int currentJumps = current[1];

            for (int fib : fibonacci) {
                int nextPosition = currentPosition + fib;
                System.out.println("currentPosition: " + currentPosition);
                System.out.println("fib: " + fib);
                System.out.println("nextPosition: " + nextPosition);
                System.out.println("end");

                if (nextPosition == N) {
                	System.out.println("currentJumps" + currentJumps);
                    return currentJumps + 1;
                }

                if (nextPosition >= 0 && nextPosition < N && A[nextPosition] == 1 && !visited[nextPosition]) {
                    visited[nextPosition] = true;
                    list.add(new int[] { nextPosition, currentJumps + 1 });
                }
            }
        }

        return -1;
    }
	
	public static int solution2(int[] A) {
        int N = A.length;

        ArrayList<Integer> fibonacci = new ArrayList<>();
        int f1 = 1, f2 = 2;
        fibonacci.add(f1);
        fibonacci.add(f2);
        while (true) {
            int nextFibonacci = f1 + f2;
            if (nextFibonacci > N + 1)
                break;
            fibonacci.add(nextFibonacci);
            f1 = f2;
            f2 = nextFibonacci;
        }
	}
	
	public static void main(String[] args) {		
		int[] A = { 0, 0, 1, 1, 1, 0, 1, 0, 0, 0, 0};
        System.out.println("The minimum number of jumps: " + solution(A));
	}
}
