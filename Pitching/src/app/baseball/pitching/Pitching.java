package app.baseball.pitching;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Pitching extends Activity {
	Button strike, ball, foulBall, hit;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		strike = (Button) findViewById(R.id.strike);
		ball = (Button) findViewById(R.id.ball);
		foulBall = (Button) findViewById(R.id.foulBall);
		hit = (Button) findViewById(R.id.hit);

		strike.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub

			}
		});

		ball.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub

			}
		});
	}
}