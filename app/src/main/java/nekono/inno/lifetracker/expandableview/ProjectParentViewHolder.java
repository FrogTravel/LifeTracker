package nekono.inno.lifetracker.expandableview;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.bignerdranch.expandablerecyclerview.ViewHolder.ParentViewHolder;

import nekono.inno.lifetracker.R;

/**
 * Created by ekaterina on 4/5/18.
 */

public class ProjectParentViewHolder extends ParentViewHolder {
    public TextView titleTextView;
    public TextView descriptionTextView;
    public ImageButton mParentDropDownArrow;


    public ProjectParentViewHolder(View itemView) {
        super(itemView);

        titleTextView = (TextView) itemView.findViewById(R.id.titleProjectTextView);
        descriptionTextView = itemView.findViewById(R.id.descriptionTextView);
        mParentDropDownArrow = (ImageButton) itemView.findViewById(R.id.parent_list_item_expand_arrow);
    }
}
