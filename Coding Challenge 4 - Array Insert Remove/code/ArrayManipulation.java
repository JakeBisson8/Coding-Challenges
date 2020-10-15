//Jake Bisson (jlb4@rogers.com / jbiss085@uottawa.ca)

import java.util.Arrays; 

public class ArrayManipulation {
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
    //function to remove all repeated items from an array - O(nlogn)
    public static String[] removeDuplicates(String [] a) {
        //if the length of the array is 0 or 1 then array does not need to be manipulated
        if (a.length == 0 || a.length == 1) {
            return a;
        }

        //sort the original array using java built in sort
        Arrays.sort(a); //O(nlogn)

        //completely empty temporary array - will be used to add non-duplicate items into
        String [] temp = new String[0];

        //for each element in the sorted array, check if the next value over is the same, if not add the current element to the temp array. Continue for whole array
        for (int i=0; i<a.length-1; i++) { //O(n)
            if (! a[i].equals(a[i+1])) {
                temp = addItem(temp, a[i]);
            }
        }

        //add final element in the array since above loop does not evaluate the final element.
        //The final element will also never be a duplicate based on how the algorithm handles its duplicates
        temp = addItem(temp, a[a.length-1]); //O(n)
        
        return temp;
    }
    public static void main(String [] args) {
        String [] array = new String[]{"World!"};
        array = addItem(array, "Hello");
        array = addItem(array, "World!");
        array = addItem(array, "h3110");
        array = addItem(array, "hello");
        array = addItem(array, "w0r1d");
        array = addItem(array, "WORLD!");
        array = addItem(array, "h3110");
        array = addItem(array, "w0r1d");
        System.out.println("Original Array:");
        System.out.println(Arrays.toString(array));
        array = removeDuplicates(array);
        System.out.println("\nNew Array:");
        System.out.println(Arrays.toString(array));
    }
}