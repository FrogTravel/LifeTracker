package nekono.inno.lifetracker.model;
import android.util.ArraySet;

import com.bignerdranch.expandablerecyclerview.Model.ParentObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Model {
    private List<Project> projects;
    private List<Task> tasks;

    public static List<Task> getTasks() {
        return Task.listAll(Task.class);
    }

    public static List<Project> getProjects() {
        return Project.listAll(Project.class);
    }

    public static List<Task> getTasksByCategory(String category) {
        List<Task> tasks = new ArrayList<>();
        for (Task task :
                getTasks()) {
            if (task.getCategory() != null)
                if (task.getCategory().equals(category))
                    tasks.add(task);
        }
        return tasks;
    }

    public static List<Task> getTasksByName(String name) {
        List<Task> tasks = new ArrayList<>();
        for (Task task :
                getTasks()) {
            if (task.getName() != null)
                if (task.getName().equals(name))
                    tasks.add(task);
        }
        return tasks;
    }

    public ArrayList<String> getCategories() {
        List<Task> tasksLocal = getTasks();
        Set<String> categories = new ArraySet<>();
        for (int i = 0; i < tasksLocal.size(); i++) {
            if(tasksLocal.get(i).category != null) {
                categories.add(tasksLocal.get(i).category);
            }
        }
        return new ArrayList<>(categories);
    }

    public List<ParentObject> getParentObjectProject(){
        List<ParentObject> temp = new ArrayList<>();

        temp.addAll(temp);

        return temp;
    }


}