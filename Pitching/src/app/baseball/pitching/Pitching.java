package app.baseball.pitching;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import app.baseball.pitching.ArrayAdapters.PitchArrayAdapter;
import app.baseball.pitching.Models.Interfaces.IPitch;
import app.baseball.pitching.Models.Interfaces.IPitchCounter;
import app.baseball.pitching.Models.PitchCounter;

import java.util.ArrayList;

public class Pitching extends Activity {
	// CONTROLS
	private Button _strike, _ball, _foulBall, _hit;
	private ListView _outputList;
	private TextView _pitchCounterView;
	
	// OBJECTS
	private IPitchCounter _pitchCounter;
	
	
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
		this.InitializePitchCounter();
		this.InitializeButtons();
		
		this.UpdateUI();
	}

	private void InitializeButtons() {
		this._strike = (Button) findViewById(R.id.strike);
		this._strike.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				_pitchCounter.addStrike();
				UpdateUI();
			}
		});

		this._ball = (Button) findViewById(R.id.ball);
		this._ball.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				_pitchCounter.addBall();
				UpdateUI();
			}
		});

		this._foulBall = (Button) findViewById(R.id.foulBall);
		this._foulBall.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				_pitchCounter.addFoulBall();
				UpdateUI();
			}
		});

		this._hit = (Button) findViewById(R.id.hit);
		this._hit.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				_pitchCounter.reset();
				UpdateUI();
			}
		});
	}

	private void InitializePitchCounter(){
		this._pitchCounter = new PitchCounter(new PitchArrayAdapter(this, R.layout.output_template, new ArrayList<IPitch>()));
		this._outputList = (ListView) findViewById(R.id.outputList);
		this._outputList.setAdapter(this._pitchCounter.getPitchAdapter());		
		
		this._pitchCounterView = (TextView) findViewById(R.id.pitchCounter);
	}
	
	private void UpdateUI() {
		this.RefreshPitchCountView();
		this.UpdateButtonsEnabledState(this._pitchCounter.getIsCountFinished());
	}
	
	private void RefreshPitchCountView() {
		this._pitchCounterView.setText(this.getPitchCount());
	}
	
	private String getPitchCount() {
		return String.format("B-%s S-%s T-%s", this._pitchCounter.getBallCount(), this._pitchCounter.getStrikeCount(), this._pitchCounter.getTotalPitchCount());
	}
	
	private void UpdateButtonsEnabledState(Boolean countFinished) {
		this._strike.setEnabled(!countFinished);
		this._ball.setEnabled(!countFinished);
		this._foulBall.setEnabled(!countFinished);		
		this._hit.setEnabled(countFinished);
	}
}