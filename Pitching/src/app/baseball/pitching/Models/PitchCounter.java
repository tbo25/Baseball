package app.baseball.pitching.Models;

import app.baseball.pitching.ArrayAdapters.IPitchArrayAdapter;
import app.baseball.pitching.Models.Interfaces.IPitch;
import app.baseball.pitching.Models.Interfaces.IPitchCounter;
import app.baseball.pitching.Models.Pitch;

public class PitchCounter implements IPitchCounter {
	
	//CONSTRUCTORS
	public PitchCounter(IPitchArrayAdapter pitchAdapter) {
		this._pitchArrayAdapter = pitchAdapter;
	}
	
	//FIELDS
	private IPitchArrayAdapter _pitchArrayAdapter;
		
	//PROPERTIES
	public int getBallCount() {
		return this._pitchArrayAdapter.getBallCount();
	}

	public int getStrikeCount() {
		return this._pitchArrayAdapter.getStrikeCount();
	}

	public int getFoulBallCount() {
		return this._pitchArrayAdapter.getFoulBallCount();
	}

	public int getTotalPitchCount() {
		return this._pitchArrayAdapter.getTotalPitchCount();
	}
	
	public boolean getIsCountFinished() {
		return this.getBallCount() == 4 || this.getStrikeCount() == 3;
	}
	
	public IPitchArrayAdapter getPitchAdapter() {
		return this._pitchArrayAdapter;
	}
	
	
	//METHODS
	public void addBall() {
		IPitch pitch = new Pitch(false);
		this.addPitch(pitch);
	}
	
	public void addStrike() {
		IPitch pitch = new Pitch(true);
		this.addPitch(pitch);
	}
	
	public void addFoulBall() {		
		IPitch pitch = new Pitch(true);
		pitch.setIsFoulBall(true);
		this.addPitch(pitch);
	}
	
	public void reset() {
		this._pitchArrayAdapter.clear();
	}
	
	public void addPitch(IPitch pitch){
		this._pitchArrayAdapter.add(pitch);
	}
}
