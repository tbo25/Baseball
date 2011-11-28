package app.baseball.pitching.Models;

import app.baseball.pitching.Models.Interfaces.IStrikeCount;

public class StrikeCount implements IStrikeCount
{
	 //CONSTRUCTORS
    public StrikeCount(int x, int y)
    {
    	this._strike = x;
    	this._ball = y;
    }
	//FIELDS
    public IStrikeCount strikeCount;
    private int _strike = 0;
    private int _ball = 0;   
    
    //PROPERTIES

	public int getStrike()
	{
		int _strike = 0;
		if(_strike <= 0)
		{
			_strike++;
		}
		if(_strike == 2)
		{
			_strike = 0;
		}				    	
		return _strike;
	}

	public int getBall()
	{
		int _ball = 0;
		if(_ball <= 0)
		{
			_ball++;
		}
		if(_ball == 4)
		{
			_ball = 0;
		}				    	
		return _ball;
	}
   
    //METHODS
	
	public String countString()
	{
		
		return String.format("[%s,%s]", this.getBall(), this.getStrike());
		
	}
	
}


