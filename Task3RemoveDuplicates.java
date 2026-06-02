package part5;

import java.util.ArrayList;

public class Task3RemoveDuplicates {

    public static void main(String[] args) {

        int[] nums = {1,1,2};

        ArrayList<Integer> result = new ArrayList<>();

        result.add(nums[0]);

        for(int i = 1; i < nums.length; i++) {

            if(nums[i] != nums[i - 1]) {
                result.add(nums[i]);
            }
        }

        System.out.println(result);
    }
}