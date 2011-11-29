package app.baseball.pitching.Models.Interfaces;

public interface IPitch {
	ICoordinate getCoordinate();

	boolean getIsStrike();
	boolean getIsFoulBall();
	void setIsFoulBall(boolean foulBall);

	String getIsStrikeOutput();
}
