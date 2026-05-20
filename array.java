import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class array {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
       
        System.out.print("Enter number of integers: ");
        int size = scanner.nextInt();
        
        if (size <= 0) {
            System.out.println("Error: Please enter a number.");
            scanner.close();
            return;
        }
        
        int[] nums = new int[size];
        for (int i = 0; i < size; i++) {
            nums[i] = scanner.nextInt();
        }
        
        findMaxMin(nums);
        
        scanner.close();
    }

    public static void findMaxMin(int[] nums) {
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }

        int min = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
            }
        }

        double sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
        }

        double average = sum / nums.length;

        double roundedAverage = BigDecimal.valueOf(average)
                .setScale(2, RoundingMode.HALF_UP)
                .doubleValue();

        System.out.println(max + ", " + min + ", " + roundedAverage);
    }

}
