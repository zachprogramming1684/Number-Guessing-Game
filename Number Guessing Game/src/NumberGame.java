import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class NumberGame {

	public static void main(String[] args) throws InterruptedException 
	{
		int gameMode = 0;
		int chances = 0;
		Random rnum = new Random();
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
					System.out.println("You have selected Easy difficulty! Good luck!");
					Thread.sleep(1000);
					chances = 8;
					playGame(in, chances, rnum);
					break;
					
				case(2):
					System.out.println("You have selected Medium difficulty! Good luck!");
					Thread.sleep(1000);
					chances = 5;
					playGame(in, chances, rnum);
					break;
					
				case(3):
					System.out.println("You have selected Hard difficulty! Good luck!");
					Thread.sleep(1000);
					chances = 3;
					playGame(in, chances, rnum);
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
	public static void playGame(Scanner in, int chances, Random rnum) throws InterruptedException
	{
		int randomNum = rnum.nextInt(100);
		int userNum = -1;
		while(chances > 0)
		{
			System.out.println("Enter your guess: ");
			Thread.sleep(1000);
			try
			{
				String input = in.nextLine();
				userNum = Integer.parseInt(input);
				chances--;
				if(userNum == randomNum)
				{
					System.out.println("Congrats! You guessed correctly.");
					break;
				}
				else
				{
					String greaterOrLess = "";
					int diff = userNum - randomNum;
					if(diff < 0)
					{
						greaterOrLess = "greater";
					}
					else
					{
						greaterOrLess = "less";
					}
					System.out.println("Incorrect! The number is " + greaterOrLess + " than " + userNum + ".");
					Thread.sleep(1000);
				}
			}
			catch (NumberFormatException e)
			{
				System.out.println("Invalid input, please enter a valid integer number.");
				Thread.sleep(1000);
			}
		}
		if(chances <= 0 && userNum != randomNum)
		{
			System.out.println("You ran out of guesses!");
		}
	}


}
