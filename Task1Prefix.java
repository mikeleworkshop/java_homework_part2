
package part4;

import java.util.HashSet;

class Task1Prefix {

    public int solution1(int[] A) {
    	int N = A.length;
    	
    	int[] f = new int[N];
    	for (int target = 0; target < N; target++) {
    		f[target] = -1;
    		for (int i = 0; i<N; i++) { 
    			if (A[i] == target) { // Iterate until we find a value in A math with target
    				f[target] = i; // f stores results of i(number of iterations)
    				break;
    			}
    		}
    	}
    	
    	int answer = 0;
    	for (int i=0;i<N; i++) { // the biggest number of iterations stored in f is the answer
    		if (f[i] != -1 && f[i] > answer) {
    				answer = f[i];
    		}
    	}
    	
    	return answer;
    	
    }
    
    public int solution2(int[] A) {
    	
    	HashSet<Integer> containA = new HashSet<>();
    	for (int value : A) {
    		containA.add(value);
    	}
    	
    	HashSet<Integer> compare = new HashSet<>();
    	
    	
    	for (int i=0; i<A.length; i++) {
    		compare.add(A[i]);
    		
    		if (compare.size() == containA.size()) {
    			return i;
    		}
    	}
    	
    	return A.length-1;
    	
    }

    public static void main(String[] args) {

        Task1Prefix sol = new Task1Prefix();

        int[] example1 = {2,2,1,0,1};
        System.out.println("Result : " + sol.solution2(example1)); 
        System.out.println();
    }
}