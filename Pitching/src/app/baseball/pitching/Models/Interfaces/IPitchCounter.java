package app.baseball.pitching.Models.Interfaces;

public interface IPitchCounter {
	//Get Information about the Count
	int getBallCount();
	int getStrikeCount();
	int getFoulBallCount();
	int getTotalPitchCount();
	
	//Update Information about the Count
	int addStrike();
	int addBall();
	int addFoulBall();	
}
