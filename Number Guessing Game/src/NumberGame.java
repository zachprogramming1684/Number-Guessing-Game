import java.util.InputMismatchException;
import java.util.Scanner;

public class NumberGame {

	public static void main(String[] args) throws InterruptedException 
	{
		int gameMode = 0;
		int chances = 0;
		Scanner in = new Scanner(System.in);
		
		displayWelcome();
		while(gameMode >= 4 || gameMode <= 0)
		{
			try 
			{
				System.out.println("Please select your game mode (1 for easy, 2 for medium, 3 for hard)");
				Thread.sleep(1000);
				System.out.println("----------");
				System.out.print("Easy: 8 chances\nMedium: 5 chances\nHard: 3 chances\n");
				System.out.println("----------");
				String inputLine = in.nextLine();
				gameMode = Integer.parseInt(inputLine);
				
				switch(gameMode)
				{
				case(1):
					System.out.println("Easy");
					break;
				case(2):
					System.out.println("Medium");
					break;
				case(3):
					System.out.println("Hard");
					break;
				}
			}
			catch (NumberFormatException e)
			{
				System.out.println("Invalid input, please enter a valid integer number.");
				Thread.sleep(1000);
			}
			catch (Exception e)
			{
				System.out.println("An unexpected error occured.");
				Thread.sleep(1000);
			}
		}

	}
	
	public static void displayWelcome() throws InterruptedException
	{
		System.out.println("Welcome to the Number Guessing Game!");
		Thread.sleep(1000);
		System.out.println("I'm thinking of a number between 1 and 100");
		Thread.sleep(1000);
	}


}
