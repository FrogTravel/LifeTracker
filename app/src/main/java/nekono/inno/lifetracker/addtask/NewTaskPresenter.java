package nekono.inno.lifetracker.addtask;

import android.content.Context;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import nekono.inno.lifetracker.model.Project;
import nekono.inno.lifetracker.model.Task;

public class NewTaskPresenter implements NewEditTaskInterface.Presenter {

    private NewEditTaskInterface.View editTaskView;
    private Task task = new Task();
    private Project newProject;

    public NewTaskPresenter(NewEditTaskInterface.View editTaskView) {
        this.editTaskView = editTaskView;
    }

    @Override
    public void onPlayPressed(Context context) {
        Toast.makeText(context, "Timer is started!",
                Toast.LENGTH_LONG).show();
        //TODO start timer
    }

    @Override
    public void onItemSelected(int position, AdapterView<?> parent) {
        task.setState(parent.getItemAtPosition(position).toString());
    }

    @Override
    public void onAddPressed(TextView taskName, TextView category, TextView project, TextView comments, Context context) {
        task.setName(taskName.getText().toString());
        task.setCategory(category.getText().toString());
        newProject = new Project(project.getText().toString());
        task.setProject(newProject);
        task.setComments(comments.getText().toString());
        Toast.makeText(context, task.getName() + " " + task.getCategory() + " " + task.getState() + " " + task.getProject().getName() + " " + task.getComments() + "created!",
                Toast.LENGTH_LONG).show();
        editTaskView.close();
    }
}
