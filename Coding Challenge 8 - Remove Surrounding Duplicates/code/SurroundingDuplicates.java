public class SurroundingDuplicates {

    /* Assumptions
      Strings can be empty,
      Strings don't need to contain duplicates
      duplicates are case-sensitive
    */

    //function that takes a string and returns the same string without any surrounding duplicates
    public static String removeSurroundingDuplicates(String s) {
        //if the string length is 0 or 1 we can return the string since there is no duplicates for these cases
        if (s.length() == 0 || s.length() == 1) {
            return s;
        }

        //we store the string without duplicates in the result string
        String result = "";

        //loop through each char in the original string, if the current char is not equal to the next one, we add it to the result
        for (int i = 0; i<s.length()-1; i++) {
            if (s.charAt(i) != s.charAt(i+1)) {
                result += s.charAt(i);
            }
        }

        //this line handles the final character in the string since the loop ends at the second last character.
        //we just need to add the final character to the result (for both cases it must be added)
        result += s.charAt(s.length()-1);

        return result;
    }
    public static void main (String [] args) {

        //average case
        String s = "HeellllloooooWWoorldd";
        System.out.println("Original String: " + s);
        s = removeSurroundingDuplicates(s);
        System.out.println("Final String: " + s);

        //average case: no duplicates
        s = "HelLo World";
        System.out.println("Original String: " + s);
        s = removeSurroundingDuplicates(s);
        System.out.println("Final String: " + s);

        //special case: string empty
        s = "";
        System.out.println("Original String: " + s);
        s = removeSurroundingDuplicates(s);
        System.out.println("Final String: " + s);

        //special case: String has one character
        s = "A";
        System.out.println("Original String: " + s);
        s = removeSurroundingDuplicates(s);
        System.out.println("Final String: " + s);
    }
}