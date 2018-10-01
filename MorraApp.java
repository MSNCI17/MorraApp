/*

		MorraApp.java
		@Author: Denis, Gerard, Michael. Stefano
		@Date: April 2017

*/

import javax.swing.*;
import java.awt.*;

public class MorraApp {
	public static void main(String args[]) {

		//Declare variables
		int playerGuess, compGuess, total, sum = 0;
		String choice, result;
		String rule = "<html><span style='font-size:1.5em'><font color = 'blue'>GAME RULES:</html>\n\n<html><span style='font-size:1.2em'>Let's play the game of Morra against the computer</html>\n<html><span style='font-size:1.2em'>Each game you can pick to be odds or evens</html>\n<html><span style='font-size:1.2em'>Each round of the game you pick a number between 1 and 10</html>\n<html><span style='font-size:1.2em'>You get 2 points if you guess if the computer number plus your number  is even or odd</html>\n<html><span style='font-size:1.2em'>You get another 1 point if your guess is closest to the total</html>\n<html><span style='font-size:1.2em'>First one to 6 points wins the game</html>\n\n<html><span style='font-size:1.2em'>GOOD LUCK!</html>";
		int playerScore = 0, compScore = 0;
		final ImageIcon icon = new ImageIcon("morra_1.jpg"); // setting up image variable for rules


		//Setting for JOptionPane to change color of background
		UIManager.put("OptionPane.background", Color.white);
		UIManager.put("Panel.background", Color.white);

		//Showing game rules to the user & image related to game
		rule = rule.toUpperCase(); // making text to uppercase
		JOptionPane.showMessageDialog(null, rule, "Game rules", JOptionPane.INFORMATION_MESSAGE, icon);

		//Input
		choice = JOptionPane.showInputDialog(null, "Do you want to be Evens or Odds for this game! (evens/odds)");

		do {

			//Declare objects
			Morra myMorra;
			Morra myCompGuess;

			//Create objects
			myMorra = new Morra();

			//Input
			myMorra.setChoice(choice);
			playerGuess = Integer.parseInt(JOptionPane.showInputDialog(null, "How many fingers do you want to hold up (number between 1 and 10"));
			myMorra.setPlayerGuess(playerGuess);

			//Process
			myMorra.compute();

			//Output
			result = myMorra.getResult();
			compGuess = myMorra.getCompGuess();
			sum = playerGuess + compGuess;

			if(result.equals("You Win!")){
				playerScore = playerScore + 2;
			} //end if

			else{
				compScore = compScore + 2;
			} //end else

			if((sum - playerGuess) > (sum - compGuess)){
				compScore = compScore + 1;
			} //end if

			else{
				playerScore = playerScore + 1;
			} //end else

			String msg = "\n" + result + "\n\nComputer guess was " + compGuess + " and your guess was " + playerGuess + "\n\nComputer Score: " + compScore + " Your score: " + playerScore;

			JOptionPane.showMessageDialog(null, msg);

			if(compScore >= 6){
				final ImageIcon game_over = new ImageIcon("game_over.jpg");
				JOptionPane.showMessageDialog(null, "<html><span style='font-size:1.5em'>YOU LOSE THE ROUND</html>", "Game Over", JOptionPane.INFORMATION_MESSAGE, game_over);
			} //end if

			else if(playerScore >= 6){
				final ImageIcon victory = new ImageIcon("victory.jpg");
				JOptionPane.showMessageDialog(null, "<html><span style='font-size:1.5em'>YOU WIN THE ROUND</html>", "Victory is mine", JOptionPane.INFORMATION_MESSAGE, victory);
			} //end else if

			else{

			} //end else

		} while((compScore < 6) & (playerScore < 6));

		int userChoice = JOptionPane.showConfirmDialog(null, "Do you want to play Morra game again?",null, JOptionPane.YES_NO_OPTION);

		if (userChoice == JOptionPane.YES_OPTION) {
			main(new String[0]);
		} //end if

		else {

			JOptionPane.showMessageDialog(null, "Thank you for playing Morra game");
			System.exit(0);
		} //end else

	} //end main method
} //end class