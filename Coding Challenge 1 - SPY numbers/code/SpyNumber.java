import java.util.Scanner;

public class SpyNumber {

    /**
     * This method tests if a number (int) is considered a SPY number.
     * A number is a Spy number if the sum and product of its digits are Equal:
     * 
     * Number = xyz where x,y,z are digits
     * Number xyz is spy if: (x+y+z) = (x*y*z)
     * 
     * Assumptions:
     * when num = 0: returns true
     * when num < 0: returns based on the magnitude of the number (treat as possitive number)
     * when num has a single digit must return true
     * 
     * @param num number to be tested as a SPY number
     * @return Boolean defining if num is a SPY number or not
     */
    public static boolean isSpy(int num) {
        //handle 0 case since 0 will not work when calculating length
        if (num == 0){
            return true;
        } 
        //handles case when integer is negative
        if (num < 0) {
            num *= -1;
        }

        //general case
        int length = (int) (Math.log10(num) + 1); //number of digits in the number e.g. 123 -> length = 3
        int leftSide = 0; 
        int rightSide = 1; //must be 1 for multiplication to work
        //loop through each digit to calculate left side and right side
        for (int i = 0; i < length; i++) {
            int x = Character.getNumericValue(String.valueOf(num).charAt(i));
            leftSide += x; //add to left side
            rightSide = rightSide * x; //multiple to right side
        }
        return leftSide == rightSide;
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
        if (isSpy(num)) {
            System.out.println("Value " + num + " is a spy number!");
        } else {
            System.out.println("Value " + num + " is not a spy number!");
        }
    }
}