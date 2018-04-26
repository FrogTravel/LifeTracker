package nekono.inno.lifetracker.model;

import com.orm.SugarRecord;

import org.threeten.bp.Duration;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Task extends SugarRecord{

    String name;
    String category;
    String state;
    String comments;
    long dateStarted;
    long dateCompleted;
    SimpleDateFormat df;
    long timeElapsed;
    Project project;

    public Task(){
        df = new SimpleDateFormat("dd-MM-yyyy");
    }

    public Task(String name, String category, String state, String comments, Date started, Date completed, Duration timeElapsed) {
        this.name = name;
        this.category = category;
        this.state = state;
        this.comments = comments;
        df = new SimpleDateFormat("dd-MM-yyyy");
        this.dateCompleted = completed.getTime();
        this.timeElapsed = timeElapsed.getSeconds();
        this.dateStarted = started.getTime();
        save();
    }

    public Date getDateStarted() {
        return new Date(dateStarted);
    }

    public void setDateStarted(Date dateStarted) {
        this.dateStarted = dateStarted.getTime();
        save();
    }

    public Date getDateCompleted() {
        return new Date(dateCompleted);
    }

    public void setDateCompleted(Date dateCompleted) {
        this.dateCompleted = dateCompleted.getTime();
        save();
    }

    public Project getProject() {
        if(project == null){
            return new Project();
        }
        return project;
    }

    public Duration getTimeElapsed() {
        return Duration.ofSeconds(timeElapsed);
    }

    public void setTimeElapsed(Duration timeElapsed) {
        this.timeElapsed = timeElapsed.getSeconds();
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

    @Override
    public String toString() {
        return name;
    }
}