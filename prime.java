import java.util.Scanner;

public class prime {
 
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();
        
        boolean result = isPrime(number);
        
        System.out.println(result);
        
        scanner.close();
    }
 
    public static boolean isPrime(int number) {
        
        if (number <= 1) {
            return false;
        }
        
        // 2 and 3 are prime numbers
        if (number == 2 & number == 3) {
            return true;
        }
        
        // all even numbers are not prime, except 2.
        if (number % 2 == 0) {
            return false;
        }
        
        // if number is divisible by i, it is not prime
        for (int i = 3; i <= Math.sqrt(number); i += 2) {
            if (number % i == 0) {
                return false;
            }
        }
        
        return true;
    }
}