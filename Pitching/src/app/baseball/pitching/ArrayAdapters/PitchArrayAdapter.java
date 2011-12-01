package app.baseball.pitching.ArrayAdapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import app.baseball.pitching.Models.Interfaces.IPitch;
import app.baseball.pitching.R;

import java.util.ArrayList;
import java.util.List;

public class PitchArrayAdapter extends ArrayAdapter<IPitch> implements IPitchArrayAdapter {
	// CONSTRUCTORS
	public PitchArrayAdapter(Activity context, int textViewResourceId) {
		super(context, textViewResourceId);
		this._context = context;
		this._pitches = new ArrayList<IPitch>();
	}

	public PitchArrayAdapter(Activity context, int textViewResourceId,
			List<IPitch> objects) {
		super(context, textViewResourceId, objects);
		this._context = context;
		this._pitches = objects;
	}

	// PRIVATE FIELDS
	private Activity _context;
	private List<IPitch> _pitches;

	// METHODS
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder viewHolder;

		View rowView = convertView;
		if (rowView == null) {
			LayoutInflater inflater = this._context.getLayoutInflater();
			rowView = inflater.inflate(R.layout.output_template, null, true);

			viewHolder = new ViewHolder();
			viewHolder.Column1 = (TextView) rowView.findViewById(R.id.column1);
			viewHolder.Column2 = (TextView) rowView.findViewById(R.id.column2);

			rowView.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) rowView.getTag();
		}

		IPitch p = this._pitches.get(position);

		viewHolder.Column1.setText(p.getCoordinate().toString());
		viewHolder.Column2.setText(this._pitches.get(position)
				.getIsStrikeOutput());
		return rowView;
	}


	// IPitchArrayAdapter
	public int getStrikeCount() {
		int count = 0;
		for (IPitch pitch : this._pitches)
		{
			if (pitch.getIsStrike())
			{
				if (count < 2)
					count++;
				else if (!pitch.getIsFoulBall())
					return 3;
			}
		}
		
		return count;
	}
	
	public int getBallCount() {
		int count = 0;
		for (IPitch pitch : this._pitches)
			if (!pitch.getIsStrike())
				count++;
		
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
		if (this._pitches != null)
			return this._pitches.size();
		return 0;
	}
	
	public static class ViewHolder {
		public TextView Column1;
		public TextView Column2;
	}
}
