package nekono.inno.lifetracker.model;
import com.bignerdranch.expandablerecyclerview.Model.ParentObject;

import java.util.ArrayList;
import java.util.List;

public class Model {
    private List<Project> projects;
    private List<Task> tasks;

    public Model() {
        update();
    }

    private void update(){
        projects =  Project.listAll(Project.class);
        tasks = Task.listAll(Task.class);
    }

    public List<Task> getTasks() {
        update();
        return tasks;
    }

    public List<Project> getProjects() {
        update();
        return projects;
    }

    public List<ParentObject> getParentObjectProject(){
        List<ParentObject> temp = new ArrayList<>();

        temp.addAll(temp);

        return temp;
    }
}