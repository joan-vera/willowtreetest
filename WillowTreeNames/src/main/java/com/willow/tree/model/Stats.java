package com.willow.tree.model;

public class Stats {

	private int guesses = 0;
	private int correct = 0 ;
	private int wrong = 0;
	
	public int getGuesses() {
		return guesses;
	}
	public void setGuesses(int guesses) {
		this.guesses = guesses;
	}
	public int getCorrect() {
		return correct;
	}
	public void setCorrect(int correct) {
		this.correct = correct;
	}
	public int getWrong() {
		return wrong;
	}
	public void setWrong(int wrong) {
		this.wrong = wrong;
	}
	
	public double getAverageCorrect() {
		if(guesses > 0)
			return (double)correct/(double)guesses; 
		else 
			return 0;
	}
		
	public double getAverageWrong() {
		if(guesses > 0)
			return (double)wrong/(double)guesses; 
		else 
			return 0;
	}
	
	public void addCorrect() {
		this.guesses++;
		this.correct++;
	}
	public void addWrong() {
		this.guesses++;
		this.wrong++;
	}
}
