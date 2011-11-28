package app.baseball.pitching.Models;

import app.baseball.pitching.Models.Interfaces.IStrikeCount;

public class StrikeCount implements IStrikeCount {
	// CONSTRUCTORS
	public StrikeCount(int strikeCount, int ballCount) {
		this._strike = strikeCount;
		this._ball = ballCount;
	}

	// FIELDS
	public IStrikeCount strikeCount;
	private int _strike = 0;
	private int _ball = 0;

	// PROPERTIES

	// METHODS

	public int getBalls() {
		return _ball;
	}

	public int getStrikes() {
		return _strike;
	}

	public String countString() {

		return String.format("[%s,%s]", this.getBalls(), this.getStrikes());

	}

}
