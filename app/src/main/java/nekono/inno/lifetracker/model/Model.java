package nekono.inno.lifetracker.model;
import com.bignerdranch.expandablerecyclerview.Model.ParentObject;

import java.util.ArrayList;
import java.util.List;

public class Model {
    private List<Project> projects;
    private List<Task> tasks;

    public static List<Task> getTasks() {
        return Task.listAll(Task.class);
    }

    public List<Project> getProjects() {
        return Project.listAll(Project.class);
    }

    public List<Task> getTasksByCategory(String category) {
        List<Task> tasks = new ArrayList<>();
        for (Task task :
                getTasks()) {
            if (task.getCategory().equals(category))
                tasks.add(task);
        }
        return tasks;
    }

    public List<ParentObject> getParentObjectProject(){
        List<ParentObject> temp = new ArrayList<>();

        temp.addAll(temp);

        return temp;
    }
}