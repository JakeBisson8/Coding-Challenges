import java.util.Arrays;

public class AlphabeticalOrder {

    public static String alphabeticalOrder(String s){
        //variables
        //convert string into array
        char [] characters = s.toCharArray();
        
        //sort array of characters from smallest char to greatest
        int p1;
        int p2;
        for (int i = 0; i<characters.length; i++){
            for (int j = 0; j<characters.length-1; j++){
                p1 = j;
                p2 = j+1;

                if (Character.toUpperCase(characters[p2]) < Character.toUpperCase(characters[p1])){
                    char temp = characters[p1];
                    characters[p1] = characters[p2];
                    characters[p2] = temp;
                }
            }
        }
        //return sorted array converted back into a string
        return Arrays.toString(characters);
    }
    public static void main(String [] args){
        String original = "NextGenCoder";
        String result = alphabeticalOrder(original);
        System.out.println(original);
        System.out.println(result);
    }
}