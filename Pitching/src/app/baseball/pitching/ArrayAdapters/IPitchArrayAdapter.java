package app.baseball.pitching.ArrayAdapters;

import app.baseball.pitching.Models.Interfaces.IPitch;

public interface IPitchArrayAdapter {
	int getStrikeCount();
	int getBallCount();
	int getFoulBallCount();
	int getTotalPitchCount();
	
	void clear();
	void add(IPitch object);
}
