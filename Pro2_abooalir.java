import java.util.Scanner;

public class Pro2_abooalir {
	
	public static Scanner userInput = new Scanner(System.in); //Initializing global scanner
	//Initializing global variables
	public static double input;
	public static String input_str;
	public static int coords[][] = new int[21][2];
	public static int numOfHouses = 1;
	public static int radius;

	public static void main(String[] args) {
			
		displayMenu();
		input_str = userInput.nextLine();
		input = getInteger(input_str,0,5);
		while(input == -1 || input_str.isEmpty()) //check if the radius is a valid input
    	{
			System.out.println();
    	    System.out.println("ERROR: Invalid menu choice!");
			System.out.println();
			displayMenu();
			input_str = userInput.nextLine();
			input = getInteger(input_str,0,5);
    	}
		
		while(input != 0) //keep showing the menu while the input is not zero
		{
			if(input ==1)
			{
				numOfHouses = getHouseCoords(coords,numOfHouses);
				
			}
			else if(input == 2) 
			{
				
				displayHouses(coords,numOfHouses);
				System.out.println();
				
			}
			else if(input == 3) 
			{
				System.out.println();
				System.out.print("Enter fire station radius: ");
				String x = userInput.nextLine();
					    	
			    radius = getInteger(x , 0, 40);
					    	
					    	while(radius == -1 || x.isEmpty()) //check if the radius is a valid input
					    	{
					    	    System.out.println("ERROR: Input must be an integer in [0, 30]!");
								System.out.println();
					    		System.out.print("Enter fire station radius: ");
						    	x = userInput.nextLine();
						    	radius = getInteger(x , 0, 20);
						    	
					    	}
		    	System.out.println();
		    	
			}
			else if(input == 4)
			{
				assessFireStationLocations(radius,coords,numOfHouses);
				System.out.println();
				
			}
			else if(input == 5) 
			{
				clear(1);
			}
			
			else if(input != 0) //display error when the input is not a valid option in the menu
			{
				System.out.println();
				System.out.println("ERROR: Invalid menu choice!\n");
				
			}
			
			displayMenu();
			input_str = userInput.nextLine();
			input = getInteger(input_str,0,5);
			while(input == -1 || input_str.isEmpty()) //check if the radius is a valid input
	    	{
				System.out.println();
	    	    System.out.println("ERROR: Invalid menu choice!");
				System.out.println();
				displayMenu();
				input_str = userInput.nextLine();
				input = getInteger(input_str,0,5);
	    	}
			
		}
		System.out.println();
		System.out.println("Au revoir!");

	}
	public static void clear(int num) 
	{
		if(num == 1) 
		{
			numOfHouses = 1;
			System.out.println();
			System.out.println("House location database cleared!");
			System.out.println();
			//clearing the database by setting the number of houses to its initial value
		}

	}
	public static void displayMenu() 
	{
		System.out.println("   JAVA FIRE STATION LOCATION PROGRAM");
		System.out.println("0 - Quit");
		System.out.println("1 - Enter location of houses");
		System.out.println("2 - Display house locations");
		System.out.println("3 - Set fire station radius");
		System.out.println("4 - Assess fire station locations");
		System.out.println("5 - Clear house locations");
		System.out.println();
		System.out.print("Enter choice: ");
		
	}
	
	public static int getHouseCoords(int [][] houseCoords, int nHouses) 
	{
		int counter = nHouses; //counting the number of houses entered 
		
		System.out.println();
		System.out.println("Enter coordinates (0, 0)  to quit at any time.");
		System.out.println();
		
		
		for (int i = nHouses-1; i < coords.length; i++)
		{
			for (int j = 0; j < coords[i].length; j++)
			{
			    if(j == 0)
			    {
			    	System.out.print("x-coordinate of house "+ counter+": ");
					String x = userInput.nextLine();
						    	
				    coords[i][0] = getInteger(x , 0, 20);
						    	
						    	while(coords[i][0] == -1 || x.isEmpty()) //check if the user input is valid for x
						    	{
						    	    System.out.println("ERROR: Input must be an integer in [0, 20]!");
									System.out.println();
						    		System.out.print("x-coordinate of house "+ counter+": ");
							    	x = userInput.nextLine();
							    	coords[i][0] = getInteger(x , 0, 20);
						    	}

			    }
			    else
			    {
			    	System.out.print("y-coordinate of house "+ counter+": ");
					String x = userInput.nextLine();
						    	
				    coords[i][1] = getInteger(x , 0, 20);
						    	
						    	while(coords[i][1] == -1 || x.isEmpty()) //check if the user input is valid for y
						    	{
						    	    System.out.println("ERROR: Input must be an integer in [0, 20]!");
									System.out.println();
						    		System.out.print("y-coordinate of house "+ counter+": ");
							    	x = userInput.nextLine();
							    	coords[i][1] = getInteger(x , 0, 20);
						    	}
			    }
			}
			System.out.println();
			if(coords[i][0]==0 && coords[i][1]==0) //break out of the loop if the user input is 0,0
			{
			    break;
			}
			counter++; //keeping track of the number houses inputed
		}
		return counter;
	}
	
	public static void displayHouses(int [][] houseCoords, int nHouses) 
	{
		if(nHouses==1) //if the number of houses is equal to its initial value, print nothing
		{
		   System.out.println("No houses entered!");
		}
		else 
		{
			System.out.println();
			System.out.println("House   X   Y");
			System.out.println("-------------");
			for (int i = 0; i < nHouses-1; i++)
			{   
				System.out.printf("%2d%7d%4d\n", i+1,houseCoords[i][0],houseCoords[i][1]);
				
			}
			
		}
		
	}
	
	public static void assessFireStationLocations(int r, int [][] houseCoords, int nHouses) 
	{
		double n[] = new double[10000000]; //euclidean distance
		double score[] = new double[10000000]; //score of individual house
		double x_coord[] = new double[10000000]; 
		double y_coord[] = new double[10000000];
		double total = 0; // total sum
		double totalList[] = new double[10000000]; //list of different scores based on different fire station location
		int counter = 0;
	
		System.out.println();
		System.out.println("Enter coordinates (0, 0)  to quit at any time.");
		System.out.println();
		
		System.out.print("x-coordinate of fire station: ");
		String x_str = userInput.nextLine();
		int x = getInteger(x_str,0,20);
		while(x == -1 || x_str.isEmpty()) //check if the input is valid for x
    	{
    	    System.out.println("ERROR: Input must be an integer in [0, 20]!");
			System.out.println();
    		System.out.print("x-coordinate of fire station: ");
	    	x_str = userInput.nextLine();
	    	x = getInteger(x_str , 0, 20);
    	}
		
		System.out.print("y-coordinate of fire station: ");
		String y_str = userInput.nextLine();
		int y = getInteger(y_str,0,20);
		while(y == -1 || y_str.isEmpty()) //check if the input is valid for y
    	{
    	    System.out.println("ERROR: Input must be an integer in [0, 20]!");
			System.out.println();
    		System.out.print("y-coordinate of fire station: ");
	    	y_str = userInput.nextLine();
	    	y = getInteger(y_str , 0, 20);
    	}
		while(x!=0 || y!=0) 
		{
			for (int i = 0; i < nHouses-1; i++) 
			{
				score[i]=0;
				double x_total = (x-houseCoords[i][0])*(x-houseCoords[i][0]);
				double y_total = (y-houseCoords[i][1])*(y-houseCoords[i][1]);
				n[i] = Math.sqrt((x_total)+(y_total));
				
				if(n[i] > r) 
				{
					score[i] += n[i];
				}
				else 
				{
					score[i] += 0;
				}
				
				total += score[i];
				
			}
			
			//the purpose of making the below arrays is to keep track of the index related to the relevant fire station entered
			// adding each score related to a fire location into a list
			for(int i = 0; i < nHouses-1; i++)
			{
				  totalList[counter] = total;
			}
			
			// adding each x,y coordinate related to a fire location into a list
			for(int i = 0; i < nHouses-1; i++)
			{
				  x_coord[counter] = x;
				  y_coord[counter] = y;
			}
			
			for (int i = 0; i < 1; i++) 
			{
			      System.out.format("Score of fire station at ("+x +", "+y +"): %.2f", totalList[counter]);
				  System.out.println();
				
			}
			
			counter++; //keeping track of the number of locations entered
			
			System.out.println();
			System.out.print("x-coordinate of fire station: ");
			x_str = userInput.nextLine();
			x = getInteger(x_str,0,20);
			while(x == -1 || x_str.isEmpty()) 
	    	{
	    	    System.out.println("ERROR: Input must be an integer in [0, 20]!");
				System.out.println();
	    		System.out.print("x-coordinate of fire station: ");
		    	x_str = userInput.nextLine();
		    	x = getInteger(x_str , 0, 20);
	    	}
			
			System.out.print("y-coordinate of fire station: ");
			y_str = userInput.nextLine();
			y = getInteger(y_str,0,20);
			while(y == -1 || y_str.isEmpty()) 
	    	{
	    	    System.out.println("ERROR: Input must be an integer in [0, 20]!");
				System.out.println();
	    		System.out.print("y-coordinate of fire station: ");
		    	y_str = userInput.nextLine();
		    	y = getInteger(y_str , 0, 20);
	    	}
			total = 0; //making the total sum to zero before stating a new loop to avoid adding the score of the previous location
		}
		
		// finding the index of the smallest score 
		double min = totalList[0];
	    int index = 0;
		for (int i = 0; i < counter-1; i++) 
		{
		      if (min > totalList[i]) 
		      {
		        min = totalList[i];
		        index = i;
		      }	
		}
		
		System.out.println();
		System.out.println(counter+" locations tried.");
		System.out.format("Best location: ("+(int)x_coord[index] +", "+(int)y_coord[index] +") with score %.2f.", totalList[index]);
		System.out.println();
		
	}
	
	public static int getInteger(String prompt, int LB, int UB) 
	{
		int newInt = 0; //the integer that will be returned 
		
	    try
	    {
	       Integer.parseInt(prompt); //converting the prompt to int
	       
	    }
	    catch (NumberFormatException e)
	    {
	        return -1; //return false if the input is a string
	    }
	
	    catch (Exception e)
	    {
	        return -1; //return false if the input is a double
	        
	    }
	   
	   newInt = Integer.parseInt(prompt); // if the prompt is an int number, convert it to int 
	   
	   if(Integer.parseInt(prompt) < LB || Integer.parseInt(prompt) > UB)
	   {
			return -1; // return false if the number is not in the boundary
				
	   }
	   else
	   {
			return newInt; //Return the valid number
	   }
	}

}
