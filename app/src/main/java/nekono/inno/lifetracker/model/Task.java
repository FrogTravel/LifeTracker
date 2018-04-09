package nekono.inno.lifetracker.model;

import com.orm.SugarRecord;

import java.security.Policy;

public class Task extends SugarRecord {

    String name;
    String category;
    String state;
    String comments;
    Project project = null;

    public Project getProject() {
        return project;
    }

    public Task(){

    }

    public Task(String name, String category, String state, String comments) {
        this.name = name;
        this.category = category;
        this.state = state;
        this.comments = comments;
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

    public String getComments() {
        return comments;
    }

    public void setProject(Project project){
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


    public void setComments(String comments) {
        this.comments = comments;
        save();
    }
}