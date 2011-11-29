package app.baseball.pitching.Models.Interfaces;

import app.baseball.pitching.ArrayAdapters.PitchArrayAdapter;

public interface IPitchCounter {
	//Get Information about the Count
	int getBallCount();
	int getStrikeCount();
	int getFoulBallCount();
	int getTotalPitchCount();
	boolean getIsCountFinished();
	PitchArrayAdapter getPitchAdapter();
	
	//Update Information about the Count
	void addStrike();
	void addBall();
	void addFoulBall();	
	void addPitch(IPitch pitch);
	
	//Reset
	void reset();
}
