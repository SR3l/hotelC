import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class HotelCalifornia  {
    public static void main(String[] args) {

        double standardRoom, suite, singleLunch, singleDinner, numNights, suiteNights;

        //prices
        double roomPrice = 125;
        double suitePrice = 400;
        double lunchPrice = 11.95;
        double dinnerPrice = 19.95;
        double taxes = 0.08;

        Scanner scan = new Scanner(System.in);
        NumberFormat cf = NumberFormat.getCurrencyInstance(Locale.US);

        // User prompt
        standardRoom = getInput("number of standard rooms taken" , scan);
        numNights = getInput("number of nights stayed in standard rooms", scan);
        suite = getInput("number of suites taken", scan);
        suiteNights = getInput("number of nights stayed in suites", scan);
        singleLunch = getInput("total number of lunches ordered", scan);
        singleDinner = getInput("total number of dinners ordered", scan);

        //Calculation
        double totalStandardRoom = getRoomCost(standardRoom, numNights, roomPrice);
        double totalSuiteCost = getSuiteCost(suite,suiteNights, suitePrice);
        double totalLunchCost = getLunchCost(singleLunch, lunchPrice);
        double totalDinnerCost = getDinnerCost(singleDinner, dinnerPrice);
        double grandTotalBeforeTax = totalStandardRoom + totalSuiteCost + totalLunchCost + totalDinnerCost;
        double totalTaxes = getTaxes(grandTotalBeforeTax, taxes);
        double tips = getTips(totalLunchCost,totalDinnerCost);
        double grandTotal = grandTotalBeforeTax + totalTaxes + tips;


        System.out.println("Total cost of standard rooms = " + cf.format(totalStandardRoom));
        System.out.println("Total cost of suites         = " + cf.format(totalSuiteCost));
        System.out.println("Total cost of lunches        = " + cf.format(totalLunchCost));
        System.out.println("Total cost of dinners        = " + cf.format(totalDinnerCost));
        System.out.println("Grand Total before taxes     = " + cf.format(grandTotalBeforeTax));
        System.out.println("Taxes                        = " + cf.format(totalTaxes));
        System.out.println("Tips                         = " + cf.format(tips));
        System.out.println("Grand Total bill             = " + cf.format(grandTotal));

    }
    //methods
    public static double getRoomCost(double standardRoom, double numNights, double roomPrice){
        return standardRoom *  numNights * roomPrice;
    }
    public static double getSuiteCost(double suite, double suiteNights, double suitePrice){
        return suite * suiteNights * suitePrice;
    }
    public static double getLunchCost(double lunchPrice, double singleLunch){
        return singleLunch * lunchPrice;
    }
    public static double getDinnerCost(double dinnerPrice, double singleDinner){
        return singleDinner * dinnerPrice;
    }
    public static double getTaxes(double grandTotalBeforeTax , double taxes) {
        return grandTotalBeforeTax * taxes;
    }
    public static double getTips(double totalLunchCost , double totalDinnerCost) {
        double food = totalLunchCost + totalDinnerCost;
        return food * 0.15;
    }
    public static double getInput(String message, Scanner scan) {
        System.out.print("Enter the " + message + ": ");
        return scan.nextDouble();
    }
}