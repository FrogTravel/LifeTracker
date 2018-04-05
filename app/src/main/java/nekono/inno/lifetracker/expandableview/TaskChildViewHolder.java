package nekono.inno.lifetracker.expandableview;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.bignerdranch.expandablerecyclerview.ViewHolder.ChildViewHolder;

import nekono.inno.lifetracker.R;

/**
 * Created by ekaterina on 4/5/18.
 */

public class TaskChildViewHolder extends ChildViewHolder {
    public TextView titleChildTextView;

    public TaskChildViewHolder(View itemView) {
        super(itemView);
        titleChildTextView = (TextView) itemView.findViewById(R.id.titleChildTextView);
    }
}
