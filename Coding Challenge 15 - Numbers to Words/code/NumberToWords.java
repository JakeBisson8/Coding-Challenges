public class NumberToWords {

    public static void convertNumberToWords(int value) {
        //checks if the value is in the required range
        if (999 < value && value < 1000000000) {

        } else {
            System.out.println("Value: " + value + " was not in the valid range 999 < value < 1000000000");
        }
    }
    public static void main (String [] args) {

        //invalid case: low
        int value = 999;
        convertNumberToWords(value);

        //invalid case: high
        value = 1000000000;
        convertNumberToWords(value);

        //general case
        value = 5804;
        convertNumberToWords(value);
    }
}