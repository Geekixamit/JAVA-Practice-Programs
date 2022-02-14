/**
 * Java Program to check if the user-provided password is valid or not 
 * if not, then display what missing in the password using Exception handling
 * 
 * A strong Password:
 * must be 8 to 15 characters long.
 * must contain at least one digit[0-9].
 * must contain at least one lowercase letter[a-z].
 * must contain at least one uppercase letter[A-Z].
 * must contain at least one special character( @, #, %, &, !, $, etc).
 * must not contain any space.
 */

// import utility Class
import java.util.*;

// Driver Class 
public class PasswordValidation
{ 
	// A utility method to validate password 
	public static void isValid(String password) throws InvalidPasswordException 
	{
	    // validating password length
		if (!((password.length() >= 8) && (password.length() <= 15))) 
		{
		    // if not then throw Exception for password length
			throw new InvalidPasswordException(1); 
		} 

		// validating space
		if (password.contains(" "))
		{
		    // if yes then throw Exception for space
			throw new InvalidPasswordException(2); 
		}
		
		// validating digits
		if (true) 
		{
		    // set flag to 0
		    int flag = 0; 
			for (int i = 0; i <= 9; i++) 
			{
			    // convert digit to String
			    String str1 = Integer.toString(i); 
                
                // check if password contains this digit
				if (password.contains(str1)){
				    // set flag to 1
					flag = 1; 
				} 
			}
			
			// check if flag is still 0
			if (flag == 0) { 
			    // if yes then throw Exception for digit
				throw new InvalidPasswordException(3); 
			} 
		} 

		// validating special characters
		if (!(password.contains("@") || password.contains("#") || password.contains("!") 
		   || password.contains("~") || password.contains("$") || password.contains("%") 
		   || password.contains("^") || password.contains("&") || password.contains("*") 
		   || password.contains("(") || password.contains(")") || password.contains("-") 
		   || password.contains("+") || password.contains("/") || password.contains(":") 
		   || password.contains(".") || password.contains(",") || password.contains("<") 
		   || password.contains(">") || password.contains("?") || password.contains("|")))
		{
		    // if not then throw Exception for special Character
		    throw new InvalidPasswordException(4);
		}
		
		// validating uppercase letters
		if(true) 
		{
		    // set flag to 0
		    int flag = 0; 

			for (int i = 65; i <= 90; i++) 
			{
			    // int to char
			    char c = (char)i; 
			    
			    // char to String
			    String str1 = Character.toString(c); 
			    
			    // check String
			    if (password.contains(str1)){
			        
			        // if yes then set flag to 1
					flag = 1;
			    } 
			}
			
			// check if flag is still 0
			if (flag == 0) { 
			    // then throw Exception for uppercase letters
				throw new InvalidPasswordException(5); 
			} 
		}
		
		// validating lowercase letters
		if (true) 
		{
		    // set flag to 0
		    int flag = 0; 

			for (int i = 90; i <= 122; i++) 
			{ 
			    // int to char
				char c = (char)i; 
				
				// char to String
				String str1 = Character.toString(c); 
                
                // checking string
				if (password.contains(str1)) { 
				    // if yes then set flag to 1
					flag = 1; 
				} 
			}
			
			// check if flag is still 0
			if (flag == 0) {
			    // if yes then throw Exception for lowercase letters
				throw new InvalidPasswordException(6); 
			} 
		} 

		// if any of the above conditions does not match then password is validate
	} 

	// main function
	public static void main(String[] args) 
	{
	    // create an object of Scanner class for user input
	    Scanner sc = new Scanner(System.in);
        
        // set choice to y
        String choice = "y";
        
        // ask user continuously until user enters n
        while(!choice.equals("n"))
        {
            // provide password
            System.out.print("Enter a password to validate: ");
		    String password = sc.nextLine(); 
            
            // use try and catch for Exception handling
            // try block will inform user that password is valid
            // catch block will inform user that password is Invalid
            // also, catch block displays what is Invalid in the password
            try
            {
                // function call to check validate
                isValid(password);
                System.out.println("This is a Valid Password!"); 
    		} 
    		catch (InvalidPasswordException e) 
    		{ 
    			System.out.print(e.getMessage()); 
    			System.out.println(e.printMessage()); 
    		}
    		
    		// ask choice
    		System.out.print("\nDo you want to check another[y/n]: ");
    		choice = sc.nextLine();
    		System.out.println();
        }
	} 
} 

// Class for Exception handling during Password validation
class InvalidPasswordException extends Exception { 

	int exceptionNumber = 0; 
    
    // find exceptionNumber
	public InvalidPasswordException(int condition) 
	{ 
		super("Invalid Password: "); 
		exceptionNumber = condition; 
	} 
    
    // display user-defined InvalidPasswordException
	public String printMessage() 
	{ 
		// switch exceptionNumber
		switch (exceptionNumber) 
		{
		    // password must be 8 to 15 characters long.
		    case 1: return ("Password length should be between 8 to 15 characters"); 
		    
		    // Password should not contain any space 
		    case 2: return ("Password should not contain any space"); 
		    
		    // Password must contain at least one digit(0-9) 
		    case 3: return ("Password should contain at least one digit(0-9)"); 
		    
		    // Password must contain at least one special character ( @, #, %, &, !, $ ) 
		    case 4: return ("Password should contain at least one special character"); 
		    
		    // Password must contain at least one uppercase letter(A-Z) 
		    case 5: return ("Password should contain at least one uppercase letter(A-Z)"); 
		    
		    // Password must contain at least one lowercase letter(a-z) 
		    case 6: return ("Password should contain at least one lowercase letter(a-z)"); 
		} 
		return (""); 
	} 
} 
