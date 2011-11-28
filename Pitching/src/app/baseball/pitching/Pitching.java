package app.baseball.pitching;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import app.baseball.pitching.ArrayAdapters.PitchArrayAdapter;
import app.baseball.pitching.Models.Interfaces.ICoordinate;
import app.baseball.pitching.Models.Interfaces.IPitch;
import app.baseball.pitching.Models.Pitch;
import app.baseball.pitching.Models.PitchLocation;

import java.util.ArrayList;

public class Pitching extends Activity {
	// CONTROLS
	private Button _strike, _ball, _foulBall, _hit;
	private ListView _outputList;

	// ADAPTERS
	private PitchArrayAdapter _pitchArrayAdapter;

	// PUBLIC METHODS
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
	}

	@Override
	public void onStart() {
		super.onStart();
		this.setup();
	}

	// INITIALIZATION METHODS
	private void setup() {
		InitializeArrayAdapters();
		InitializeButtons();
	}

	private void InitializeButtons() {
		this._strike = (Button) findViewById(R.id.strike);
		this._strike.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				addPitch(true);
			}
		});

		this._ball = (Button) findViewById(R.id.ball);
		this._ball.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				addPitch(false);
			}
		});

		this._foulBall = (Button) findViewById(R.id.foulBall);
		this._foulBall.setClickable(false);
		this._foulBall.setEnabled(false);

		this._hit = (Button) findViewById(R.id.hit);
		this._hit.setClickable(false);
		this._hit.setEnabled(false);
	}

	private void InitializeArrayAdapters() {
		this._pitchArrayAdapter = new PitchArrayAdapter(this,
				R.layout.output_template, new ArrayList<IPitch>());
		this._outputList = (ListView) findViewById(R.id.outputList);
		this._outputList.setAdapter(this._pitchArrayAdapter);
	}

	// ADD PITCH METHOD
	private void addPitch(boolean isStrike) {
		ICoordinate coordinate = new PitchLocation(0, 0);
		IPitch Pitch = new Pitch(coordinate, isStrike);
		this._pitchArrayAdapter.add(Pitch);
	}
}