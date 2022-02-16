// JAVA program to read, write, search, and delete students record from a CSV file
import java.util.*;
import java.io.*;

// Driver class
public class FileProcess
{
    // Create a static Scanner class object for user input
    static Scanner scanner = new Scanner(System.in);
	
	// main method
	public static void main(String[] args)
	{
        // read file name
        System.out.print("Enter the file name: ");
        String fileName = scanner.nextLine();
        
        String userInput = "";
        
        // run a do-while loop until user enters 5 to terminate the Program
        do
        {
            // make a function call to Display the menu
            mainMenu();
            
            // enter user choice
            System.out.print("Enter menu selection: ");
            userInput = scanner.nextLine();
            System.out.println();
            
            // check conditions based on the provided input, 
            // and then make appropriate function calls 
            if(userInput.equals("1")) 
            {
                // function call to add a new student in the record
                addNewRecord(fileName);          
            }
            else if(userInput.equals("2"))
            {
                // function call to read the record
                readStudentRecord(fileName);
            }
            else if(userInput.equals("3"))
            {
                // function call to search a student in the record
                searchStudentInRecord(fileName);
            }
            else if(userInput.equals("4"))
            {
                // function call to delete a student from the record
                deleteStudentFromRecord(fileName);
            }
            else if(userInput.equals("5"))
            {
                // inform user to terminate the program
                System.out.println("Program Terminated...");
            }
            else
            {
                // inform user that it is an invalid user input
                System.out.println("Invalid input, please enter a choice 1-5");
            }
        }while(!userInput.equals("5"));
	}
    
    // this function displays a menu
    public static void mainMenu(){
        System.out.println("\nSelect from the menu...");
        System.out.println("1.Add a new student in the record");
        System.out.println("2.Display student's record");
        System.out.println("3.Search a student in the record");
        System.out.println("4.Delete a student from the record");
        System.out.println("5.Exit program\n");
    }
    
    // this function creates an csv file using FileWriter or
    // open a csv file if already exists
    // and then add data to the file
    public static void addNewRecord(String fileName){
        try 
        {
            FileWriter writer = new FileWriter(new File(fileName),true);
            
            // provide student's name, year, and GPA
            System.out.print("Enter student's name: ");
            String name = scanner.nextLine();
            
            System.out.print("Enter student's year: ");
            String year = scanner.nextLine();
            
            System.out.print("Enter student's GPA: ");
            double gpa = scanner.nextDouble();
            scanner.nextLine();
            
            // write data to the file
            writer.write(name+","+year+","+Double. toString(gpa)+"\n");
            
            // inform user
            System.out.println("Student Successfully added to the record!");
            writer.close();
            
        } catch(Exception e) {
            System.out.println("An error occurred.");
        }
    }
    
    // this method displays the complete Students record to the user using BufferedReader
    public static void readStudentRecord(String fileName){
        try 
        {
            // open file
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
 
			// declare a variable to read lines
			String line;
            
            // read lines
            System.out.println("--Student Record--");
			while((line = reader.readLine())!=null)
			{
			    // Display line
			    System.out.println(line);
			}
			reader.close();
            
        } catch(Exception e) {
            System.out.println("An error occurred.");
        }
    }
    
    // this method checks if a student exit in the record or not
    public static void searchStudentInRecord(String fileName){
        try 
        {
            // open file
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            
            // provide student's name and year that need to be searched
            System.out.print("Enter student's name: ");
            String name = scanner.nextLine();
            
            System.out.print("Enter student's year: ");
            String year = scanner.nextLine();
            
			// declare a variable to read lines
			String line;
			int flag=0;
            
			while((line = reader.readLine())!=null)
			{
			    // split line data by comma
			    String[] data = line.split(",");
			    
			    // match name and year
			    if(data[0].equals(name) && data[1].equals(year)){
			        
			        // if matched then inform user and set flag to 1 and close the loop
			        System.out.println("Student exists in the record!");
			        flag = 1;
			        break;
			    }
			}
			reader.close();
			
			// if still flag is 0 then Student not exist 
            if(flag == 0){
                System.out.println("Student does not exist in the record!");
            }
            
        } catch(Exception e) {
            System.out.println("An error occurred.");
        }
    }
    
    // this method deletes the student from the Students record
    public static void deleteStudentFromRecord(String fileName)
	{
		try
		{
		    // open file
			BufferedReader br=new BufferedReader(new FileReader(fileName));
            
            // provide student's name and year that need to be deleted
            System.out.print("Enter student's name: ");
            String name = scanner.nextLine();
            
            System.out.print("Enter student's year: ");
            String year = scanner.nextLine();
            
			// String buffer to hold the data of the file
			StringBuffer sb = new StringBuffer("");
 
			String line;
			int flag=0;
            
            // read lines
			while((line=br.readLine())!=null)
			{
			    // split line
			    String[] data = line.split(",");
			    
			    // skip the matched line and 
			    // store the remaining lines in the string buffer
				if(data[0].equals(name) && data[1].equals(year)){
				    flag=1;   // set flag to 1
					continue;
				}else{
				    sb.append(line+"\n");
				}
			}
			br.close();
            
            // open file and overwrite the data
			FileWriter writer = new FileWriter(new File(fileName));
			
			// Write entire string buffer into the file
			writer.write(sb.toString());
			writer.close();
			
			// if flag is 0 then Student not exist otherwise it is already deleted so inform the user
			if(flag == 0){
			    System.out.println("Student does not exist in the record!");
			}else{
			    System.out.println("Student Successfully deleted from the record!");
			}
		}
		catch (Exception e)
		{
			System.out.println("An error occurred.");
		}
	}
}



