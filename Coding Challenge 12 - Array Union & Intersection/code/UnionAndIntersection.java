//Jake Bisson (jlb4@rogers.com / jbiss085@uottawa.ca)

import java.util.Arrays;
public class UnionAndIntersection {
    /*
    Assumptions
        Arrays can be of any size
        Arrays contain strings
        Arrays are not sorted
        Arrays don't contain any duplicate values

        Union:
            If one of the arrays is empty, the second array is returned
            union contains duplicate values from both arrays
        Intersection:
            If one of the arrays is empty, an empty array is returned
    */

    //functions to add an element to an array
    public static String[] addElement(String[] a, String value) { //O(n)
        String [] result = new String[a.length+1];
        for (int i=0; i<a.length;i++) {
            result[i] = a[i];
        }
        result[result.length-1] = value;
        a=null; //clean up
        return result;
    }

    public static void unionAndIntersection(String[] a1, String[] a2) { //O(n^3) -> could be reduced to O(nlogn) if a binary searhc was used for intersection
        String [] union = new String[a1.length + a2.length];
        int pointer = 0;
        for (int i=0; i<a1.length; i++) { //O(n)
            union[pointer] = a1[i];
            pointer++;
        }
        for (int j=0; j<a2.length; j++) { //O(n)
            union[pointer] = a2[j];
            pointer++;
        }
        System.out.println("Union: " + Arrays.toString(union));

        //intersection
        String [] intersection = new String[0];
        for (int i=0; i<a1.length; i++){ //O(n)
            for (int j=0; j<a2.length; j++) { //O(n)
                if (a1[i].equals(a2[j])) {
                    intersection = addElement(intersection, a1[i]); //O(n)
                }
            }
        }
        System.out.println("Intersection: " + Arrays.toString(intersection));
    }
    public static void main (String [] args) {
        //case: both empty
        String [] a1 = new String[0];
        String [] a2 = new String[0];
        unionAndIntersection(a1, a2);

        //case: first empty
        a1 = new String[0];
        a2 = new String[]{"Hello, World"};
        unionAndIntersection(a1, a2);

        //case: second empty
        a1 = new String[]{"Hello", "World", "From", "Code"};
        a2 = new String[0];
        unionAndIntersection(a1, a2);

        //case: general case
        a1 = new String[]{"Hello", "World"};
        a2 = new String[]{"Hello", "World"};
        unionAndIntersection(a1, a2);

        //case: general case
        a1 = new String[]{"Hello", "World", "Lol"};
        a2 = new String[]{"Hello", "World", "HeHe"};
        unionAndIntersection(a1, a2);
    }
}