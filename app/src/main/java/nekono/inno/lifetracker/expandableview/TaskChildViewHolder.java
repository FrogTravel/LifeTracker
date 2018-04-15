package nekono.inno.lifetracker.expandableview;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.bignerdranch.expandablerecyclerview.ViewHolder.ChildViewHolder;

import nekono.inno.lifetracker.R;
import nekono.inno.lifetracker.tasks.Tasks;

/**
 * Created by ekaterina on 4/5/18.
 */

public class TaskChildViewHolder extends ChildViewHolder implements View.OnLongClickListener, View.OnClickListener{
    public TextView titleChildTextView;

    private Tasks.Presenter presenter;

    public TaskChildViewHolder(View itemView, Tasks.Presenter presenter) {
        super(itemView);
        titleChildTextView = (TextView) itemView.findViewById(R.id.titleChildTextView);
        this.presenter = presenter;
        itemView.setOnLongClickListener(this);
        itemView.setOnClickListener(this);
    }


    @Override
    public boolean onLongClick(View view) {
        presenter.longTaskClick();

        return true;
    }

    @Override
    public void onClick(View view) {
        presenter.onClickTask();
    }
}
