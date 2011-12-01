package app.baseball.pitching.Models.Interfaces;

import java.util.ArrayList;

public interface IPitchCounter {
	//Get Information about the Count
	int getBallCount();
	int getStrikeCount();
	int getFoulBallCount();
	int getTotalPitchCount();
	boolean getIsCountFinished();
	ArrayList<IPitch> getPitches();
	
	//Update Information about the Count
	void addStrike();
	void addBall();
	void addFoulBall();	
	void addPitch(IPitch pitch);
	
	//Reset
	void reset();
}
