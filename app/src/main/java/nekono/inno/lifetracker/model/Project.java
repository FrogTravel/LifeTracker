package nekono.inno.lifetracker.model;

import com.bignerdranch.expandablerecyclerview.Model.ParentObject;
import com.orm.SugarRecord;

import java.util.ArrayList;
import java.util.List;

public class Project extends SugarRecord implements ParentObject {
    String name;

    public Project() {

    }

    public Project(String name) {
        this.name = name;
        save();
    }

    public String getName() {
        if(name == null)
            return "";
        return name;
    }

    public List<Task> getTasks() {
        return Task.find(Task.class, "project = ?", Long.toString(this.getId()));
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

    @Override
    public List<Object> getChildObjectList() {
        return (List<Object>) (Object) Task.find(Task.class, "project = ?", Long.toString(this.getId()));
    }

    @Override
    public void setChildObjectList(List<Object> list) {
        //TODO ???
    }
}