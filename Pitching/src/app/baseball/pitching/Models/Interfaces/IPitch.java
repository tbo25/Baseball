package app.baseball.pitching.Models.Interfaces;

public interface IPitch
{
    ICoordinate getCoordinate();
    boolean isStrike();
    String getIsStrikeOutput();
}
