package app.baseball.pitching.Models;

import java.util.ArrayList;

import app.baseball.pitching.Models.Interfaces.IPitch;
import app.baseball.pitching.Models.Interfaces.IPitchCounter;
import app.baseball.pitching.Models.Pitch;

public class PitchCounter implements IPitchCounter {
	
	//CONSTRUCTORS
	public PitchCounter() {
		this._pitches = new ArrayList<IPitch>();
	}
	public PitchCounter(ArrayList<IPitch> pitches) {
		this._pitches = pitches;
	}
	
	//FIELDS
	private ArrayList<IPitch> _pitches;
		
	//PROPERTIES
	public int getBallCount() {
		int count = 0;
		for (IPitch pitch : this._pitches)
			if (!pitch.getIsStrike())
				count++;

		return count;
	}

	public int getStrikeCount() {
		int count = 0;
		for (IPitch pitch : this._pitches) {
			if (pitch.getIsStrike()) {
				if (count < 2)
					count++;
				else if (!pitch.getIsFoulBall())
					return 3;
			}
		}

		return count;
	}

	public int getFoulBallCount() {
		int count = 0;
		for (IPitch pitch : this._pitches)
			if (pitch.getIsFoulBall())
				count++;

		return count;
	}

	public int getTotalPitchCount() {
		return this._pitches.size();
	}
	
	public boolean getIsCountFinished() {
		return this.getBallCount() == 4 || this.getStrikeCount() == 3;
	}
	
	public ArrayList<IPitch> getPitches() {
		return this._pitches;
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
	
	public void addPitch(IPitch pitch){
		this._pitches.add(pitch);
	}
	
	public void reset() {
		this._pitches.clear();
	}
}
