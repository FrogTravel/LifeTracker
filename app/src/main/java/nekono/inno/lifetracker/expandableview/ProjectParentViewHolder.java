package nekono.inno.lifetracker.expandableview;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.bignerdranch.expandablerecyclerview.ViewHolder.ParentViewHolder;

import nekono.inno.lifetracker.R;
import nekono.inno.lifetracker.tasks.Tasks;

/**
 * Created by ekaterina on 4/5/18.
 */

public class ProjectParentViewHolder extends ParentViewHolder implements View.OnLongClickListener{
    public TextView titleTextView;
    public ImageButton mParentDropDownArrow;

    private Tasks.Presenter presenter;


    public ProjectParentViewHolder(View itemView, Tasks.Presenter presenter) {
        super(itemView);

        titleTextView = (TextView) itemView.findViewById(R.id.titleProjectTextView);
        mParentDropDownArrow = (ImageButton) itemView.findViewById(R.id.parent_list_item_expand_arrow);
        this.presenter = presenter;
        itemView.setOnLongClickListener(this);
    }


    @Override
    public boolean onLongClick(View view) {
        presenter.longProjectClick();
        return true;
    }


}
