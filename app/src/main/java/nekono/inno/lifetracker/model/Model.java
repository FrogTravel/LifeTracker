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

    public List<String> getCategories() {
        List<String> categories = new ArrayList<>();
        for (int i = 0; i < tasks.size(); i++) {
            categories.add(tasks.get(i).category);
        }
        return categories;
    }

    public List<ParentObject> getParentObjectProject(){
        List<ParentObject> temp = new ArrayList<>();

        temp.addAll(temp);

        return temp;
    }
}