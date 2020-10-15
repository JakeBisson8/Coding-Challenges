//Jake Bisson (jlb4@rogers.com / jbiss085@uottawa.ca)

import java.util.Arrays;

public class MostRepeated {
    /*Assumptions: 
        Arrays are String arrays only, 
        arrays may contain alpha-numeric characters, 
        arrays contain upper-case and lower-case, 
        Duplicates are case sensitive, 
        Each array is full with items (no null values),
        original array is not required to be maintained,
        arrays are provided to the functions unsorted.
    */
    
    //function to add an item to an array - O(n)
    public static String[] addItem(String [] a, String s){
        String [] a2 = new String[a.length+1];
        for (int i = 0; i<a.length; i++){ //O(n)
            a2[i] = a[i];
        }
        a2[a2.length-1]=s;
        return a2; 
    }

    // function to display the most repeated element(s) in an array
    public static void mostRepeated(String [] a) {
        //if the array is of size 0 we output nothing
        if (a.length == 0) {
            System.out.println("Most Repeated: array empty");
        }
        //if the array is of size 1 we output the single element in the array
        if (a.length == 1) {
            System.out.println("Most Repeated: " + Arrays.toString(a));
        }

        //if the array is any other size we perform the algorithm
        if (a.length > 1) {

            //sort the array
            Arrays.sort(a); //O(nlogn)
            int consecutiveCounter = 1;
            int maxConsecutive = 1; 
            String [] results = new String [0];
            for (int i = 0; i<a.length-1; i++) { //O(n)

                //if the next value over is equal, increase consecutive counter
                if (a[i].equals(a[i+1])) {
                    consecutiveCounter++;
                } 

                //if the next value was not equal or we are at the end of the loop, we want to evaluate the counters to identify consecutives
                if (!a[i].equals(a[i+1]) || i==a.length-2) {
                    //if the consecutive counter is greater than the current most consecutive reset results array and add the item,
                    //if the consecutve counter is equal to the most consecutive add the value to the array without resetting the results
                    if (consecutiveCounter > maxConsecutive) {
                        results = new String [0];
                        results = addItem(results, a[i]);
                        maxConsecutive = consecutiveCounter;
                    } else if (consecutiveCounter == maxConsecutive) {
                        results = addItem(results, a[i]);
                    }
                    consecutiveCounter = 1;
                }
            }

            //display the contens of the array
            System.out.println("Most Repeated: " + Arrays.toString(results));
        }
    }


    public static void main(String [] args) {

        //array with mutitple values and multiple consecutives
        String [] array = new String[]{"Hello"};
        array = addItem(array, "Hello");
        array = addItem(array, "Hello");
        array = addItem(array, "h3110");
        array = addItem(array, "hello");
        array = addItem(array, "hello");
        array = addItem(array, "WORLD!");
        array = addItem(array, "hi");
        array = addItem(array, "hi");
        array = addItem(array, "hi");
        System.out.println("Original Array:");
        System.out.println(Arrays.toString(array));
        mostRepeated(array);

        //array with multiple values and one consecutive at in the middle
        array = new String[]{"Hello"};
        array = addItem(array, "h3110");
        array = addItem(array, "hello");
        array = addItem(array, "hello");
        array = addItem(array, "WORLD!");
        array = addItem(array, "hi");
        array = addItem(array, "heLLo");
        System.out.println("Original Array:");
        System.out.println(Arrays.toString(array));
        mostRepeated(array);

        //single array value
        array = new String[]{"Hello"};
        System.out.println("Original Array:");
        System.out.println(Arrays.toString(array));
        mostRepeated(array);

        //array with no values
        array = new String[0];
        System.out.println("Original Array:");
        System.out.println(Arrays.toString(array));
        mostRepeated(array);
    }
}