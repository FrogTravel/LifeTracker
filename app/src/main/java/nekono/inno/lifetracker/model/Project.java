package nekono.inno.lifetracker.model;
import com.orm.SugarRecord;

import java.util.ArrayList;
import java.util.List;

public class Project extends SugarRecord<Project> {
    String name;

    public Project(){

    }

    public Project(String name) {
        this.name = name;
        save();
    }

    public String getName() {
        return name;
    }

    public List<Task> getTasks() {
        return Task.find(Task.class, "project = ?",Long.toString(this.getId()));
    }

    public void setName(String name) {
        this.name = name;
        save();
    }

    public void addTask(Task task) {
        task.setProject(this);
    }

    public boolean contains(Task task) {
        return getTasks().contains(task);
    }
}