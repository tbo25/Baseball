package app.baseball.pitching.Models;

import app.baseball.pitching.Models.Interfaces.IPitchCounter;

public class PitchCounter implements IPitchCounter {
	
	//CONSTRUCTORS
	public PitchCounter() {		
	}
	
	//FIELDS
	private int _ballCount = 0;
	private int _strikeCount = 0;	
	private int _foulBallCount = 0;
		
	//PROPERTIES
	public int getBallCount() {
		return this._ballCount;
	}

	public int getStrikeCount() {
		return this._strikeCount;
	}

	public int getFoulBallCount() {
		return this._foulBallCount;
	}

	public int getTotalPitchCount() {
		return this.getBallCount() + this.getStrikeCount() + this.getFoulBallCount();
	}
	
	public Boolean getIsCountFinished() {
		return this.getBallCount() == 4 || this.getStrikeCount() == 3;
	}
	
	//METHODS
	public int addBall() {
		this._ballCount++;
		return this.getBallCount();
	}
	
	public int addStrike() {
		this._strikeCount++;
		return this.getStrikeCount();
	}
	
	public int addFoulBall() {
		if (this.getStrikeCount() < 2)
			this.addStrike();
		else
			this._foulBallCount++;
		
		return this.getFoulBallCount();
	}
	
	public void reset() {
		this._strikeCount = 0;
		this._ballCount = 0;
		this._foulBallCount	= 0;
	}
}
