package app.baseball.pitching.Models;

import app.baseball.pitching.Models.Interfaces.ICoordinate;
import app.baseball.pitching.Models.Interfaces.IPitch;

public class Pitch implements IPitch {
	// CONSTRUCTORS
	public Pitch(boolean isStrike) {
		this._coordinate = new PitchLocation(0, 0);
		this._isStrike = isStrike;
	}
	public Pitch(ICoordinate coordinate, boolean isStrike) {
		this._coordinate = coordinate;
		this._isStrike = isStrike;
	}
	

	// FIELDS
	public ICoordinate _coordinate;
	private boolean _isStrike = false;
	private boolean _isFoulBall = false;

	// PROPERTIES
	public ICoordinate getCoordinate() {
		return this._coordinate;
	}

	public boolean getIsStrike() {
		return this._isStrike;
	}

	public boolean getIsFoulBall() {
		return this._isFoulBall;
	}
	public void setIsFoulBall(boolean foulBall) {
		this._isFoulBall = foulBall;
	}

	public String getIsStrikeOutput() {
		if (this.getIsStrike())
			return this.getIsFoulBall() ? "Foul Ball" : "Strike";
		return "Ball";
	}

	// METHODS
}
