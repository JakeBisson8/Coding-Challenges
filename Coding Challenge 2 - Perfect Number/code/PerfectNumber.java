import java.util.Scanner;

public class PerfectNumber {

    /**
     * This method tests if a number (int) is considered a perfect number.
     * A number is a perfect number if the sum of its proper positive divisors (excluding itself) are equal to itself:
     * 
     * 6 -> proper divisors = 1,2,3, 1+2+3 = 6 ; therefore 6 is a perfect number
     * 
     * Assumptions:
     * when num = 0: returns false
     * when num < 0: returns based on the magnitude of the number (treat as possitive number)
     * 
     * @param num number to be tested as a perfect number
     * @return boolean defining if num is a perfect number or not
     */
    public static boolean isPerfectNumber(int num) { // O(n) average case O(n/2)
        //case num = 0: must return false
        if (num == 0){
            return false;
        }
        //case num < 0: treat as positive value
        if (num < 0) {
            num *= -1;
        }
        //general case
        int limit = num / 2;
        int divisorSum = 0;
        //loop through range [1, num/2], if num is divisible by any integer i in this range it is a divisor, add to divisor sum
        for (int i = 1; i <= limit; i++) { 
            if (num % i == 0){
                divisorSum += i;
            }
        }
        return num == divisorSum;
    }

    public static void main(String [] args) { 
        //retrieve an integer value from the user and store in variable x
        Scanner in = new Scanner(System.in);
        boolean isValid = false;
        int num = 0; 
        String input;
        while (!isValid) {
            System.out.println("Please enter a valid integer:");
            input = in.nextLine();
            try {
                num = Integer.parseInt(input);
                isValid = true; 
            } catch (Exception e) {
                System.out.println("Sorry that is not a valid integer");
            }
        }
        in.close(); //close scanner

        //check if the value of x is spy and notify user accordingly
        if (isPerfectNumber(num)) {
            System.out.println("Value " + num + " is a perfect number!");
        } else {
            System.out.println("Value " + num + " is not a perfect number!");
        }
    }
}