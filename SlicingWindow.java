package part5;

import java.util.*;

public class SlicingWindow {

    static int solution1(int[] A) {
        int N = A.length;

        Set<Integer> distinct = new HashSet<>();
        for (int value : A) {
            distinct.add(value);
        }
        int totalDistinct = distinct.size();

        Map<Integer, Integer> windowCount = new HashMap<>();
        int coveredDistinct = 0;
        int left      = 0;
        int bestStart  = 0;
        int bestLength = Integer.MAX_VALUE;

        for (int right = 0; right < N; right++) {
            int value = A[right];
            int count = windowCount.getOrDefault(value, 0);
            windowCount.put(value, count + 1);
            if (count == 0) {
                coveredDistinct++;
            }

            while (coveredDistinct == totalDistinct) {
                int currentLength = right - left + 1;
                if (currentLength < bestLength) {
                    bestLength = currentLength;
                    bestStart  = left;
                }

                int leftValue = A[left];
                windowCount.put(leftValue, windowCount.get(leftValue) - 1);
                if (windowCount.get(leftValue) == 0) {
                    coveredDistinct--;
                }
                left++;
            }
        }
        
        return bestLength - 1;
    }
    
    static int solution2(int[] A) {

        int[] distinctCheck = new int[A.length + 1];

        int totalDistinct = 0;

        for(int value : A) {

            if(distinctCheck[value] == 0) {
                totalDistinct++;
                distinctCheck[value] = 1;
            }
        }

        int[] frequency = new int[A.length + 1];

        int left = 0;
        int coveredDistinct = 0;

        int bestLength = Integer.MAX_VALUE;

        for(int right = 0; right < A.length; right++) {

            int value = A[right];

            if(frequency[value] == 0) {
                coveredDistinct++;
            }

            frequency[value]++;

            while(coveredDistinct == totalDistinct) {

                int currentLength =
                        right - left + 1;

                bestLength =
                        Math.min(bestLength,
                                currentLength);

                int leftValue = A[left];

                frequency[leftValue]--;

                if(frequency[leftValue] == 0) {
                    coveredDistinct--;
                }

                left++;
            }
        }

        return bestLength - 1;
    }

    public static void main(String[] args) {
        int[] A1 = {1,1,2,2,3,4,1,1};
       
        int[] A2 = {1, 1, 2, 2, 3, 4, 2};
      
        int[] A3 = {1,1,3,1,4,0,3,2};
        
        System.out.println(solution1(A1));
        System.out.println(solution1(A2));
        System.out.println(solution1(A3));
        
        System.out.println(solution2(A1));
        System.out.println(solution2(A2));
        System.out.println(solution2(A3));
    }
}