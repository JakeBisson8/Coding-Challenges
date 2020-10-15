//Jake Bisson (jlb4@rogers.com / jbiss085@uottawa.ca)
public class Atm {
    /*  
    Modification to initial description:
        Rather than outputting the minimum number of bills that will be dispensed, 
        output the bills that are dispensed by the atm. The number of bills that are dispensed
        must be the minimum required bills to be dispensed.

    Assumptions
        Types of cash: 50, 100, 200, 500, 2000
        Minimum value for withdrawal is 50.
        There is no "cents"
        Valid amount: must be a multiple of 50
    */

    //this global array stores the types of bills allowed - Must be from greatest to smallest
    public static int[] bills = new int[]{2000, 500, 200, 100, 50};


    public static void withdraw(int amount) {
        //check if the amount is a valid amount
        if (amount % 50 == 0) {
            //loop through each bill type and perform the action
            for (int i=0; i<bills.length; i++) {
                int bill = bills[i];
                //check if the current bill is able to be dispensed for the current amount
                if (amount >= bill) {
                    //get max number of bills to be dispensed for the current amount and current bill value
                    int numberOfBills = (amount - (amount % bill)) / bill;
                    //set the new amount
                    amount = amount - numberOfBills*bill;
                    //output
                    System.out.println("Dispensing " + numberOfBills + " " + bill + "$ bill(s)"); 
                }
            }
        } else {
            System.out.println(amount + " is not a valid amount");
        }   
    }
    public static void main (String [] args) {
        //boundary case: 50
        int amount = 50;
        System.out.println("Wanted amount: " + amount);
        withdraw(amount);
        System.out.println("");

        //average case: 4550
        amount = 4550;
        System.out.println("Wanted amount: " + amount);
        withdraw(amount);
        System.out.println("");

        //error case: less than 50
        amount = 20;
        System.out.println("Wanted amount: " + amount);
        withdraw(amount);
        System.out.println("");

        //error case: greater than 50, not a multiple of 50
        amount = 155;
        System.out.println("Wanted amount: " + amount);
        withdraw(amount);
        System.out.println("");
    }
}