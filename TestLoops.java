import java.util.*;

// Vehicle class
class Vehicle
{
    // instance variables
    private double basePrice;
    private double featuresPrice;
    
    // constructor
    public Vehicle(double bprice, double fprice){
        this.basePrice = bprice;
        this.featuresPrice = fprice;
    }
    
    // method that returns total cost
    public double getTotalPrice(){
        return basePrice + featuresPrice;
    }
}

// Driver class
public class TestLoops
{
	public static void main(String[] args) 
	{
	    Scanner sc = new Scanner(System.in);
		
		// Prompt the user for the base price of the car.
		System.out.print("Enter base price of the car: ");
		double basePrice = Double.parseDouble(sc.nextLine());
		
		// Perform error checking to ensure that the price is between $30,000 and $70,000.
		while(true){
		    
		    if(basePrice < 30000 || basePrice > 70000){
		        System.out.println("Invalid input! Base price should be in between $30000 and $70000.");
		        System.out.print("Enter base price of the car: ");
		        basePrice = Double.parseDouble(sc.nextLine());
		    } else {
		        break;
		    }
		}
		
		// Prompt the user for the cost of the additional features for your car.
		System.out.print("Enter the cost of the additional features for car: ");
		double featuresPrice = Double.parseDouble(sc.nextLine());
		
		// Using a different looping structure, perform error checking to ensure the inputted value is between $10,000 and $25,000.
		while(true){
		    
		    if(featuresPrice < 10000 || featuresPrice > 25000){
		        System.out.println("Invalid input! Features price should be in between $10000 and $25000.");
		        System.out.print("Enter the cost of the additional features for car: ");
		        featuresPrice = Double.parseDouble(sc.nextLine());
		    } else {
		        break;
		    }
		}
		
		// Instantiate an object of the Vehicle class named myCar using the 2 verified inputs.
		Vehicle myCar = new Vehicle(basePrice, featuresPrice);
		
		// Calculate the total price for the car.
		double myCarTotalPrice = myCar.getTotalPrice();
		// print total price
		System.out.println("\nTotal price of your car = $" + myCarTotalPrice);
		
		// now, create an amortization schedule using the following guidelines:
		double initialAmountBorrowed = myCarTotalPrice;
		double monthlyPayment = 532.0;
		double interestRate = 8.4;
		int years = 6;
		double startBalance = initialAmountBorrowed;
		
		// print table headers
		System.out.println("\nLoan Amortization Schedule");
		System.out.println("---------------------------");
		System.out.printf("%-10s%-20s%-20s%-20s%-20s%-20s\n", "Month", "Starting Balance", "Repayment", "Interest paid", "Principal paid", "New Balance");
		System.out.printf("%-10s%-20s%-20s%-20s%-20s%-20s\n", "-----", "----------------", "---------", "-------------", "--------------", "-----------");
		
		// loop for years * 12 months
		for(int month=1; month <= years * 12; month++)
		{
		    // for each month, Calculate interest amount, Principal paid, remaning Balance
		    double interest = (interestRate / (12*100)) * startBalance;
		    double appliedPrincipal = monthlyPayment - interest;
		    double newBalance = startBalance - appliedPrincipal;
		    
		    // print all attributes in table format
		    System.out.printf("%-10d%-20.2f%-20.2f%-20.2f%-20.2f%-20.2f\n", month, startBalance, monthlyPayment, interest, appliedPrincipal, newBalance);
		    
		    // update starting Balance
		    startBalance = newBalance;
		    
		    // check for last schedule
		    if(startBalance < monthlyPayment){
		        interest = (interestRate / (12*100)) * startBalance;
		        monthlyPayment = interestRate + startBalance;
		        appliedPrincipal = monthlyPayment - interest;
		        newBalance = 0;
		        System.out.printf("%-10d%-20.2f%-20.2f%-20.2f%-20.2f%-20.2f\n", ++month, startBalance, monthlyPayment, interest, appliedPrincipal, newBalance);
		        break;
		    }
		}
	}
}
