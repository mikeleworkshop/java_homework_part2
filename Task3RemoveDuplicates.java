package part5;

import java.util.ArrayList;
import java.util.Arrays;


public class Task3RemoveDuplicates {
	
	static void solution1(int[] nums) {
		int N = nums.length;
		
		System.out.println(nums[0] + " ");
		
		for (int i = 1; i < N; i++) {
			if (nums[i] != nums[i - 1]) {
				System.out.println(nums[i] + " ");
			}
		}
	}
	
	static void solution2(int[] nums) {
		int N = nums.length;
		
		ArrayList<Integer> result = new ArrayList<>();

	      result.add(nums[0]);

	      for(int i = 1; i < N; i++) {

	          if(nums[i] != nums[i - 1]) {
	              result.add(nums[i]);
	          }
	      }

	      System.out.println(result);
		}
	
	static void solution3(int[] nums) {
		int uniqueCount = 1;

        for (int i = 1; i < nums.length; i++) {

            if (nums[i] != nums[i - 1]) {
                uniqueCount++;
            }
        }

        int[] result = new int[uniqueCount];

        result[0] = nums[0];
        int index = 1;

        for (int i = 1; i < nums.length; i++) {

            if (nums[i] != nums[i - 1]) {
                result[index] = nums[i];
                index++;
            }
        }

        System.out.println(Arrays.toString(result));
	}
	
	static void solution4(int[] nums) {
		int[] temp = new int[nums.length];

        int size = 0;

        temp[size++] = nums[0];

        for (int i = 1; i < nums.length; i++) {

            if (nums[i] != nums[i - 1]) {
                temp[size++] = nums[i];
            }
        }

        int[] result = new int[size];

        for (int i = 0; i < size; i++) {
            result[i] = temp[i];
        }

        System.out.println(Arrays.toString(result));
	}
	
	static void solution5(int[] nums) {
		int[] result = new int[1];
        int size = 0;

        result[size++] = nums[0];

        for (int i = 1; i < nums.length; i++) {

            if (nums[i] != nums[i - 1]) {

                if (size == result.length) {

                    int[] bigger = new int[result.length * 2];

                    for (int j = 0; j < result.length; j++) {
                        bigger[j] = result[j];
                    }

                    result = bigger;
                }

                result[size++] = nums[i];
            }
        }

        System.out.println(Arrays.toString(
                Arrays.copyOf(result, size)));
	}

    public static void main(String[] args) {

        int[] nums = {1,1,2,2,3};
        
        solution1(nums);
        solution2(nums);
        solution3(nums);
        solution4(nums);
        solution5(nums);
        
    }
}