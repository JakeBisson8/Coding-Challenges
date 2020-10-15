//Jake Bisson (jlb4@rogers.com / jbiss085@uottawa.ca)

import java.util.Arrays;
public class Candies {
    /*
    Assumptions
        Each grade is subject to 15 candies, there isn't 15 candies that is divided up
        Each candy is worth 6.7% of a students grade.
        Grades can be Double values
        Grades are not passed as negative values
    */

    public static int[] distributeCandies(double [] grades) {
        int [] candies = new int[grades.length];
        for (int i=0; i<grades.length; i++) {
            double grade = grades[i];
            int numberOfCandies =(int) Math.floor((grade / 6.66));
            candies[i] = numberOfCandies;
        }

        return candies;
    }
    public static void main (String [] args) {
        double [] grades = new double[]{100.0, 23.4, 78.9, 85.6, 63.3};
        System.out.println("Grades: " + Arrays.toString(grades));
        int [] candies = distributeCandies(grades);
        System.out.println("Candies: " + Arrays.toString(candies));
    } 
}