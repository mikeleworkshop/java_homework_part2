import java.util.Scanner;

public class palindrome {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter number of integers: ");
        int size = scanner.nextInt();
        
        if (size <= 0) {
            System.out.println("Error: Please enter a number");
            scanner.close();
            return;
        }
        
        int[] nums = new int[size];
        for (int i = 0; i < size; i++) {
            nums[i] = scanner.nextInt();
        }
        
        boolean result = isPalindrome(nums);
        
        System.out.println(result);
        
        scanner.close();
    }

    public static boolean isPalindrome(int[] nums) {
    	// two pointers: left & right
        int left = 0;
        int right = nums.length - 1;
        
        // compare numbers in array at left and right positions
        // if we find any couple has different numbers, array is not a palindrome
        while (left < right) {
            if (nums[left] != nums[right]) {
                return false;
            }
            
            // move toward middle
            left++;
            right--;
        }
        
        return true;
    }
}