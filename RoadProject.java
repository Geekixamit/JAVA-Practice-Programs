/*
Rosie's Road Co. is a new local construction company. 
They are interested in bidding on new highway construction projects around the city. 
They've hired you to develop some software tools that they will use to help determine material needs and costs.

Road development is not only the asphalt you see - water and power conduits must be installed at the same time, 
and we have to account for things like labor costs and how long it will take to develop a particular project.

The city is very regular grid, with one 4-way intersection at each mile of road. 
When asking for a quote, the city sends out the number of linear miles of road, and how many total lanes (1 to 8).

Other Details:
The trucks hauling asphalt have a maximum capacity of 5 US tons (10,000 lbs)
The standard road lane is 12 feet wide.
Asphalt weighs 145 lbs per cubic foot
Asphalt costs $150 per ton
Power and water utilities are run under the road as part of all road projects
Power conduit is available only in 20 ft. lengths - each length costs $500
Water main pipe is available only in 10 ft. lengths - each length costs $200
There is one intersection for every mile of road
Stoplights cost $25,000 per light (look it up, that's real!)
Each intersection has two stoplights, plus one additional stoplight for each lane
Workdays are 8-hour days
All workers are paid $25 per hour.
Crew members can complete an amount of work in a specified time according to the equation and table below: 
crew_members = (50 * miles_of_road * number_of_lanes) / days_to_complete

Your program should take as input from the user, the following.

Length of road project (miles)
Number of lanes
Depth of asphalt (inches)
Days to complete project
Your program should display a nicely formatted report with the following information - each on a separate line.

Amount of materials needed
Truckloads of Asphalt
Stoplights
Water pipes
Power pipes
Number of crew members needed

Total cost of:
Asphalt (Truckloads)
Stoplights
Water pipes
Power pipes
Labor
Total cost of project
Make sure that your program collects the four required inputs in this order:

Length of road project (miles)
Number of lanes
Depth of asphalt (inches)
Days to complete project
Also make sure that your program outputs the Amount of Materials Needed, the Cost of Materials, and the Total Cost of Project formatted exactly
*/

import java.util.*;

public class RoadProject
{
	public static void main(String[] args) {
	    
	    // create a Scanner class Object for user input
	    Scanner input = new Scanner(System.in);
	    
	    // provide user input as per the defined format
	    System.out.print(String.format("%-30s %s","Length of road project (miles)",": "));
	    double lengthOfRoad = input.nextDouble();
	    
	    System.out.print(String.format("%-30s %s","Number of lanes",": "));
	    int noOfLanes = input.nextInt();
	    
	    System.out.print(String.format("%-30s %s","Depth of asphalt (inches)",": "));
	    int depthOfAsphalt = input.nextInt();
	    
	    System.out.print(String.format("%-30s %s","Days to complete project",": "));
	    int daysToCompleteProject = input.nextInt();
	    
	    // declare all required variables as 0
	    long truckLoadsOfAsphalt = 0;
	    long stoplights = 0;
	    long conduitPipes = 0;
	    long crewMembers = 0;
	    
	    double costOfAsphalt = 0;
	    double costOfStoplights = 0;
	    double costOfConduitPipes = 0;
	    double costOfCrewmembers = 0;
	    double totalCost = 0;
	    
	    // Calculate the amount of the truck Loads Of Asphalt
	    truckLoadsOfAsphalt = (long)Math.ceil((lengthOfRoad * 5280 * 150 * noOfLanes * depthOfAsphalt)/10000);
	    
	    // Calculate the amount of stop lights
	    int intersections = (int)Math.floor(lengthOfRoad);
	    
	    if(noOfLanes == 1){
	        stoplights = 3 * intersections;
	    }else if(noOfLanes == 2){
	        stoplights = 4 * intersections;
	    }else{
	        stoplights = 5 * intersections;
	    }
	    
	    // Calculate the amount of conduit Pipes
	    conduitPipes = (long)(lengthOfRoad * 5280)/24;
	    
	    // Calculate the amount of crew members
	    crewMembers = (long)Math.ceil((50 * lengthOfRoad * noOfLanes )/daysToCompleteProject);
	    
	    // Calculate the cost of the truck Loads Of Asphalt
	    costOfAsphalt = truckLoadsOfAsphalt * 200 * 5;
	    
	    // Calculate the cost of the stop lights
	    costOfStoplights = stoplights * 25000;
	    
	    // Calculate the cost of the conduit Pipes
	    costOfConduitPipes = conduitPipes * 500;
	    
	    // Calculate the cost of the crew members
	    costOfCrewmembers = crewMembers * daysToCompleteProject * 8 * 25;
	    
	    // Calculate the total Cost
	    totalCost = costOfAsphalt + costOfStoplights + costOfConduitPipes + costOfCrewmembers;
	    
	    // display the all Calculated values as per the defined format
	    System.out.println("\n=== Amount of Materials needed ===");
	    System.out.print(String.format("%-21s %s","Truckloads of Asphalt",": ") + truckLoadsOfAsphalt);
	    System.out.print(String.format("%-22s %s","\nStoplights",": ") + stoplights);
	    System.out.print(String.format("%-22s %s","\nConduit pipes",": ") + conduitPipes);
	    System.out.print(String.format("%-22s %s","\nCrew members needed",": ") + crewMembers);
	    
	    System.out.println("\n=== Cost of Materials ============");
	    System.out.print(String.format("%-21s %s","Cost of Asphalt",": $"));
	    System.out.printf("%.2f",costOfAsphalt);
	    System.out.print(String.format("%-22s %s","\nCost of Stoplights",": $"));
	    System.out.printf("%.2f",costOfStoplights);
	    System.out.print(String.format("%-21s %s","\nCost of Conduit pipes",": $"));
	    System.out.printf("%.2f",costOfConduitPipes);
	    System.out.print(String.format("%-22s %s","\nCost of Labour",": $"));
	    System.out.printf("%.2f",costOfCrewmembers);
	    
	    System.out.println("\n=== Total Cost of Project ========");
	    System.out.print(String.format("%-21s %s","Total cost of project",": $"));
	    System.out.printf("%.2f",totalCost);
	}
}

