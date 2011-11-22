package app.baseball.pitching.Models;

import app.baseball.pitching.Models.Interfaces.ICoordinate;

public class PitchLocation implements ICoordinate
{
    //CONSTRUCTORS
    public PitchLocation(int x, int y)
    {
        this._xCoordinate = x;
        this._yCoordinate = y;
    }


    //FIELDS
    private int _xCoordinate = 0;
    private int _yCoordinate = 0;


    //PROPERTIES
    public int getXCoordinate()
    {
        return this._xCoordinate;
    }

    public int getYCoordinate()
    {
        return this._yCoordinate;
    }


    //METHODS
    @Override
    public String toString()
    {
        return String.format("[%s, %s]", this.getXCoordinate(), this.getYCoordinate());
    }
}
