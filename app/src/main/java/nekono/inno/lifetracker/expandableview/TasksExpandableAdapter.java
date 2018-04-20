package nekono.inno.lifetracker.expandableview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bignerdranch.expandablerecyclerview.Adapter.ExpandableRecyclerAdapter;
import com.bignerdranch.expandablerecyclerview.Model.ParentObject;

import java.util.List;

import nekono.inno.lifetracker.R;
import nekono.inno.lifetracker.model.Project;
import nekono.inno.lifetracker.model.Task;
import nekono.inno.lifetracker.tasks.Tasks;

/**
 * Created by ekaterina on 4/5/18.
 */

public class TasksExpandableAdapter extends ExpandableRecyclerAdapter<ProjectParentViewHolder, TaskChildViewHolder> {
    private Tasks.Presenter presenter;

    public TasksExpandableAdapter(Context context, Tasks.Presenter presenter) {
        super(context, presenter.getParentItemList());
        this.presenter = presenter;
    }

    @Override
    public ProjectParentViewHolder onCreateParentViewHolder(ViewGroup viewGroup) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.project_view_holder_parent, viewGroup, false);
        return new ProjectParentViewHolder(view, presenter);
    }

    @Override
    public TaskChildViewHolder onCreateChildViewHolder(ViewGroup viewGroup) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.task_view_holder_child, viewGroup, false);
        return new TaskChildViewHolder(view, presenter);
    }

    @Override
    public void onBindParentViewHolder(ProjectParentViewHolder projectParentViewHolder, int i, Object o) {
        Project project = (Project) o;
        projectParentViewHolder.titleTextView.setText(project.getName());
        projectParentViewHolder.descriptionTextView.setText("La la la");
    }

    @Override
    public void onBindChildViewHolder(TaskChildViewHolder taskChildViewHolder, int i, Object o) {
        Task task = (Task) o;
        taskChildViewHolder.titleChildTextView.setText(task.getName());
    }
}
