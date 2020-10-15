public class BinaryConversion {
    /* Assumptions
        The integer can be a negative value
        A negative value is handled by adding an extra 1 to the total
    */

    //takes an input of a decimal integer and ouputs the number of 1's are in the binary number of that integer
    public static int numberBinaryOnes(int x) {

        //handles the cases of 0 and 1
        if (x == 0) {
            return 0;
        } else if (x == 1) {
            return 1;
        }

        int counter = 0;

        //handles if the value of X is negative (a binary digit is identified as negative by the most significant bit)
        if (x < 0) {
            counter ++;
            x = x*-1;
        }
        
        //Until the integer value is 1, loop and check if the division of 2 would yield a remainder or not.
        //if a remainder is found increase the counter. set the integer value to itself divided by 2
        while (x!=1) {
            if (x%2 == 1) {
                counter ++;
            }
            x = (int) x/2;
        }

        //we increase the counter once here to handle when the value of the integer is 1
        counter++;

        return counter;
    }
    public static void main(String [] args) {
        int value = 124;
        System.out.println("The number of binary ones is: " + numberBinaryOnes(value));
    }
}