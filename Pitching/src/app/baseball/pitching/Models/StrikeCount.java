package app.baseball.pitching.Models;

import app.baseball.pitching.ArrayAdapters.CountArrayAdapter;
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

	
   
    //METHODS

    public int getBalls()
    {
    	CountArrayAdapter balls = new CountArrayAdapter(null, _ball);
    	return _ball;
    }
    public int getStrikes()
	{
		CountArrayAdapter strikes = new CountArrayAdapter(null, _strike);
		return _strike;
	}
	
    
	public String countString()
	{
		
		return String.format("[%s,%s]", this.getBalls(), this.getStrikes());
		
	}

	
}


