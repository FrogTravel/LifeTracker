package nekono.inno.lifetracker.edittask;

import android.content.Context;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import org.threeten.bp.Duration;

import java.util.List;

import nekono.inno.lifetracker.addtask.NewEditTaskInterface;
import nekono.inno.lifetracker.model.Model;
import nekono.inno.lifetracker.model.Project;
import nekono.inno.lifetracker.model.Task;

public class EditTaskPresenter implements NewEditTaskInterface.Presenter {

    private NewEditTaskInterface.View editTaskView;
    private Task task = new Task();
    private Project newProject;

    public EditTaskPresenter(NewEditTaskInterface.View editTaskView) {
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
    public void onAddPressed(TextView taskName, TextView category, TextView project, TextView comments, Context context, String name, long time) {
        Model model = new Model();
        List<Task> tasks = model.getTasks();
        List<Project> projects = model.getProjects();
        int projectIndex = getProjectIndex(project.getText().toString(), projects);
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getName().equals(name)) {
                task = tasks.get(i);
            }
        }
        if (taskName.getText().toString().equals("")) {
            task.setName("Untitled");
        }
        else {
            task.setName(taskName.getText().toString());
        }
        if (projectIndex > -1) {
            task.setProject(projects.get(projectIndex));
            projects.get(projectIndex).addTask(task);
        }
        else {
            task.setProject(new Project(project.getText().toString()));
        }
        task.setCategory(category.getText().toString());
        task.setComments(comments.getText().toString());
        task.setTimeElapsed(Duration.ofMillis(time));
        Toast.makeText(context, "Your task is updated!", Toast.LENGTH_LONG).show();
        editTaskView.close();
    }

    private int getProjectIndex(String name, List<Project> projects) {
        for (int i = 0; i < projects.size(); i++) {
            if (projects.get(i).getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }
}
