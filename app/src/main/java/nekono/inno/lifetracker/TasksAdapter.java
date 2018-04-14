package nekono.inno.lifetracker;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.Collections;
import java.util.List;
import java.util.SimpleTimeZone;

import nekono.inno.lifetracker.model.Task;
import nekono.inno.lifetracker.views.SimpleTaskView;

public class TasksAdapter extends RecyclerView.Adapter<TasksAdapter.ItemViewHolder> {

    public List<Task> tasks = Collections.emptyList();

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.simple_task_view, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        holder.populate(tasks.get(position));
    }

    @Override
    public int getItemCount() {
        return tasks.size();
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    protected class ItemViewHolder extends RecyclerView.ViewHolder {

        SimpleTaskView taskView;
        Task task;

        public ItemViewHolder(View itemView) {
            super(itemView);
            taskView = (SimpleTaskView) itemView;
            taskView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    TaskActionActivity.startActivity(v.getContext(), task);
                    return true;
                }
            });
        }

        public void populate(Task task) {
            taskView.populate(task);
            this.task = task;
        }
    }
}
