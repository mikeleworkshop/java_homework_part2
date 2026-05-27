
package part4;

class Task1Prefix {

    public int solution(int[] A) {
    	
    	int size = A.length;
    	
    	int prefix;
    	
    	for (prefix=0; prefix<size; prefix++) {
    		boolean prefixCoverAll = true;
    		
    		for (int i=0; i<size; i++) { // in A to compare
    			boolean foundInPrefix = false;
    			
    			for (int j=0; j<= prefix; j++) { // in prefix
    				if (A[j] == A[i]) {
    					foundInPrefix = true;
    					break;
    				}
    			}
    			
    			if (!foundInPrefix) {
    				prefixCoverAll = false; // prefix hasn't covered all yet
    				break;
    			}
    		} 
    		
    		if (prefixCoverAll) return prefix;
    	}
        return size - 1;
    }

    public static void main(String[] args) {

        Task1Prefix sol = new Task1Prefix();

        int[] example1 = {3,4,3,1,4,4,2};
        System.out.println("Result : " + sol.solution(example1)); 
        System.out.println();
    }
}
