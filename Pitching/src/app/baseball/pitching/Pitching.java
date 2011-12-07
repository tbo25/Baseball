package app.baseball.pitching;

//import com.j256.ormlite.android.apptools.OpenHelperManager;
//import com.j256.ormlite.dao.Dao;
//import com.j256.ormlite.misc.SqlExceptionUtil;
//
//import java.sql.SQLException;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
//import android.util.Log;
import app.baseball.pitching.ArrayAdapters.PitchArrayAdapter;
import app.baseball.pitching.Models.Interfaces.IPitchCounter;
import app.baseball.pitching.Models.PitchCounter;
//import app.baseball.pitching.Models.SimpleData;
//import app.baseball.database.DatabaseHelper;


public class Pitching extends Activity {
	// CONTROLS
	private Button _strike, _ball, _foulBall, _clear;
	private ListView _outputList;
	private TextView _pitchCounterView;
//	private TextView _dbOutput;
	
	// OBJECTS
	private IPitchCounter _pitchCounter;
//	private DatabaseHelper _databaseHelper = null;
	
	
	// PUBLIC METHODS
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		//this._dbOutput = (TextView) findViewById(R.id.pitchCounter);
		//this.trydb();
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

		this._clear = (Button) findViewById(R.id.clear);
		this._clear.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				_pitchCounter.reset();
				UpdateUI();
			}
		});
	}

	private void InitializePitchCounter() {
		this._pitchCounter = new PitchCounter();
		PitchArrayAdapter adapter = new PitchArrayAdapter(this, R.layout.output_template, this._pitchCounter.getPitches()); 
		
		this._outputList = (ListView) findViewById(R.id.outputList);
		this._outputList.setAdapter(adapter);		
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
		this._clear.setEnabled(countFinished);
	}
	
//	private DatabaseHelper getDBHelper() {
//		if (this._databaseHelper == null)
//			this._databaseHelper = OpenHelperManager.getHelper(this, DatabaseHelper.class);
//		return this._databaseHelper;
//	}
//	
//	private void trydb() {
//		
//		
//		try {
//			Dao<SimpleData, Integer> sdDao = this.getDBHelper().getSimpleDataDao();
//			
//			
//		} catch (SQLException e) {
//			Log.e("Pitching", "Database Exception", e);
//		}
//	}
}