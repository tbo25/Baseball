package app.baseball.pitching.Models;

import app.baseball.pitching.Models.Interfaces.ICoordinate;
import app.baseball.pitching.Models.Interfaces.IPitch;

public class Pitch implements IPitch
{
    //CONSTRUCTORS
    public Pitch(ICoordinate coordinate, boolean isStrike)
    {
        this._coordinate = coordinate;
        this._isStrike = isStrike;
    }


    //FIELDS
    private ICoordinate _coordinate;
    private boolean _isStrike = false;


    //PROPERTIES
    public ICoordinate getCoordinate()
    {
        return this._coordinate;
    }

    public boolean isStrike()
    {
        return this._isStrike;
    }

    public String getIsStrikeOutput()
    {
        if (this.isStrike())
            return "Strike";
        return "Ball";
    }


    //METHODS
}
