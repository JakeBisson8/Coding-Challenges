public class NumberToWords {

    public static String[] ones = new String[]{"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    public static String[] tens = new String[]{"", "", "Twenty", "Thirty", "Fourty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    public static String[] others = new String[]{"hundred", "thousand", "million"};

    public static void convertNumberToWords(int value) {
        //checks if the value is in the required range
        if (999 < value && value < 1000000000) {
            String stringValue = String.valueOf(value);
            

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