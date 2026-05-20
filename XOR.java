import java.util.Scanner;

public class XOR {

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
        
        int result = singleNumber(nums);
        System.out.println(result);
        
        scanner.close();
    }
    
    // XOR (Exclusive OR) operation: 
    // It compares two operands bit by bit using symbol ^
    // It returns 0 if bits are the same 
    // and return the number in decimal if it isn't duplicate in the array.
    // Linear runtime: O(n).
    public static int singleNumber(int[] nums) {
        
        int result = 0;
        
        for (int i = 0; i < nums.length; i++) {
            result = result ^ nums[i];
        }
        
        return result;
    }
}
