package app.baseball.pitching.ArrayAdapters;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import app.baseball.pitching.R;
import app.baseball.pitching.Models.Interfaces.IStrikeCount;

public class CountArrayAdapter extends ArrayAdapter<IStrikeCount>
{
	//CONSTRUCTORS
	public CountArrayAdapter(Activity context, int textViewResourceId)
	{
		super(context, textViewResourceId);
		this._context = context;
		this._count = new ArrayList<IStrikeCount>();	
	}
	public CountArrayAdapter(Activity context, int textViewResourceId, List<IStrikeCount> objects)
	{
		super(context, textViewResourceId);
		this._context = context;
		this._count = objects;
	}
	//PRIVATE FIELDS
	private Activity _context;
	private List<IStrikeCount> _count;
	
	//METHODS
	@Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        ViewHolder viewHolder;

        View rowView = convertView;
        if (rowView == null)
        {
            LayoutInflater inflater = this._context.getLayoutInflater();
            rowView = inflater.inflate(R.layout.output_template, null, true);

            viewHolder = new ViewHolder();
            viewHolder.StrikeCount = (TextView) rowView.findViewById(R.id.strikeCount);
            

            rowView.setTag(viewHolder);
        }
        else
        {
            viewHolder = (ViewHolder)rowView.getTag();
        }
        
        IStrikeCount count = this._count.get(getCount());
        
        viewHolder.StrikeCount.setText(count.toString());
        return rowView;
    }
    
    
    private static class ViewHolder
    {
        public TextView StrikeCount;
        
    }
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
	
	
	
	
}
