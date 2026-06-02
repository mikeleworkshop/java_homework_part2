package part5;

public class Task4MoveZeros {

    public static void main(String[] args) {

        int[] nums = {0,1,0,3,4,5};

        int[] result = new int[nums.length];

        int index = 0;

        for(int num : nums) {

            if(num != 0) {
                result[index++] = num;
            }
        }

        for(int num : result) {
            System.out.print(num + " ");
        }
    }
}