package nekono.inno.lifetracker.expandableview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bignerdranch.expandablerecyclerview.Adapter.ExpandableRecyclerAdapter;
import com.bignerdranch.expandablerecyclerview.Model.ParentObject;

import java.util.List;

import nekono.inno.lifetracker.R;

/**
 * Created by ekaterina on 4/5/18.
 */

public class TasksExpandableAdapter extends ExpandableRecyclerAdapter<ProjectParentViewHolder, TaskChildViewHolder> {


    public TasksExpandableAdapter(Context context, List<ParentObject> parentItemList) {
        super(context, parentItemList);
    }

    @Override
    public ProjectParentViewHolder onCreateParentViewHolder(ViewGroup viewGroup) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.project_view_holder_parent, viewGroup, false);
        return new ProjectParentViewHolder(view);
    }

    @Override
    public TaskChildViewHolder onCreateChildViewHolder(ViewGroup viewGroup) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.task_view_holder_child, viewGroup, false);
        return new TaskChildViewHolder(view);
    }

    @Override
    public void onBindParentViewHolder(ProjectParentViewHolder projectParentViewHolder, int i, Object o) {
        Project project = (Project) o;
        projectParentViewHolder.titleTextView.setText(project.getName());
        projectParentViewHolder.descriptionTextView.setText(project.getDescription());
    }

    @Override
    public void onBindChildViewHolder(TaskChildViewHolder taskChildViewHolder, int i, Object o) {
        Task task = (Task) o;
        taskChildViewHolder.titleChildTextView.setText(task.getName());
    }
}
