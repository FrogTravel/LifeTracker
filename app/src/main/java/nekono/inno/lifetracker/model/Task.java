package nekono.inno.lifetracker.model;

import com.orm.SugarRecord;

import java.io.Serializable;

public class Task extends SugarRecord implements Serializable{

    String name;
    String category;
    String state;
    String comment;
    Project project = null;

    public Project getProject() {
        return project;
    }

    public Task() {

    }

    public Task(String name, String category, String state, String comment) {
        this.name = name;
        this.category = category;
        this.state = state;
        this.comment = comment;
        save();
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public String getState() {
        return state;
    }

    public String getComment() {
        return comment;
    }

    public void setProject(Project project) {
        this.project = project;
        save();
    }

    public void setName(String name) {
        this.name = name;
        save();
    }

    public void setCategory(String category) {
        this.category = category;
        save();
    }

    public void setState(String state) {
        this.state = state;
        save();
    }


    public void setComment(String comment) {
        this.comment = comment;
        save();
    }
}