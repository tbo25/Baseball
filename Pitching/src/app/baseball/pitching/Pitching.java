package app.baseball.pitching;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import app.baseball.pitching.ArrayAdapters.PitchArrayAdapter;
import app.baseball.pitching.Models.Interfaces.ICoordinate;
import app.baseball.pitching.Models.Interfaces.IPitch;
import app.baseball.pitching.Models.Pitch;
import app.baseball.pitching.Models.PitchCounter;
import app.baseball.pitching.Models.PitchLocation;

import java.util.ArrayList;

public class Pitching extends Activity {
	// CONTROLS
	private Button _strike, _ball, _foulBall, _hit;
	private ListView _outputList;
	private TextView _pitchCounterView;
	
	// OBJECTS
	private PitchCounter _pitchCounter;
	
	
	// ADAPTERS
	//TODO: Move this into a PitchCounter object
	//private PitchArrayAdapter _pitchArrayAdapter;

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
		this.InitializeArrayAdapters();
		this.InitializeButtons();
		
		this.InitializePitchCounter();
	}

	private void InitializeButtons() {
		this._strike = (Button) findViewById(R.id.strike);
		this._strike.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				_pitchCounter.addStrike();
				RefreshPitchCountView();
			}
		});

		this._ball = (Button) findViewById(R.id.ball);
		this._ball.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				_pitchCounter.addBall();
				RefreshPitchCountView();
			}
		});

		this._foulBall = (Button) findViewById(R.id.foulBall);
		this._foulBall.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				_pitchCounter.addFoulBall();
				RefreshPitchCountView();
			}
		});

		this._hit = (Button) findViewById(R.id.hit);
		this._hit.setClickable(false);
		this._hit.setEnabled(false);
	}

	private void InitializePitchCounter(){
		this._pitchCounter = new PitchCounter();
		this._pitchCounterView = (TextView) findViewById(R.id.pitchCounter);
	}
	
	private void RefreshPitchCountView() {
		this._pitchCounterView.setText(this._pitchCounter.getPitchCount());
	}
	
	private void InitializeArrayAdapters() {
//		this._pitchArrayAdapter = new PitchArrayAdapter(this,
//				R.layout.output_template, new ArrayList<IPitch>());
//		this._outputList = (ListView) findViewById(R.id.outputList);
//		this._outputList.setAdapter(this._pitchArrayAdapter);
	}

}