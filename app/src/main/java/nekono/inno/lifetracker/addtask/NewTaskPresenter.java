package nekono.inno.lifetracker.addtask;

import android.content.Context;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import org.threeten.bp.Duration;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import nekono.inno.lifetracker.model.Model;
import nekono.inno.lifetracker.model.Project;
import nekono.inno.lifetracker.model.Task;

public class NewTaskPresenter implements NewEditTaskInterface.Presenter {

    private NewEditTaskInterface.View editTaskView;
    private Task task = new Task();
    private Project newProject;
    private String state;

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
        state = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onAddPressed(TextView taskName, TextView category, TextView project, TextView comments, Context context, String name) {
        Date finished = new Date(0);
        Duration duration = Duration.ofSeconds(0);
        Model model = new Model();
        List<Project> projects = model.getProjects();
        int projectIndex = getProjectIndex(project.getText().toString(), projects);
        if (taskName.getText().toString().equals("")) {
            task = new Task("Untitled", category.getText().toString(), state, comments.getText().toString(), Calendar.getInstance().getTime(),
                    finished, duration);
        }
        else {
            task = new Task(taskName.getText().toString(), category.getText().toString(), state, comments.getText().toString(), Calendar.getInstance().getTime(),
                    finished, duration);
        }
        if (projectIndex > -1) {
            task.setProject(projects.get(projectIndex));
            projects.get(projectIndex).addTask(task);
        }
        else {
            task.setProject(new Project(project.getText().toString()));
        }
        Toast.makeText(context, "Your task is created!", Toast.LENGTH_LONG).show();
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
