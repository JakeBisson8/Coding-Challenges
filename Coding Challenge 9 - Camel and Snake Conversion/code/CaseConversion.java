//Jake Bisson (jlb4@rogers.com / jbiss085@uottawa.ca)

public class CaseConversion {

    /* Assumptions
        cases that contain no capital letters or '_' characters will be considered as camel case

        camel case: NO '_' characters, capital characters are optional
            valid cases: camelCase, camel, thisIsCamelCase, thisiscamelcase, s
        Snake case: at least 1 '_' character, capital characters are optional
            valid cases: snake_case, snake_, _snake_, this_is_snake_case, snake___case
    */

    //defines the case types
    enum Case {SNAKE, CAMEL}

    //function that checks if a string is in camelCase or snake_case 
    public static Case isCamelOrSnake(String s) {
        //check if the string contains an '_' string if it does, the string is snake case, otherwise the string is camel case
        for (int i = 0; i<s.length(); i++) {
            if (s.charAt(i) == '_') {
                return Case.SNAKE;
            }
        }
        return Case.CAMEL;
    }

    //function that converts camelCase to snake_case
    public static String convertToCamel(String s) {
        //convert all characters in the string to lowercase
        s = s.toLowerCase();
        boolean isUnderscore = false;
        String result = "";
        for (int i = 0; i<s.length(); i++) {
            //check if the current character is a '_' character
            if (s.charAt(i) == '_') {
                isUnderscore = true;
            } else if (isUnderscore) {
                char temp = s.charAt(i);
                temp = Character.toUpperCase(temp);
                result += temp;
                isUnderscore = false;
            } else {
                result += s.charAt(i);
            }
        }
        return result;
    }

    //function that converts snake_case to camelCase
    public static String convertToSnake(String s) {
        String result = "";

        for (int i = 0; i<s.length(); i++) {
            char current = s.charAt(i);
            if (Character.isUpperCase(current)) {
                current = Character.toLowerCase(current);
                result += "_" + current;
            } else {
                result += current;
            }
        }

        return result;
    }

    public static void main (String [] args) {

        //Case: camel case
        String s = "camelCase";
        System.out.println("Case: " + s);
        Case case1 = isCamelOrSnake(s);
        System.out.println("returned: " + case1);
        s = convertToSnake(s);
        System.out.println("converted to snake: " + s); 

        //Case: snake case
        s = "snake_case";
        System.out.println("Case: " + s);
        case1 = isCamelOrSnake(s);
        System.out.println("returned: " + case1);
        s = convertToCamel(s);
        System.out.println("converted to camel: " + s); 
    }
}