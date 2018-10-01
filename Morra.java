/*

		MorraApp.java
		@Author: Denis, Gerard, Michael. Stefano
		@Date: April 2017

*/


public class Morra{

	//Declare variables/data members
	private int playerGuess, compGuess, total, playerScore, compScore;
	private String choice, result;

	//Constructor
	public Morra(){
		total = 0;
		playerGuess = 0;
		compGuess = (int)(Math.random()*10);
		choice = "";
		result = "";
		playerScore = 0;
		compScore = 0;
	} //end constructor


	//Input
	public void setChoice(String choice){
		this.choice = choice;
	} //end set method
	public void setPlayerGuess(int playerGuess){
		this.playerGuess = playerGuess;
	} //end set method
	public void setCompGuess(int compGuess){
		this.compGuess = compGuess;
	} //end set method


	//Process
	public void compute(){
		total = (playerGuess + compGuess)%2;
		if(total == 1){
			if(choice.equalsIgnoreCase("odds")){
				result = "You Win!";
				playerScore = playerScore + 2;
			} //end if
			else if(choice.equalsIgnoreCase("evens")){
				result = "You lose, computer wins";
				compScore = compScore + 2;
			} //end else if
			else{
				result = "Error";
			} //end else
		} //end if
		else{
			if(choice.equalsIgnoreCase("Evens")){
				result = "You Win!";
				playerScore = playerScore + 2;
			}//end if
			else{
				result = "You lose, computer wins";
				compScore = compScore + 2;
			} //end else
		} //end else if
	} //end compute

	//Output
	public String getResult(){
		return result;
	}
	public int getCompGuess(){
		return compGuess;
	}



} //end class